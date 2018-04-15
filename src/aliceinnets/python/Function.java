package aliceinnets.python;

import java.util.function.Supplier;

public class Function<T> {
	
	Supplier<Object> supplier;
	java.util.function.Function<T, Object> function;
	T args;
	
	public Function(Supplier<Object> supplier) {
		this.supplier = supplier;
		this.function = null;
	}
	
	public Function(java.util.function.Function<T, Object> function, T arg) {
		this.function = function;
		this.args = arg;
		this.supplier = null;
	}
	
	public Object eval() {
		if (function == null) {
			return supplier.get();
		} else {
			return function.apply(args);
		}
	}

}
