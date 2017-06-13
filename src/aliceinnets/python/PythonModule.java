package aliceinnets.python;

import java.io.File;
import aliceinnets.util.OneLiners;

/**
 * 
 * TODO Refer methods using lambda expressions. 
 * When exec() called methods will be evaluated
 * and the python script contains values of methods.
 * 
 * ex) pythonModule.write(PythonScript.format("plt.plot(%s, 'label'=%s)", object::eval, object::toString));
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
	
	public final static String COMMENT = "#";
	public final static String DEFAULT_HEADER = COMMENT + "Auto generated python script\n";
	
	
	protected String pathname;
	protected StringBuffer header = new StringBuffer(DEFAULT_HEADER);
	protected StringBuffer script = new StringBuffer();
	protected String python = PythonScriptUtil.getPythonPath();
	protected boolean print = true;
	protected boolean saveLog = false;
	
	
	public PythonModule() {
		this(PythonScriptUtil.DEFAULT_PATH+System.currentTimeMillis()+".py", null);
	}
	
	
	public PythonModule(String pathname) {
		this(pathname, null);
	}
	
	
	public PythonModule(String pathname, String header) {
		if(pathname != null && !pathname.equals("")) {
			this.pathname = pathname;
		}
		
		this.header.append(COMMENT+"generated at "+OneLiners.date()); 
		if(header != null && !header.equals("")) {
			this.header.append(COMMENT+header);
		}
		this.header.append("\n");
		
		init();
	}
	
	
	public static void setPythonPath(String pythonPath) {
		PythonScriptUtil.setPythonPath(pythonPath);
	}
	
	
	public void save() {
		String path = pathname.substring(0, pathname.lastIndexOf(File.separator));
		OneLiners.mkdirs(path);
		OneLiners.write(header.toString()+script.toString(), pathname);
	}
	
	
	public void saveAndExec() {
		save();
		PythonScriptUtil.exec(python, pathname, print, saveLog);
	}
	
	
	public void exec() {
		saveAndExec();
		new File(pathname).delete();
	}
	
	
	public void init() {
		imports("numpy", "np");
		imports("matplotlib.pyplot", "plt");
	}
	
	
	public PythonModule write() {
		this.script.append("\n");
		return this;
	}
	
	
	public PythonModule write(String script) {
		this.script.append(script);
		this.script.append("\n");
		return this;
	}
	
	
	public PythonModule write(String... scripts) {
		for(String script : scripts) {
			write(script);
		}
		return this;
	}
	
	
	public PythonModule imports(String module) {
		header.append(String.format("import %s\n", module));
		return this;
	}
	
	
	public PythonModule imports(String module, String name) {
		header.append(String.format("import %s as %s\n", module, name));
		return this;
	}
	
	
	public PythonModule imports(String from, String module, String name) {
		header.append(String.format("from %s import %s as %s\n", from, module, name));
		return this;
	}


	public String getPathname() {
		return pathname;
	}


	public void setPathname(String pathname) {
		this.pathname = pathname;
	}


	public String getScript() {
		return header.toString()+script.toString();
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
	

}
