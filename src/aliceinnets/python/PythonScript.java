package aliceinnets.python;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PythonScript {
	
	String format;
	List<Supplier<?>> suppliers = new ArrayList<Supplier<?>>();
	
	public PythonScript(String format, Supplier<?>... suppliers) {
		this.format = format;
		this.format += "\n";
		for (Supplier<?> supplier : suppliers) {
			this.suppliers.add(supplier);
		}
	}
	
	public void format(String format, Supplier<?>... suppliers) {
		this.format += format;
		this.format += "\n";
		for (Supplier<?> supplier : suppliers) {
			this.suppliers.add(supplier);
		}
	}
	
	public String toString() {
		Object[] args = new Object[suppliers.size()];
		for (int i = 0; i < args.length; i++) {
			args[i] = Parser.toPythonArgs(suppliers.get(i).get());
		}
		return String.format(format, args);
	}
	
	public static void main(String[] args) {
		Add add = new Add(1.0, 2.0);
		
		PythonScript script = new PythonScript("plt.plot(%s)", add::eval);
		System.out.println(script.toString());
		
		add.setArg1(5.0);
		
		System.out.println(script.toString());
		
		Add add2 = new Add(3.0, new double[] { 1.0, 2.0, 3.0 });
		
		script.format("plt.plot(%s, %s)", add::eval, add2::evalArray);
		
		System.out.println(script.format);
		System.out.println(script);
	}

}
