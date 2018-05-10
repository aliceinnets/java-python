package aliceinnets.python;

import java.io.File;
import java.io.IOException;

import aliceinnets.util.OneLiners;

public class PythonScriptUtil {
	
	public final static String DEFAULT_PATH = System.getProperty("user.home") + File.separator + "PythonScript" + File.separator;
	public final static String COMMENT = "#";
	
	public static String PATH = DEFAULT_PATH;
	public static String PYTHON_PATH_FILE = DEFAULT_PATH + "PYTHON_PATH.txt";
	
	public static String LOG_HEADER = COMMENT + "logging from " + PythonScriptUtil.class.getName()+"\n";
	public static String LOG_FOOTER = "";
	
	
	public final static File createNewFile() {
		OneLiners.mkdirs(PATH);
		
		long suffix = 0;
		try {
			while (true) {
				File file = new File(PATH, System.currentTimeMillis()+"_"+suffix+".py");
				if (file.createNewFile()) {
					return file;
				}
				suffix++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public final static void setPythonPath(String pythonPath) {
		OneLiners.mkdirs(PATH);
		OneLiners.write(pythonPath, PYTHON_PATH_FILE);
	}
	
	
	public final static String getPythonPath() {
		String python = OneLiners.read(PYTHON_PATH_FILE);
		return python == null ? "python" : python; 
	}
	
	
	public final static boolean exec(String pathname) {
		return exec(getPythonPath(), pathname, false, false);
	}
	
	
	public final static boolean exec(String pathname, boolean print) {
		return exec(getPythonPath(), pathname, print, false);
	}
	
	
	public final static boolean exec(String python, String pathname, boolean print, boolean saveLog) {
		long time = System.currentTimeMillis();
		String[] results = OneLiners.exec(python+" "+pathname);
		if(print && !results[0].equals("")) System.out.println(results[0]);
		
		boolean error = false;
		if(!results[1].equals("")) {
			error = true;
			System.err.println(results[1]);
		}
		
		if(saveLog) {
			StringBuffer log = new StringBuffer();
			log.append(LOG_HEADER);
			log.append(COMMENT+String.format(" exec: %s %s\n", python, pathname));
			log.append(COMMENT+String.format(" started at %s\n", OneLiners.date(time)));
			log.append(COMMENT+String.format(" ended at %s\n", OneLiners.date()));
			log.append("\n");
			
			log.append(results[0]);
			log.append(results[1]);
			
			OneLiners.write(log.toString(), PATH+OneLiners.getFileName(pathname)+"_"+time+".txt");
		}
		return !error;
	}

}
