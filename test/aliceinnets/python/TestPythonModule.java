package aliceinnets.python;

import java.io.File;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import aliceinnets.util.OneLiners;
import aliceinnets.util.Stopwatch;

public class TestPythonModule {
	
	static String outputPath = "test" + File.separator + TestPythonModule.class.getPackage().getName().replace(".", File.separator) + File.separator;

	@Before
	public void setUp() {
		//OneLiners.rmdirs(outputPath);
		//PythonScriptUtil.setPythonPath("/usr/local/bin/python3");
	}
	
	@Test
	public void testPythonScript() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("import numpy as np\n");
		buffer.append("import matplotlib.pyplot as plt\n");
		buffer.append("\n");
		
		buffer.append("x = np.linspace(0, 10, 100)\n");
		buffer.append("y = np.sin(x)\n");
		buffer.append("x[1] = None\n");
		buffer.append("x[2] = np.inf\n");
		buffer.append("x[3] = -np.inf\n");
		buffer.append("x[4] = np.nan\n");
		buffer.append("print(x)\n");
		buffer.append("plt.plot(x, y, label=None)\n");
		buffer.append("plt.savefig(r'"+outputPath+"test.pdf')\n");
		buffer.append("plt.show()\n");
		
		String pathname = outputPath+"test1.py";
		OneLiners.write(buffer.toString(), pathname);
		
		PythonScriptUtil.exec(pathname, true);
	}
	
	@Test
	public void testPythonModule() {
		String pathname = outputPath+"test2.py";
		System.out.println(pathname);
		
		IntStream.range(0, 10).parallel().forEach(i -> {
			Stopwatch stopwatch = new Stopwatch();
			
			stopwatch.tic();
			PythonModule module = new PythonModule(pathname);
			module.setSaveLog(true);
			
			module.writeHeader("# -*- coding: utf-8 -*-");
			module.imports("matplotlib");
			
			module.write("print('hello, world')");
			module.write("a = np.linspace(0, 10, 100)");
			module.write(String.format("print(%s)", 5.0));
			module.write("print(c)");
			
			module.exec();
			stopwatch.toc();
		});
	}
	
	@Test
	public void testPythonModule3() {
		String pathname = outputPath+"test3.py";
		System.out.println(pathname);
		
		Polynomial func = new Polynomial();
		func.a = 10;
		func.b = 5;
		
		PythonModule3 module = new PythonModule3(pathname);
		module.setSaveLog(true);
		
		module.imports("numpy", "matplotlib");
		
		module.write("print('hello, world')");
		module.write("a = np.linspace(0, 10, 100)");
		module.write(new PythonCode("print(%s)", new Supplier<>(func::xintercept)));
		module.write(new PythonCode("c = np.array(%s)", new Supplier<>(func::eval, OneLiners.linspace(0.0, 1.0, 11))));
		module.write("print(c)");
		
		module.exec();
		
		func.b = -5;
		
		String pathname3 = outputPath+"test3-1.py";
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
