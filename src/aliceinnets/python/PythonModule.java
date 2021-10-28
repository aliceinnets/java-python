package aliceinnets.python;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aliceinnets.util.OneLiners;

/**
 * TODO Return python output.
 * 
 * pythonModule.write("np.linspace(0, 10, 100)") - > return double array
 * pythonModule.get("a") - > return a
 * 
 * @author alice &lt;aliceinnets[at]gmail.com&gt;
 *
 */
public class PythonModule {
	
	public static final String COMMENT_PREFIX = "#";
	public static final String DEFAULT_HEADLINE = "#Auto generated python script";
	
	public static final String NUMPY = Parser.NUMPY;
	public static final String PYPLOT = "plt";
	
	private int headerLineNumber;
	private int importLineNumber;
	
	
	protected File script;
	protected ArrayList<String> scriptLines = new ArrayList<>();
	
	protected String python = PythonScriptUtil.getPythonPath();
	protected boolean print = true;
	protected boolean saveLog = false;
	
	
	public PythonModule() { this(null); }
	
	
	public PythonModule(String pathname) {
		if (pathname != null && !pathname.equals("")) {
			script = new File(pathname);
			OneLiners.mkdirs(script.getParent());
		} else {
			script = PythonScriptUtil.createNewFile();
		}
		
		headerLineNumber = 0;
		writeHeader(String.format("%s generated at %s", DEFAULT_HEADLINE, OneLiners.date()));
		write();
		
		importLineNumber = 2;
		importsAs("numpy", NUMPY);
		importsAs("matplotlib.pyplot", PYPLOT);
		write();
	}
	
	
	public String getLine(int lineNumber) {
		return scriptLines.get(lineNumber);
	}
	
	
	public void write() {
		write("");
	}
	
	
	public void write(String script) {
		scriptLines.add(script);
	}
	
	
	public void write(int lineNumber, String script) {
		scriptLines.add(lineNumber, script);
	}
	
	
	public void writeHeader(String script) {
		write(headerLineNumber, script);
		headerLineNumber++;
		importLineNumber++;
	}
	
	
	public void writeImports(String script) {
		write(importLineNumber, script);
		importLineNumber++;
	}
	
	
	public void imports(String module) {
		writeImports(String.format("import %s", module));
	}
	
	
	public void imports(String... modules) {
		Object[] codes = Arrays.asList(modules).stream().map(PythonCode::new).collect(Collectors.toList()).toArray(new Object[modules.length]);
		writeImports(String.format("import %s ", Parser.toPythonArgs(codes)));
	}
	
	
	public void importsAs(String module, String name) {
		writeImports(String.format("import %s as %s", module, name));
	}
	
	
	public void fromImports(String module, String identifier) {
		writeImports(String.format("from %s import %s", module, identifier));
	}
	
	
	public void fromImports(String module, String... identifiers) {
		Object[] codes = Arrays.asList(identifiers).stream().map(PythonCode::new).collect(Collectors.toList()).toArray(new Object[identifiers.length]);
		writeImports(String.format("from %s import %s", module, Parser.toPythonArgs(codes)));
	}
	
	
	public void fromImportsAs(String module, String identifier, String name) {
		writeImports(String.format("from %s import %s as %s", module, identifier, name));
	}
	
	
	public void saveScript(File script) {
		OneLiners.mkdirs(script.getParent());
		OneLiners.write(getScript(), script);
	}
	
	
	public void saveScript(String pathname) {
		saveScript(new File(pathname));
	}
	
	
	public void saveScript() {
		saveScript(script);
	}
	
	
	public void exec(File script) {
		saveScript(script);
		PythonScriptUtil.exec(python, script.getAbsolutePath(), print, saveLog);
		if (script.getParentFile().equals(new File(PythonScriptUtil.PATH))) {
			script.delete();
		}
	}
	
	
	public void exec(String pathname) {
		exec(new File(pathname));
	}
	
	
	public void exec() {
		exec(script);
	}


	public String getPathname() {
		return script.getAbsolutePath();
	}


	public void setPathname(String pathname) {
		script = new File(pathname);
		OneLiners.mkdirs(script.getParent());
	}
	
	
	public List<String> getLineScript() {
		return scriptLines;
	}


	public String getScript() {
		return String.join("\n", scriptLines);
	}


	public boolean isPrint() {
		return print;
	}


	public void setPrint(boolean print) {
		this.print = print;
	}


	public boolean isSaveLog() {
		return saveLog;
	}


	public void setSaveLog(boolean saveLog) {
		this.saveLog = saveLog;
	}
	
	
	public static void setPythonPath(String pythonPath) {
		PythonScriptUtil.setPythonPath(pythonPath);
	}

}
