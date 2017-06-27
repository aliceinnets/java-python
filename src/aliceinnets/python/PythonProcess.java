package aliceinnets.python;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PythonProcess {
	
	private String python;
	private Process process;
	private StringBuffer header = new StringBuffer();
	private BufferedWriter writer;
//	private BufferedReader inputStreamReader;
//	private BufferedReader errorStreamReader;

	public PythonProcess() { this(PythonScriptUtil.getPythonPath()); }
	
	
	public PythonProcess(String python) {
		this.python = python;
		init();
	}
	
	public void init() {
		try {
			process = new ProcessBuilder(python).start();
			writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			write(header.toString());
//			inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void printMessages() {
//		new Thread(new Runnable() {public void run() {try {
//			String buffer = null;
//			while ((buffer = inputStreamReader.readLine()) != null) {
//				System.out.println(buffer);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}}}).start();
//	}
//	
//	
//	public void printErrorMessages() {
//		new Thread(new Runnable() {public void run() {try {
//			String buffer = null;
//			while ((buffer = errorStreamReader.readLine()) != null) {
//				System.err.println(buffer);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}}}).start();
//	}
	
	
	public void write(String command) {
		try {
			writer.write(command);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void write(String... commands) {
		for(String command : commands) {
			write(command);
		}
	}
	
	
	public void imports(String module) {
		header.append(String.format("import %s\n", module));
		write(String.format("import %s\n", module));
	}
	
	
	public void imports(String module, String name) {
		header.append(String.format("import %s as %s\n", module, name));
		write(String.format("import %s as %s\n", module, name));
	}
	
	
	public void imports(String from, String module, String name) {
		header.append(String.format("from %s import %s as %s\n", from, module, name));
		write(String.format("from %s import %s as %s\n", from, module, name));
	}
	
	
	public void exec() throws IOException, InterruptedException {
		writer.close();
		init();
	}
	
	
	public static void main(String[] args) throws Exception {
		PythonProcess python = new PythonProcess();
		python.imports("numpy", "np");
		python.imports("matplotlib.pyplot", "plt");
//		python.write("import numpy as np");
//		python.write("import matplotlib.pyplot as plt");
		double x = 1.0;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("print(x)");
		python.write("plt.figure()");
		python.write("plt.plot(x,y)");
		++x;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("plt.plot(x,y)");
		python.write("print(x)");
//		python.exec();
		++x;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("plt.plot(x,y)");
		python.write("print(x)");
		++x;
		python.write("plt.show()");
		python.exec();
		
//		python.write("import numpy as np");
//		python.write("import matplotlib.pyplot as plt");
		x = 1.0;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("print(x)");
		python.write("plt.figure()");
		python.write("plt.plot(x,y)");
		++x;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("plt.plot(x,y)");
		python.write("print(x)");
		++x;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("plt.plot(x,y)");
		python.write("print(x)");
		++x;
		python.write("plt.show()");
		python.exec();
	}


}
