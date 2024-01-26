package seed.python.matplotlib.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seed.python.core.PythonScript;

abstract class PythonApiGenerator extends PythonScript implements Runnable {
    
    protected final String module;
    protected final String className;
    protected final Path temporaryFolder;

    protected PythonApiGenerator(String className, String module) {
        this.className = Objects.requireNonNull(className);
        this.module = Objects.requireNonNull(module);
        try {
            this.temporaryFolder = Files.createTempDirectory("python_java_api_generator_module_" + module + "_");
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create temporary directory", e);
        }
        temporaryFolder.toFile().deleteOnExit();
        System.out.println("Creating temporary directory at " + temporaryFolder.toFile().getAbsolutePath());
        
        fromImports("inspect", "getmembers", "isfunction");
        fromImports("pydoc", "doc");
    }

    protected abstract void defaultImports();

    @Override
    public final void run() {
        createDocumentationFiles();
        var methods = parseDocumentationFiles();
        var api = buildApi(methods);
        
        File file = new File("./src/main/java/seed/python/generated/" + className + ".java");
        mkdir(file.getParentFile().toPath());
        try (var writer = new PrintWriter(new FileWriter(file))) {
            writer.write(api);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save Java API for pythons " + module + " to file " + file.getAbsolutePath(), e);
        }
    }

    private String buildApi(List<PythonMethod> methods) {
        UnaryOperator<String> docStyleToJavadoc = str -> pythonBoldToJavaBold(str);
        
        return """
        package seed.python.generated;

        import seed.python.core.PythonGrammar;
        import seed.python.core.PythonScript;
        
        public final class %s extends PythonScript {

        %s
        }
        """.formatted(className, methods.stream().map(m -> m.toJavaSource(module, 4, docStyleToJavadoc)).collect(Collectors.joining("\n")));
    }

    private static final String pythonBoldToJavaBold(String str) {
        Pattern boldPattern = Pattern.compile("\\*(?<bold>\\w*?)\\*");
        Matcher matcher = boldPattern.matcher(str);
        int offset = 0; // we need this as we replace * with <b> or </b>
        StringBuilder newString = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group("bold").isBlank()) {
                continue;
            }
            
            newString.append(str.substring(0, matcher.start()));
            newString.append("<b>" + matcher.group("bold") + "</b>");
            
//            str = str.substring(matcher.end())
            
            
            
            str = str.substring(0, matcher.start()) + "<b>" + matcher.group("bold") + "</b>" + offset + str.substring(matcher.end());
            offset += "<b></b>".length() - "**".length();
        }
        return str;
    }

    protected final void createDocumentationFiles() {
        mkdir(temporaryFolder);

        System.out.println("Generating raw python documentation for " + module + " module");
        write("""
                funcs = dict(getmembers(%s, isfunction))
                for func in funcs:
                    if not func.startswith("_"):
                        with open(r'%s/' + func + '.txt', 'w', encoding='utf-8') as file:
                            doc(funcs[func], output=file)
                """.formatted(module, temporaryFolder.toFile().getAbsolutePath()));
        exec();
    }

    private List<PythonMethod> parseDocumentationFiles() {
        Map<String, String> unparsedFunctions;
        try (var files = Files.list(temporaryFolder)) {
            unparsedFunctions = files.filter(path -> path.toFile().getAbsolutePath().endsWith(".txt"))
                    .collect(Collectors.toMap(path -> path.getFileName().toString().replace(".txt", ""),
                            PythonApiGenerator::readString));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read file", e);
        }
        System.out.println("Found " + unparsedFunctions.size() + " methods");

        var methods = unparsedFunctions.entrySet().stream()
//                .filter(s -> s.getKey().equals("csd"))
                .map(docu -> PythonMethod.fromFullDocumentation(documentationStyle(), docu.getKey(), docu.getValue()))
                .filter(method -> !PythonMethod.empty().equals(method))
                .sorted(Comparator.comparing(PythonMethod::name))
                .toList();

        System.out.println("Discarded " + (unparsedFunctions.size() - methods.size())
                + " method(s) due to incomplete/unparsable information");
        
//        var bla = methods.stream().map(PythonMethod::name).toList();
//        unparsedFunctions.keySet().stream().filter(s -> !bla.contains(s)).forEach(System.out::println);
//        System.out.println(methods);
        return methods;
    }

    protected abstract String documentationStyle();

    private static final String readString(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read file @ " + path.toFile().getAbsolutePath(), e);
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
