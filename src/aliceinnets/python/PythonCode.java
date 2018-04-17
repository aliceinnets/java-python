package aliceinnets.python;

public class PythonCode {
	
	String code;
	
	public PythonCode() { }
	
	public PythonCode(String code) {
		this.code = code;
	}
	
	public String code() {
		return code;
	}
	
	@Override
	public String toString() {
		return code;
	}

}
