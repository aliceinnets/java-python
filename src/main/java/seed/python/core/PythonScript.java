package seed.python.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for handling execution of python scripts via Java. There might be
 * changes in the future once the foreign linker/memory APIs are out of their
 * incubator state (in particular, {@link #exec()} and the other execution
 * methods may become obsolete).
 */
public class PythonScript {

    /** The folder in which the temporary python script files are located. */
    public static final Path PYTHON_SCRIPT_FOLDER = Paths
            .get(System.getProperty("user.home") + File.separator + "PythonScript" + File.separator);

    /** The path to the file specifying which python executable to use. */
	public static final File PYTHON_PATH_FILE = new File(PYTHON_SCRIPT_FOLDER + "PYTHON_PATH.txt");

	/** The path of the python executable. */
	protected String python = getPythonPath();

	/** The file containing the python script. */
	protected File pythonScriptFile;

	private static final Logger logger = Logger.getLogger(PythonScript.class.getName());

	private final List<String> preamble = new ArrayList<>();
	private final List<String> imports = new ArrayList<>();
	private final List<String> importsAs = new ArrayList<>();
	private final List<String> fromImports = new ArrayList<>();
	private final List<String> fromImportsAs = new ArrayList<>();
	private final List<String> body = new ArrayList<>();
	
	/** Constructs a new PythonScript. */
    public PythonScript() {
        this(null);
    }

    /**
     * Constructs a new PythonScript, which will be saved at the given
     * {@code pathname}.
     * 
     * @param pathname the path to save the temporary python script file to. Use
     *                 {@code null} or a blank String to use a default temporary
     *                 file.
     */
	public PythonScript(String pathname) {
		if (pathname != null && !pathname.isBlank()) {
			pythonScriptFile = new File(pathname);
			mkdir(pythonScriptFile.getParentFile().toPath());
        } else {
            mkdir(PYTHON_SCRIPT_FOLDER);
            try {
                pythonScriptFile = Files.createTempFile(PYTHON_SCRIPT_FOLDER, "seed_python_", ".py").toFile();
            } catch (IOException e) {
                throw new IllegalStateException(
                        "Unable to create temporary python file @ " + pythonScriptFile.getAbsolutePath(), e);
            }
        }

		init();
	}

    /**
     * Clears the current state with respect to the script content (i.e., all the
     * imports, the {@link #preamble} and {@link #body}) and reinitializes the
     * required imports etc.
     */
	private void init() {
	    preamble.clear();
	    imports.clear();
	    importsAs.clear();
	    fromImports.clear();
	    fromImportsAs.clear();
	    body.clear();

	    defaultImports();
    }

    /**
     * Gets the default python imports.
     * 
     * @apiNote this method is intended to be overwritten by classes that extend
     *          this class. Allows to define standard imports that will always be
     *          added as the first imports. By default empty.
     */
	protected void defaultImports() {
	    // might be overwritten by child classes
	}

    /**
     * Sets the python path, i.e. the command to use as python executable, e.g.
     * {@code /usr/bin/python3}. This allows to handle cases e.g. on Linux in which
     * {@code python3} should be used, but {@code python} by default refers to
     * {@code python2}. It is not necessary to set if {@code python} does refer to
     * the desired python version and is executable on the shell.
     * 
     * @param pythonPath the python executable command, not null
     * @throws IllegalStateException if the python path file cannot be saved
     */
    public static final void setPythonPath(String pythonPath) {
        Objects.requireNonNull(pythonPath);

        mkdir(PYTHON_SCRIPT_FOLDER);
        try (var writer = new PrintWriter(new FileWriter(PYTHON_PATH_FILE))) {
            writer.write(pythonPath);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save python path to " + PYTHON_PATH_FILE.getAbsolutePath(), e);
        }
    }

    /**
     * Gets the python path, i.e. the command to use as python executable, e.g.
     * {@code /usr/bin/python3}.
     * 
     * @return the python executable command, by default {@code python}.
     */
    public static final String getPythonPath() {
        try {
            return Files.readString(PYTHON_PATH_FILE.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
           return "python";
        }
    }

    /**
     * Writes the given lines to the body of the script, i.e., after the preamble
     * and imports.
     * 
     * @param lines the liens to write, not null
     * @throws NullPointerException if lines is null
     */
	public void write(String... lines) {
	    Objects.requireNonNull(lines);
	    Stream.of(lines).filter(Objects::nonNull).forEach(body::add);
	}

    /**
     * Imports the given modules. This uses the following python syntax (on the
     * example of {@code numpy} and {@code scipy}):
     * <p>
     * {@code import numpy,scipy}
     * 
     * @param modules the python modules, not null. If an element is null it is
     *                discarded.
     * @throws NullPointerException if modules is null
     */
	public void imports(String... modules) {
	    Objects.requireNonNull(modules);
	    
	    String moduleExpression = Arrays.stream(modules).filter(Objects::nonNull).collect(Collectors.joining(","));
		imports.add(String.format("import %s", moduleExpression));
	}

    /**
     * Imports the given module as the given name. This uses the following python
     * syntax (on the example of {@code numpy} and its common abbreviation
     * {@code np}):
     * <p>
     * {@code import numpy as np}
     * 
     * @param module the python module, not null
     * @param name   the name as which to import the module, not null
     * @throws NullPointerException if either module or name is null
     */
	public void importsAs(String module, String name) {
	    Objects.requireNonNull(module);
	    Objects.requireNonNull(name);

	    importsAs.add(String.format("import %s as %s", module, name));
	}

    /**
     * Imports the given submodules from the specified module. This uses the
     * following python syntax (on the example of {@code os} and its submodule
     * {@code path}):
     * <p>
     * {@code from os import path}
     * 
     * @param module     the python module, not null
     * @param submodules the submodules to import from the module, not null. If an
     *                   element is null it is discarded.
     * @throws NullPointerException if either the module or submodules is null
     */
	public void fromImports(String module, String... submodules) {
	    Objects.requireNonNull(module);
	    Objects.requireNonNull(submodules);

	    String identifierExpression = Arrays.stream(submodules).filter(Objects::nonNull).collect(Collectors.joining(","));
		fromImports.add(String.format("from %s import %s", module, identifierExpression));
	}

    /**
     * Imports the given submodule from the specified module as the given name. This
     * uses the following python syntax (on the example of {@code matplotlib}, its
     * submodule {@code pyplot} and the commonly used abbreviation {@code plt}):
     * <p>
     * {@code from matplotlib import pyplot as plt}
     * 
     * @param module    the python module, not null
     * @param submodule the submodule to import from the module, not null
     * @param name      the the name as which to import the submodule, not null
     * @throws NullPointerException if either the module, the submodule or the name
     *                              is null
     */
	public void fromImportsAs(String module, String submodule, String name) {
	    Objects.requireNonNull(module);
	    Objects.requireNonNull(submodule);
	    Objects.requireNonNull(name);

		fromImportsAs.add(String.format("from %s import %s as %s", module, submodule, name));
	}
	
	/**
     * Gets the file to which the {@link #script() script} is written.
     * 
     * @return the script file, never null
     */
    public File scriptFile() {
        return pythonScriptFile;
    }

    
    /**
     * Gets the actual python script.
     * 
     * @return the script, never null
     */
    public String script() {
        return buildScript();
    }

    /**
     * Writes the script to {@link #scriptFile()}.
     * 
     * @throws IllegalStateException if the script could not be saved to
     *                               {@link #scriptFile()}
     */
    public void saveScript() {
        saveScript(pythonScriptFile);
    }

    /**
     * Writes the script to a file at the specified file name.
     * 
     * @param fileName the file name to save the script to, not null
     * @throws NullPointerException  if {@code fileName} is null
     * @throws IllegalStateException if the script could not be saved to
     *                               {@code fileName}
     */
    public void saveScript(String fileName) {
        Objects.requireNonNull(fileName);
        saveScript(new File(fileName));
    }
	
    /**
     * Writes the script to the specified file.
     * 
     * @param file the file to save the script to, not null
     * @throws NullPointerException  if {@code file} is null
     * @throws IllegalStateException if the script could not be saved to
     *                               {@code file}
     */
    public void saveScript(File file) {
        Objects.requireNonNull(file);

        String script = buildScript();
        mkdir(file.getParentFile().toPath());
        try (var writer = new PrintWriter(new FileWriter(file))) {
            writer.write(script);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save python script to file " + file.getAbsolutePath(), e);
        }
    }

    /**
     * Runs the python script (blocking!).
     * 
     * @return the error code, i.e. 0 if the execution terminated normally and &gt;0
     *         if an error occurred
     * @apiNote Note that this method may become obsolete in a future release (once
     *          project Panama is fully integrated into Java, one could probably
     *          rather easily "talk" to python directly such that an intermediate
     *          script file may not be necessary anymore).
     */
    public int exec() {
        return exec(pythonScriptFile); 
    }

    /**
     * Runs the python script (blocking!).
     * 
     * @param fileName the file name to write the temporary python script to, not null
     * @return the error code, i.e. 0 if the execution terminated normally and &gt;0
     *         if an error occurred
     * @throws NullPointerException if fileName is null
     * @apiNote Note that this method may become obsolete in a future release (once
     *          project Panama is fully integrated into Java, one could probably
     *          rather easily "talk" to python directly such that an intermediate
     *          script file may not be necessary anymore).
     */
	public int exec(String fileName) {
	    Objects.requireNonNull(fileName);
        return exec(new File(fileName));
    }

    /**
     * Runs the python script (blocking!).
     * 
     * @param file the file name to write the temporary python script to, not null
     * @return the error code, i.e. 0 if the execution terminated normally and &gt;0
     *         if an error occurred
     * @throws NullPointerException if file is null
     * @apiNote Note that this method may become obsolete in a future release (once
     *          project Panama is fully integrated into Java, one could probably
     *          rather easily "talk" to python directly such that an intermediate
     *          script file may not be necessary anymore).
     */
    public int exec(File file) {
        Objects.requireNonNull(file);
        return runPythonScript(file);
    }

    /**
     * Runs the python script (nonblocking, but requires a separate thread) in the
     * standard {@link ForkJoinPool#commonPool()}.
     * 
     * @return the CompletableFuture finally returning the error code, i.e. 0 if the
     *         execution terminated normally and &gt;0 if an error occurred
     * @apiNote Note that this method may become obsolete in a future release (once
     *          project Panama is fully integrated into Java, one could probably
     *          rather easily "talk" to python directly such that an intermediate
     *          script file may not be necessary anymore).
     */
    public final CompletableFuture<Integer> execAsync() {
        return CompletableFuture.supplyAsync(() -> runPythonScript(pythonScriptFile));
    }

    /**
     * Runs the python script (nonblocking, but requires a separate thread) using the
     * specified executor.
     * 
     * @param executor the executor to run the python code in, not null
     * @return the CompletableFuture finally returning the error code, i.e. 0 if the
     *         execution terminated normally and &gt;0 if an error occurred
     * @apiNote Note that this method may become obsolete in a future release (once
     *          project Panama is fully integrated into Java, one could probably
     *          rather easily "talk" to python directly such that an intermediate
     *          script file may not be necessary anymore).
     */
    public final CompletableFuture<Integer> execAsync(Executor executor) {
        Objects.requireNonNull(executor);
        return CompletableFuture.supplyAsync(() -> runPythonScript(pythonScriptFile), executor);
    }

	/**
     * Builds the script.
     * 
     * @return the built script. Never null.
     */
    private String buildScript() {
        StringBuilder script = new StringBuilder();
        script.append("# autogenerated at " + new Date());
        script.append(System.lineSeparator());

        String preamble = String.join(System.lineSeparator(), this.preamble);
        if (!preamble.isBlank()) {
            script.append(String.join(System.lineSeparator(), preamble));
            script.append(System.lineSeparator().repeat(2));
        }
        
        script.append("# imports");
        script.append(System.lineSeparator());
        for (var imports : List.of(imports, importsAs, fromImports, fromImportsAs)) {
            String importString = String.join(System.lineSeparator(), imports);
            if (!importString.isBlank()) {
                script.append(importString);
                script.append(System.lineSeparator().repeat(2));
            }
        }

        script.append("# script body");
        script.append(System.lineSeparator());
        script.append(String.join(System.lineSeparator(), body));
        script.append(System.lineSeparator().repeat(2));
        
        return script.toString();
    }

    /**
     * Runs the python script.
     * 
     * @param file the file to save the script to. May not be null. Note that the
     *             file will be deleted after the execution.
     * @return the exit value
     * @throws IllegalStateException if an IO error occurs or the thread is
     *                               interrupted
     */
    private final int runPythonScript(File file) {
        Logger logger = Logger.getLogger(PythonScript.class.getName() + "-" + Thread.currentThread());
        logger.setLevel(PythonScript.logger.getLevel());

        saveScript(pythonScriptFile);

        ProcessBuilder pythonProcessBuilder = new ProcessBuilder(python, pythonScriptFile.getAbsolutePath());

        if (logger.isLoggable(Level.FINE)) {
            pythonProcessBuilder.inheritIO();
        }

        boolean success = true;
        try {
            Process python = pythonProcessBuilder.start();
            if (!logger.isLoggable(Level.FINE)) {
                // check std out
                try (BufferedReader br = new BufferedReader(new InputStreamReader(python.getInputStream()))) {
                    String msg = br.lines()
                            .filter(Objects::nonNull)
                            .collect(Collectors.joining(System.lineSeparator()));
                    if (!msg.isEmpty()) logger.info(msg);
                }

                // check the error stream
                try (BufferedReader br = new BufferedReader(new InputStreamReader(python.getErrorStream()))) {
                    String errorMsg = br.lines()
                            .filter(Objects::nonNull)
                            .collect(Collectors.joining(System.lineSeparator()));
                    success = errorMsg.isBlank();
                    if (!success) logger.severe(errorMsg);
                }
            }
            return python.waitFor();
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(ie);
        } finally {
            if (success && !file.delete()) {
                logger.warning(() -> "Unable to delete python script file at " + file.getAbsolutePath());
            }
        }
    }
    
    /**
     * Makes the specified directory.
     * 
     * @param dir the directory to create. May not be null and may not point to an
     *            existing non-directory (it is fine if the directory already
     *            exists).
     * @throws NullPointerException if the given {@code dir} is null
     * @throws RuntimeException     if an IO exception occurs
     */
    private static final void mkdir(Path dir) {
        Objects.requireNonNull(dir);
        try {
            Files.createDirectories(dir);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create directory " + dir, e);
        }
    }
}
