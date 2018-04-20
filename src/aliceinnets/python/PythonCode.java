package aliceinnets.python;

import java.lang.reflect.Array;

import org.apache.commons.lang3.StringUtils;

public class PythonCode {
	
	String pythonCode;
	Object args;
	
	
	public PythonCode(String pythonCode) {
		this.pythonCode = pythonCode;
	}
	
	public PythonCode(String pythonCode, Object arg) {
		this.pythonCode = pythonCode;
		this.args = arg;
	}
	
	public PythonCode(String pythonCode, Object... args) {
		this.pythonCode = pythonCode;
		this.args = args;
	}
	
	
	public String toString() {
		int num = StringUtils.countMatches(pythonCode, "%s");
		if (args == null || num == 0) {
			return pythonCode;
		} else if (num == 1) {
			return String.format(pythonCode, Parser.toPythonArgs(args));
		} else {
			int length = Array.getLength(args);
			Object[] ret = new Object[length];
			for (int i = 0; i < length; i++) {
				Object arg = Array.get(args, i);
				ret[i] = Parser.toPythonArgs(arg);
			}
			return String.format(pythonCode, ret);
		}
	}
	
}
