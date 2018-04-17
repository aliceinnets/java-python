package aliceinnets.python;

import java.io.File;
import java.lang.reflect.Array;

public class Parser {
	
	public static final String None = "None";
	public static final String True = "True";
	public static final String False = "False";
	
	public static final String NUMPY = "np";
	public static final String NaN = "np.nan";
	public static final String POSITIVE_INFINITY = "np.inf";
	public static final String NEGATIVE_INFINITY = "-np.inf";
	
	
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
				}
			} else if (obj instanceof Float) {
				if (obj.equals(Float.NaN)) {
					return NaN;
				} else if (obj.equals(Float.NEGATIVE_INFINITY)) {
					return NEGATIVE_INFINITY;
				} else if (obj.equals(Float.POSITIVE_INFINITY)) {
					return POSITIVE_INFINITY;
				}
			} else if (obj instanceof String) {
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
				String string = ((String) obj).toLowerCase();
				//boolean prefixSingle = string.startsWith("r") || string.startsWith("u") || string.startsWith("b");
				//boolean prefixDouble = string.startsWith("ur") || string.startsWith("br");
				boolean prefixSingle = string.startsWith("r") || string.startsWith("u") || string.startsWith("f");
				boolean prefixDouble = string.startsWith("fr") || string.startsWith("rf");
				if (prefixSingle) {
					string = string.substring(1);
				} else if (prefixDouble) {
					string = string.substring(2);
				}
				if (string.startsWith("'") && string.endsWith("'")) {

				} else if (string.startsWith("'''") && string.endsWith("'''")) {

				} else if (string.startsWith("\"") && string.endsWith("\"")) {

				} else if (string.startsWith("\"\"\"") && string.endsWith("\"\"\"")) {

				} else {
					if (string.contains(File.separator)) {
						return "r'" + String.valueOf(obj) + "'";
					} else if (string.contains("=")) {

					} else if (string.startsWith("(") && string.endsWith(")")) {

					} else if (string.startsWith("[") && string.endsWith("]")) {

					} else {
						return "'" + String.valueOf(obj) + "'";
					}
				} 
			} else if (obj instanceof Supplier) {
				return toPythonExpression(((Supplier<?>) obj).get());
			} else if (obj instanceof PythonCode) {
				
			}
			return String.valueOf(obj);
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
