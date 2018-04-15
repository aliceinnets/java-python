package aliceinnets.python;

import java.util.function.Function;

public class Supplier<T> {
	
	java.util.function.Supplier<Object> supplier;
	Function<T, Object> function;
	T args;
	
	public Supplier(java.util.function.Supplier<Object> supplier) {
		this.supplier = supplier;
		this.function = null;
	}
	
	public Supplier(Function<T, Object> function, T arg) {
		this.function = function;
		this.args = arg;
		this.supplier = null;
	}
	
	public Object get() {
		if (function == null) {
			return supplier.get();
		} else {
			return function.apply(args);
		}
	}

}
