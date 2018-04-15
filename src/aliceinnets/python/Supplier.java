package aliceinnets.python;

public class Supplier implements java.util.function.Supplier<Object> {
	
	java.util.function.Supplier<Object> supplier;
	
	public Supplier(java.util.function.Supplier<Object> supplier) {
		this.supplier = supplier;
	}
	
	public Object get() {
		return supplier.get();
	}

}
