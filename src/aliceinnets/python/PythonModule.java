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
	protected StringBuffer script;
	protected boolean print = true;
	
	
	public PythonModule() {
		this(PythonScriptUtil.DEFAULT_PATH+System.nanoTime()+".py", null);
	}
	
	
	public PythonModule(String pathname) {
		this(pathname, null);
	}
	
	
	public PythonModule(String pathname, String header) {
		if(pathname != null && !pathname.equals("")) {
			this.pathname = pathname;
		}
		
		this.script = new StringBuffer(DEFAULT_HEADER);
		write(COMMENT+"generated at "+System.nanoTime());
		if(header != null && !header.equals("")) {
			this.script.append(COMMENT+header);
		}
		
		write();
		init();
	}
	
	
	public static void setPythonPath(String pythonPath) {
		PythonScriptUtil.setPythonPath(pythonPath);
	}
	
	
	public void save() {
		String path = pathname.substring(0, pathname.lastIndexOf(File.separator));
		OneLiners.mkdirs(path);
		OneLiners.write(script.toString(), pathname);
	}
	
	
	public void saveAndExec() {
		save();
		PythonScriptUtil.exec(pathname, print);
	}
	
	
	public void exec() {
		saveAndExec();
		new File(pathname).delete();
	}
	
	
	public void init() {
		script.append("import numpy as np\n");
		script.append("import matplotlib.pyplot as plt\n");
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


	public String getPathname() {
		return pathname;
	}


	public void setPathname(String pathname) {
		this.pathname = pathname;
	}


	public String getScript() {
		return script.toString();
	}
	

}
