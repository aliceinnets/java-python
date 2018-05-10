package aliceinnets.python;

import java.lang.reflect.Array;

public class Parser {
	
	/**
	 * Keywords
	 * The following identifiers are used as reserved words, or keywords of the language, 
	 * and cannot be used as ordinary identifiers. They must be spelled exactly as written here:
	 * 
	 * False      class      finally    is         return
	 * None       continue   for        lambda     try
	 * True       def        from       nonlocal   while
	 * and        del        global     not        with
	 * as         elif       if         or         yield
	 * assert     else       import     pass
	 * break      except     in         raise
	 * 
	 * label = '';
	 * 
	 * "valid_variable_name = ..."
	 * 
	 * valid_variabel_name
	 * A-Z, a-z, 0-9, _
	 */
	public final static String[] KEYWORDS = new String[] { 
			"False", "class", "finally", "is", "return", 
			"None", "continue", "for", "lambda", "try", 
			"True", "def", "from", "nonlocal", "while", 
			"and", "del", "global", "not", "with", 
			"as", "elif", "if", "or", "yield", 
			"assert", "else", "import", "pass", 
			"break", "except", "in", "raise" };
	public final static String False = "False";
	public final static String None = "None";
	public final static String True = "True";
	
	
	public final static boolean isKeyword(String string) {
		for (String keyword : KEYWORDS) {
			if (keyword.equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	
	public final static boolean isBoolean(String string) {
		return False.equals(string) || True.equals(string);
	}
	
	
	public final static boolean isNone(String string) {
		return None.equals(string);
	}
	
	
	public final static boolean isTuple(String string) {
		return string.startsWith("(") && string.endsWith(")");
	}
	
	
	public final static boolean isDictionary(String string) {
		return string.startsWith("{") && string.endsWith("}");
	}
	
	
	public final static boolean isList(String string) {
		return string.startsWith("[") && string.endsWith("]");
	}
	
	
	public final static boolean isValidName(String string) {
		return string.matches("[a-zA-Z_]\\w*") && !isKeyword(string);
	}
	
	/**
	 * Python 2.7.13
	 * 
	 * stringliteral   ::=  [stringprefix](shortstring | longstring)
	 * stringprefix    ::=  "r" | "u" | "ur" | "R" | "U" | "UR" | "Ur" | "uR"
	 *                      | "b" | "B" | "br" | "Br" | "bR" | "BR"
	 * shortstring     ::=  "'" shortstringitem* "'" | '"' shortstringitem* '"'
	 * longstring      ::=  "'''" longstringitem* "'''"
	 *                      | '"""' longstringitem* '"""'
	 * shortstringitem ::=  shortstringchar | escapeseq
	 * longstringitem  ::=  longstringchar | escapeseq
	 * shortstringchar ::=  <any source character except "\" or newline or the quote>
	 * longstringchar  ::=  <any source character except "\">
	 * escapeseq       ::=  "\" <any ASCII character>
	 * 
	 * Python 3.6.rc1
	 * 
	 * stringliteral   ::=  [stringprefix](shortstring | longstring)
	 * stringprefix    ::=  "r" | "u" | "R" | "U" | "f" | "F"
	 *                      | "fr" | "Fr" | "fR" | "FR" | "rf" | "rF" | "Rf" | "RF"
	 * shortstring     ::=  "'" shortstringitem* "'" | '"' shortstringitem* '"'
	 * longstring      ::=  "'''" longstringitem* "'''" | '"""' longstringitem* '"""'
	 * shortstringitem ::=  shortstringchar | stringescapeseq
	 * longstringitem  ::=  longstringchar | stringescapeseq
	 * shortstringchar ::=  <any source character except "\" or newline or the quote>
	 * longstringchar  ::=  <any source character except "\">
	 * stringescapeseq ::=  "\" <any source character>
	 * 
	 */
	public final static String[] STRING_PREFIX = new String[] { 
			"r", "u", "R", "U", "f", "F", 
			"fr", "Fr", "fR", "FR", "rf", "rF", "Rf", "RF" };
	public final static String[] STRING_QUOTATION_MARKS = new String[] { "'", "\"", "'''", "\"\"\"" };
	
	
	public final static boolean isString(String string) {
		for (int i = 0; i < STRING_PREFIX.length; i++) {
			if (string.startsWith(STRING_PREFIX[i])) {
				string = string.substring(STRING_PREFIX[i].length());
			}
		}
		for (int i = 0; i < STRING_QUOTATION_MARKS.length; i++) {
			if (string.startsWith(STRING_QUOTATION_MARKS[i]) && string.endsWith(STRING_QUOTATION_MARKS[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public final static String NUMPY = "np";
	public final static String NaN = String.format("%s.nan", NUMPY);
	public final static String POSITIVE_INFINITY = String.format("%s.inf", NUMPY);
	public final static String NEGATIVE_INFINITY = String.format("-%s.inf", NUMPY);
	
	/**
	 * Convert java object to multiple numpy expressions, 
	 * e.g. new double[] { Double.NaN, 0.0 } will be np.nan, 0.0.
	 * 
	 * @param obj
	 * @return
	 */
	public final static String toPythonArgs(Object obj) {
		if (obj == null) {
			return toPythonExpression(obj);
		} else if (obj.getClass().isArray()) {
			Class<?> componentType = obj.getClass().getComponentType();
			if (componentType.equals(Object.class)) {
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < Array.getLength(obj) - 1; ++i) {
					buffer.append(toPythonExpression(Array.get(obj, i)));
					buffer.append(", ");
				}
				buffer.append(toPythonExpression(Array.get(obj, Array.getLength(obj) - 1)));
				return buffer.toString();
			} else {
				return toPythonExpression(obj);
			}
		} else {
			return toPythonExpression(obj);
		}
	}
	
	/**
	 * Convert java object to a single numpy expression, 
	 * e.g. new double[] { Double.NaN, 0.0 } will be [np.nan, 0.0]. 
	 * 
	 * @param obj
	 * @return
	 */
	public final static String toPythonExpression(Object obj) {
		if (obj == null) {
			return None;
		} else if (!obj.getClass().isArray()) {
			if (obj instanceof Boolean) {
				if ((boolean) obj) {
					return True;
				} else {
					return False;
				}
			} else if (obj instanceof Double) {
				if (obj.equals(Double.NaN)) {
					return NaN;
				} else if (obj.equals(Double.NEGATIVE_INFINITY)) {
					return NEGATIVE_INFINITY;
				} else if (obj.equals(Double.POSITIVE_INFINITY)) {
					return POSITIVE_INFINITY;
				} else {
					return String.valueOf(obj);
				}
			} else if (obj instanceof Float) {
				if (obj.equals(Float.NaN)) {
					return NaN;
				} else if (obj.equals(Float.NEGATIVE_INFINITY)) {
					return NEGATIVE_INFINITY;
				} else if (obj.equals(Float.POSITIVE_INFINITY)) {
					return POSITIVE_INFINITY;
				} else {
					return String.valueOf(obj);
				}
			} else if (obj instanceof String) {
				String string = (String) obj;
				if (isString(string) || isTuple(string) || isDictionary(string) || isList(string)) {
					return string;
				} else {
					// Check keyword arguments cases, e.g. label = "Observations".
					if (string.contains("=")) {
						String[] strings = string.split("\\s*[=]\\s*");
						if (strings.length == 2 && isValidName(strings[0])) {
							return string;
						}
					}
					
					if (string.contains("\\")) {
						return "r'" + String.valueOf(obj) + "'";
					} else {
						return "'" + String.valueOf(obj) + "'";
					}
				}
			} else if (obj instanceof Supplier) {
				return toPythonExpression(((Supplier<?>) obj).get());
			} else if (obj instanceof PythonCode) {
				return obj.toString();
			} else {
				return String.valueOf(obj);
			}
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("[");
			for (int i = 0; i < Array.getLength(obj) - 1; ++i) {
				buffer.append(toPythonExpression(Array.get(obj, i)));
				buffer.append(", ");
			}
			buffer.append(toPythonExpression(Array.get(obj, Array.getLength(obj) - 1)));
			buffer.append("]");
			return buffer.toString();
		}
	}	

}
