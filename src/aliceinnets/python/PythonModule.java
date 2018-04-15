package aliceinnets.python;

import java.io.File;
import java.util.ArrayList;

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
public class PythonModule {
	
	public final static String COMMENT_PREFIX = "#";
	public final static String DEFAULT_HEADLINE = "#Auto generated python script";
	public final static String DEFAULT_STARTLINE = "#Script body starts";
	
	public final static String NUMPY = "np";
	public final static String PYPLOT = "plt";
	
	
	protected String pathname;
	protected ArrayList<String> lineScript = new ArrayList<String>();
	
	protected String python = PythonScriptUtil.getPythonPath();
	protected boolean print = true;
	protected boolean saveLog = false;
	
	
	public PythonModule() {	this(null); }
	
	
	public PythonModule(String pathname) {
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
