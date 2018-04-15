package aliceinnets.python;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

import aliceinnets.util.OneLiners;

/**
 * 
 * TODO Evaluate python variables.
 * 
 * ex) pythonModule.write("a = np.linspace(0, 10, 100)");
 * pythonModule.get("a");
 * 
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
		
		imports("import numpy as "+NUMPY);
		imports("import matplotlib.pyplot as "+PYPLOT);
		
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
	
	
	public void imports(String line) {
		write(getStartlineNumber()-1, line);
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
