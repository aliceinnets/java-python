package aliceinnets.python;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import aliceinnets.util.OneLiners;

public class PythonModule {
	
	public final static String COMMENT = "#";
	public final static String HEADER = COMMENT + "Auto generated python script\n";
	
	
	protected String pathname;
	protected StringBuffer script;
	
	
	public PythonModule() {
		this(PythonScript.DEFAULT_PATH+System.nanoTime()+".py", null);
	}
	
	
	public PythonModule(String pathname) {
		this(pathname, null);
	}
	
	
	public PythonModule(String pathname, String header) {
		if(pathname != null && !pathname.equals("")) {
			this.pathname = pathname;
		}
		
		init();
		if(header != null) {
			this.script.append(header);
		} 
		
	}
	
	
	public void save() throws FileNotFoundException {
		String path = pathname.substring(0, pathname.lastIndexOf(File.separator));
		OneLiners.mkdirs(path);
		PrintWriter out = new PrintWriter(new File(pathname));
		out.write(script.toString());
		out.close();
	}
	
	
	public void saveAndExec() throws IOException {
		save();
		PythonScript.exec(pathname);
	}
	
	
	public void exec() throws IOException {
		save();
		PythonScript.exec(pathname);
		new File(pathname).delete();
	}
	
	
	public void init() {
		this.script = new StringBuffer(HEADER);
		write(COMMENT+"generated at "+System.nanoTime());
		
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


	public void setScript(String script) {
		if(script != null) {
			this.script.append(script);
		}
	}
	

}
