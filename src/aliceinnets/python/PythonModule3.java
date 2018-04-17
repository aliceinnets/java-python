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
public class PythonModule3 {
	
	public final static String COMMENT_PREFIX = "#";
	public final static PythonFormat DEFAULT_HEADLINE = new PythonFormat("#Auto generated python script");
	public final static PythonFormat DEFAULT_STARTLINE = new PythonFormat("#Script body starts");
	
	public final static String NUMPY = "np";
	public final static String PYPLOT = "plt";
	
	
	protected String pathname;
	protected ArrayList<PythonFormat> lineScript = new ArrayList<PythonFormat>();
	
	protected String python = PythonScriptUtil.getPythonPath();
	protected boolean print = true;
	protected boolean saveLog = false;
	
	
	public PythonModule3() {	this(null); }
	
	
	public PythonModule3(String pathname) {
		if(pathname != null && !pathname.equals("")) {
			this.pathname = pathname;
		} else {
			this.pathname = PythonScriptUtil.DEFAULT_PATH+System.currentTimeMillis()+".py";
		}
		
		write(DEFAULT_HEADLINE);
		write("#generated at "+OneLiners.date());
		write();
		write();
		
		write(DEFAULT_STARTLINE);
		write();
		
		importsAs("numpy", Parser.NUMPY);
		importsAs("matplotlib.pyplot", PYPLOT);
		
	}
	
	
	public String getLine(int lineNumber) {
		return lineScript.get(lineNumber).toString();
	}
	
	
	public int getStartlineNumber() {
		return lineScript.indexOf(DEFAULT_STARTLINE);
	}
	
	
	public void write() {
		write("");
	}
	
	
	public void write(String line) {
		write(new PythonFormat(line));
	}
	
	
	public void write(int lineNumber, String line) {
		write(lineNumber, new PythonFormat(line));
	}
	
	
	public void write(PythonFormat format) {
		lineScript.add(format);
	}
	
	
	public void write(int lineNumber, PythonFormat format) {
		lineScript.add(lineNumber, format);
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
	
	
	public void saveScript(String pathname) {
		String path = pathname.substring(0, pathname.lastIndexOf(File.separator));
		OneLiners.mkdirs(path);
		OneLiners.write(getScript(), pathname);
	}
	
	
	public void saveScript() {
		saveScript(pathname);
	}
	
	
	public void exec(String pathname) {
		saveScript(pathname);
		PythonScriptUtil.exec(python, pathname, print, saveLog);
		if (pathname.startsWith(PythonScriptUtil.DEFAULT_PATH)) new File(pathname).delete();
	}
	
	
	public void exec() {
		exec(pathname);
	}


	public String getPathname() {
		return pathname;
	}


	public void setPathname(String pathname) {
		this.pathname = pathname;
	}
	
	
	public ArrayList<PythonFormat> getLineScript() {
		return lineScript;
	}


	public String getScript() {
		return String.join("\n", lineScript.stream().map(PythonFormat::toString).collect(Collectors.toList()));
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
