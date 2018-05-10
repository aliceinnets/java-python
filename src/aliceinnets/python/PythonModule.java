package aliceinnets.python;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public final static String COMMENT_PREFIX = "#";
	public final static String DEFAULT_HEADLINE = "#Auto generated python script";
	public final static String DEFAULT_STARTLINE = "#Script body starts";
	
	public final static String NUMPY = Parser.NUMPY;
	public final static String PYPLOT = "plt";
	
	
	protected File script;
	protected ArrayList<String> lineScript = new ArrayList<String>();
	
	protected String python = PythonScriptUtil.getPythonPath();
	protected boolean print = true;
	protected boolean saveLog = false;
	
	
	public PythonModule() {	this(null); }
	
	
	public PythonModule(String pathname) {
		if (pathname != null && !pathname.equals("")) {
			script = new File(pathname);
			OneLiners.mkdirs(script.getParent());
		} else {
			script = PythonScriptUtil.createNewFile();
		}
		
		write(DEFAULT_HEADLINE);
		write("#generated at "+OneLiners.date());
		write();
		write();
		
		write(DEFAULT_STARTLINE);
		write();
		
		importsAs("numpy", NUMPY);
		importsAs("matplotlib.pyplot", PYPLOT);
		
	}
	
	
	public String getLine(int lineNumber) {
		return lineScript.get(lineNumber);
	}
	
	
	public int getStartlineNumber() {
		return lineScript.indexOf(DEFAULT_STARTLINE);
	}
	
	
	public void write() {
		write("");
	}
	
	
	public void write(String line) {
		lineScript.add(line);
	}
	
	
	public void write(int lineNumber, String line) {
		lineScript.add(lineNumber, line);
	}
	
	
	public void writeHead(String line) {
		write(getStartlineNumber()-1, line);
	}
	
	
	public void imports(String module) {
		writeHead(String.format("import %s", module));
	}
	
	
	public void imports(String... modules) {
		Object[] codes = Arrays.asList(modules).stream().map(PythonCode::new).collect(Collectors.toList()).toArray(new Object[modules.length]);
		writeHead(String.format("import %s ", Parser.toPythonArgs(codes)));
	}
	
	
	public void importsAs(String module, String name) {
		writeHead(String.format("import %s as %s", module, name));
	}
	
	
	public void fromImports(String module, String identifier) {
		writeHead(String.format("from %s import %s", module, identifier));
	}
	
	
	public void fromImports(String module, String... identifiers) {
		Object[] codes = Arrays.asList(identifiers).stream().map(PythonCode::new).collect(Collectors.toList()).toArray(new Object[identifiers.length]);
		writeHead(String.format("from %s import %s", module, Parser.toPythonArgs(codes)));
	}
	
	
	public void fromImportsAs(String module, String identifier, String name) {
		writeHead(String.format("from %s import %s as %s", module, identifier, name));
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
	
	
	public ArrayList<String> getLineScript() {
		return lineScript;
	}


	public String getScript() {
		return String.join("\n", lineScript);
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
