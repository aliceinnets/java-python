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
		
		String pathname = "test"+File.separator+getClass().getPackage().getName().replace(".", File.separator)+File.separator+"test1.py";
		OneLiners.write(buffer.toString(), pathname);
		
		PythonScriptUtil.exec(pathname, true);
		
	}
	
	public void testPythonModule() {
		String pathname = "test"+File.separator+getClass().getPackage().getName().replace(".", File.separator)+File.separator+"test2.py";
		System.out.println(pathname);
		
		Binary binary = new Binary();
		binary.a = 10;
		binary.b = 5;
		
		PythonModule3 module = new PythonModule3(pathname);
		module.setSaveLog(true);
		
		module.write("print('hello, world')");
		module.write("a = np.linspace(0, 10, 100)");
		module.write(new PythonFormat("print(%s)", new Supplier(binary::sum)));
		module.write(new PythonFormat("c = np.linsapce(%s, %s, %s)", 1.0, new Supplier(binary::sum), Parser.toPythonExpression(null)));
		module.write("print(b)");
		module.write("print(c)");
		
		module.exec();
		
		binary.b = -5;
		
		String pathname3 = "test"+File.separator+getClass().getPackage().getName().replace(".", File.separator)+File.separator+"test3.py";
		System.out.println(pathname);
		
		module.exec(pathname3);
	}
	
	
	public static class Binary {
		double a, b;
		
		public double sum() {
			return a+b;
		}
	}

}
