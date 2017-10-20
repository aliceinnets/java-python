package aliceinnets.python;

import java.lang.reflect.Array;

public class Parser {
	
	/**
	 * Convert java object to multiple numpy expressions, 
	 * e.g. new double[] { Double.NaN, 0.0 } will be np.nan, 0.0.
	 * 
	 * @param obj
	 * @return
	 */
	public final static String toPythonArgs(Object obj) {
		String expression = toPythonExpression(obj);
		if (expression.startsWith("[") && expression.endsWith("]")) {
			return expression.substring(1, expression.length()-2);
		} else {
			return expression;
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
		if(obj == null) {
			return "";
		} else if(!obj.getClass().isArray()) {
			if(obj instanceof Boolean) {
				if((boolean) obj) {
					return "True";
				} else {
					return "False";
				}
			} else if(obj instanceof Double) {
				if(obj.equals(Double.NaN)) {
					return "np.NaN";
				} else if(obj.equals(Double.NEGATIVE_INFINITY)) {
					return "-np.Inf";
				} else if(obj.equals(Double.POSITIVE_INFINITY)) {
					return "np.Inf";
				}
			} else if(obj instanceof Float) {
				if(obj.equals(Float.NaN)) {
					return "np.NaN";
				} else if(obj.equals(Float.NEGATIVE_INFINITY)) {
					return "-np.Inf";
				} else if(obj.equals(Float.POSITIVE_INFINITY)) {
					return "np.Inf";
				}
			} else if(obj instanceof String) {
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
//				boolean prefixSingle = string.startsWith("r") || string.startsWith("u") || string.startsWith("b");
//				boolean prefixDouble = string.startsWith("ur") || string.startsWith("br");
				boolean prefixSingle = string.startsWith("r") || string.startsWith("u") || string.startsWith("f");
				boolean prefixDouble = string.startsWith("fr") || string.startsWith("rf");
				if(prefixSingle) {
					string = string.substring(1);
				} else if(prefixDouble) {
					string = string.substring(2);
				}
				if(string.startsWith("'") && string.endsWith("'")) {
					
				} else if(string.startsWith("'''") && string.endsWith("'''")) {
					
				} else if(string.startsWith("\"") && string.endsWith("\"")) {
					
				} else if(string.startsWith("\"\"\"") && string.endsWith("\"\"\"")) {
					
				} else {
					if (string.contains("=")) {
						
					} if(string.startsWith("(") && string.endsWith(")")) {
						
					} else if(string.startsWith("[") && string.endsWith("]")) {
						
					} else {
						return "'"+String.valueOf(obj)+"'";
					}
				}
			}
			return String.valueOf(obj);
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("[");
			for(int i=0;i<Array.getLength(obj)-1;++i) {
				buffer.append(toPythonExpression(Array.get(obj, i)));
				buffer.append(", ");
			}
			buffer.append(toPythonExpression(Array.get(obj, Array.getLength(obj)-1)));
			buffer.append("]");
			return buffer.toString();
		}
	}	

}
