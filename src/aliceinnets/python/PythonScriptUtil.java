package aliceinnets.python;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import aliceinnets.util.OneLiners;

public class PythonScriptUtil {
	
	public final static String DEFAULT_PATH = System.getProperty("user.home") + File.separator + "PythonScript" + File.separator;
	public final static String PYTHON_PATH_FILE = DEFAULT_PATH + "PYTHON_PATH.txt";
	
	public final static String COMMENT = "#";
	public final static String LOG_HEADER = COMMENT + "Java exec python script log\n";
	public final static String LOG_FOOTER = "";
	
	
	public final static void setPythonPath(String pythonPath) {
		try {
			PrintWriter out = new PrintWriter(PYTHON_PATH_FILE);
			out.write(pythonPath);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public final static String getPythonPath() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(PYTHON_PATH_FILE));
			String python = in.readLine();
			in.close();
			return python;
		} catch (IOException e) {
			return "python";
		}
	}
	
	
	public final static boolean exec(String pathname) {
		return exec(getPythonPath(), pathname, false, false);
	}
	
	
	public final static boolean exec(String pathname, boolean print) {
		return exec(getPythonPath(), pathname, print, false);
	}
	
	
	public final static boolean exec(String python, String pathname, boolean print, boolean saveLog) {
		StringBuffer log = new StringBuffer();
		log.append(LOG_HEADER);
		log.append(COMMENT+"Python starts at "+System.nanoTime()+"\n");
		log.append(COMMENT+"exec: "+python+" "+pathname+"\n");
		
		String[] results = OneLiners.exec(python+" "+pathname);
		
		boolean error = false;
		if(!results[1].equals("")) {
			error = true;
		}
		
		log.append(results[0]);
		log.append(results[1]);
		log.append("\n");
		log.append(COMMENT+"Python ends at "+System.nanoTime()+"\n");
		
		if(saveLog) {
			String[] names = pathname.split(Pattern.quote(File.separator));
			OneLiners.write(log.toString(), DEFAULT_PATH+names[names.length-1]+"_"+System.nanoTime()+".txt");
		}
		return error;
	}

}