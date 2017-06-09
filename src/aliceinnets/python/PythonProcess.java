package aliceinnets.python;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PythonProcess {
	
	Process process;
	
	BufferedWriter writer;
	BufferedReader inputStreamReader;
	BufferedReader errorStreamReader;
	
	public PythonProcess() { this(PythonScriptUtil.getPythonPath()); }
	
	
	public PythonProcess(String python) {
		try {
			process = new ProcessBuilder(python).start();
			writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void printMessages() throws IOException {
		String buffer = null;
		while ((buffer = inputStreamReader.readLine()) != null) {
			System.out.println(buffer);
		}
	}
	
	
	public void printErrorMessages() throws IOException {
		String buffer = null;
		while ((buffer = errorStreamReader.readLine()) != null) {
			System.out.println(buffer);
		}
	}
	
	
	public void write(String command) throws IOException, InterruptedException {
		writer.write(command+"\n");
		writer.flush();
		
	}

	
	public void write(String... commands) throws IOException, InterruptedException {
		for(String command : commands) {
			write(command);
		}
	}
	
	
	public void exec() throws IOException, InterruptedException {
		process.getOutputStream().close();
		printMessages();
		printErrorMessages();
		
		inputStreamReader.close();
		errorStreamReader.close();
		process.destroy();
	}
	
	
	public static void main(String[] args) throws Exception {
		PythonProcess python = new PythonProcess();
//		python.write("import IPython");
//		python.write("IPython.embed()");
		python.write("import numpy as np");
		python.write("import matplotlib.pyplot as plt");
		double x = 1.0;
		python.write("x = np.linspace(0,10,100)");
		python.write("y = "+x+"*np.sin(x)");
		python.write("print(x)");
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
//		python.write("y = np.sin(x)");
//		python.write("plt.plot(x,y)");
		python.write("plt.show()");
//		python.write("plt.close()");
		python.exec();
//		python.exit();
		
//		python.write("plt.plot(x,y)");
//		python.write("plt.show()");
//		python.exec();
	}


}
