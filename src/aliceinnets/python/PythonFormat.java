package aliceinnets.python;

import java.lang.reflect.Array;

import org.apache.commons.lang3.StringUtils;

public class PythonFormat {
	
	String format;
	Object args;
	
	
	public PythonFormat(String format) {
		this(format, null);
	}
	
	public PythonFormat(String format, Object arg) {
		this.format = format;
		this.args = arg;
	}
	
	public PythonFormat(String format, Object... args) {
		this.format = format;
		this.args = args;
	}
	
	
	public String toString() {
		int num = StringUtils.countMatches(format, "%s");
		if (args == null || num == 0) {
			return format;
		} else if (num == 1) {
			if (args instanceof Supplier) {
				return String.format(format, Parser.toPythonArgs(((Supplier) args).get()));
			} else {
				return String.format(format, Parser.toPythonArgs(args));
			}
		} else {
			int length = Array.getLength(args);
			String[] ret = new String[length];
			for (int i = 0; i < length; i++) {
				Object arg = Array.get(args, i);
				if (arg instanceof Supplier) {
					ret[i] = Parser.toPythonArgs(((Supplier) arg).get());
				} else {
					ret[i] = Parser.toPythonArgs(arg);
				}
			}
			return String.format(format, ret);
		}
	}
	
}
