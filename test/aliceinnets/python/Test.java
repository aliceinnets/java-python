package aliceinnets.python;
import java.io.File;

import aliceinnets.util.OneLiners;
import junit.framework.TestCase;

public class Test extends TestCase {
	
	public void setUp() {
		OneLiners.rmdirs(PythonScriptUtil.DEFAULT_PATH);
		PythonScriptUtil.setPythonPath("/usr/local/bin/python3");
	}
	
	public void testPythonScript() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("import numpy as np\n");
		buffer.append("import matplotlib.pyplot as plt\n");
		buffer.append("\n");
		
		buffer.append("x = np.linspace(0, 10, 100)\n");
		buffer.append("y = np.sin(x)\n");
		buffer.append("plt.plot(x, y)\n");
		buffer.append("plt.savefig(r'"+PythonScriptUtil.DEFAULT_PATH+"/test.pdf')");
//		buffer.append("plt.show()\n");
		
		String pathname = "test"+File.separator+Test.class.getPackage().getName().replace(".", File.separator)+File.separator+"test.py";
		OneLiners.write(buffer.toString(), pathname);
		
		PythonScriptUtil.exec(pathname, true);
		
	}
	
	public void testPythonModule() {
		PythonModule module = new PythonModule();
		module.setSaveLog(true);
		
		module.write("print('hello, world')");
		module.write("a = np.linspace(0, 10, 100)");
		module.write("print(a)");
		module.write("print(b)");
		
		module.saveAndExec();
	}

}
