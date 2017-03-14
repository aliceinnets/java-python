package aliceinnets.python;

import java.lang.reflect.Array;

public class Parser {
	
	
	public final static String toNumpyArgs(Object obj) {
		if(obj.getClass().isArray()) {
			Class<?> componentType = obj.getClass().getComponentType();
			if(!componentType.equals(Object.class)) {
				return toNumpyExpression(obj);
			} else {
				StringBuffer buffer = new StringBuffer();
				for(int i=0;i<Array.getLength(obj)-1;++i) {
					buffer.append(toNumpyExpression(Array.get(obj, i)));
					buffer.append(", ");
				}
				buffer.append(toNumpyExpression(Array.get(obj, Array.getLength(obj)-1)));
				return buffer.toString(); 
			}
		} else {
			return toNumpyExpression(obj);
		}
	}
	
	
	public final static String toNumpyExpression(Object obj) {
		if(obj == null) {
			return "";
		} else if(!obj.getClass().isArray()) {
			if(obj instanceof Double) {
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
				 */
				String string = ((String) obj).toLowerCase();
				boolean prefixSingle = string.startsWith("r") || string.startsWith("u") || string.startsWith("b");
				boolean prefixDouble = string.startsWith("ur") || string.startsWith("br");
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
				buffer.append(toNumpyExpression(Array.get(obj, i)));
				buffer.append(", ");
			}
			buffer.append(toNumpyExpression(Array.get(obj, Array.getLength(obj)-1)));
			buffer.append("]");
			return buffer.toString();
		}
	}
	

	public final static String toParameterName(String pythonParam) {
		if(pythonParam.matches("\\*\\*.+")) {
			return pythonParam.substring(2);
		} else if(pythonParam.matches("\\*.+")) {
			return pythonParam.substring(1);
		} else if(pythonParam.contains("=")){
			return pythonParam.split("\\=")[0];
		} else {
			return pythonParam;
		}
	}

}
