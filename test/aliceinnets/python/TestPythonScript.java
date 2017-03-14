package aliceinnets.python;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import aliceinnets.python.PythonScript;
import junit.framework.TestCase;

public class TestPythonScript extends TestCase {
	
	public void testPythonScript() throws IOException {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("import numpy as np\n");
		buffer.append("import matplotlib.pyplot as plt\n");
		buffer.append("\n");
		
		buffer.append("x = np.linspace(0, 10, 100)\n");
		buffer.append("y = np.sin(x)\n");
		buffer.append("plt.plot(x, y)\n");
//		buffer.append("plt.show()\n");
		
		String pathname = "test"+File.separator+TestPythonScript.class.getPackage().getName().replace(".", File.separator)+File.separator+"test.py";
		PrintWriter out = new PrintWriter(pathname);
		out.write(buffer.toString());
		out.close();
		
		PythonScript.exec(pathname);
		
	}

}
