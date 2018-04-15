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
		
		PythonModule module = new PythonModule(pathname);
		module.setSaveLog(true);
		
		module.write("print('hello, world')");
		module.write("a = np.linspace(0, 10, 100)");
		module.write(String.format("print(%s)", 5.0));
		module.write("print(c)");
		
		module.exec();
	}
	
	public void testPythonModule3() {
		String pathname = "test"+File.separator+getClass().getPackage().getName().replace(".", File.separator)+File.separator+"test3.py";
		System.out.println(pathname);
		
		Polynomial func = new Polynomial();
		func.a = 10;
		func.b = 5;
		
		PythonModule3 module = new PythonModule3(pathname);
		module.setSaveLog(true);
		
		module.write("print('hello, world')");
		module.write("a = np.linspace(0, 10, 100)");
		module.write(new PythonFormat("print(%s)", new Function<>(func::xintercept)));
		module.write(new PythonFormat("c = np.array(%s)", new Function<>(func::eval, OneLiners.linspace(0.0, 1.0, 11))));
		module.write("print(c)");
		
		module.exec();
		
		func.b = -5;
		
		String pathname3 = "test"+File.separator+getClass().getPackage().getName().replace(".", File.separator)+File.separator+"test3-1.py";
		System.out.println(pathname);
		
		module.exec(pathname3);
	}
	
	
	public static class Polynomial {
		double a, b;
		
		public double xintercept() {
			return a+b;
		}
		
		public double eval(double x) {
			return a*x+b;
		}
		
		public double[] eval(double[] x) {
			double[] ret = new double[x.length];
			for (int i = 0; i < ret.length; i++) {
				ret[i] = eval(x[i]);
			}
			return ret;
		}
		
		public double[] eval(double x1, double x2) {
			return new double[] { eval(x1), eval(x2) };
		}
		
	}

}
