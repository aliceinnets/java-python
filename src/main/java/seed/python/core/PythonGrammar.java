package seed.python.core;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/** Class related to parsing python. */
public final class PythonGrammar {

    private PythonGrammar() {
        throw new IllegalStateException(PythonGrammar.class.getSimpleName() + " is a utility class!");
    }

    /** The prefix used to indicate a comment line. */
    public final static String COMMENT_PREFIX = "#";

    /** The String representing {@code false} in python. */
    public static final String False = "False";

    /** The String representing {@code true} in python. */
    public static final String True = "True";

    /**
     * The String representing {@code None} (which is kind of similar to
     * {@code null}) in python.
     */
    public static final String None = "None";

    /** The shorthand used for numpy. */
    public static final String NUMPY = "np";

    /**
     * The string representing {@link Double#NaN NaN} (the numpy version, i.e. with
     * {@value #NUMPY} prepended).
     */
    public static final String NaN = String.format("%s.nan", NUMPY);

    /**
     * The string representing {@link Double#POSITIVE_INFINITY +inf} (the numpy version, i.e. with
     * {@value #NUMPY} prepended).
     */
    public static final String POSITIVE_INFINITY = String.format("%s.inf", NUMPY);

    /**
     * The string representing {@link Double#NEGATIVE_INFINITY -inf} (the numpy version, i.e. with
     * {@value #NUMPY} prepended).
     */
    public static final String NEGATIVE_INFINITY = String.format("-%s.inf", NUMPY);

    /** The compiled pattern describing a valid identifier name in python. */
    private static final Pattern PYTHON_IDENTIFIER_GRAMMAR = Pattern.compile("[a-zA-Z_]\\w*");

    /** The compiled pattern allowing to split at "=". */
    private static final Pattern PYTHON_KWARG_SPLITTER = Pattern.compile("\\s*[=]\\s*");

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
	 */
    public static final Set<String> KEYWORDS = Set.of(False, "class", "finally", "is", "return", None, "continue",
            "for", "lambda", "try", True, "def", "from", "nonlocal", "while", "and", "del", "global", "not", "with",
            "as", "elif", "if", "or", "yield", "assert", "else", "import", "pass", "break", "except", "in", "raise");

    /**
     * The possible string prefixes in python.
     * <p>
     * Note that it is not a {@link Set} to make sure that methods iterating over
     * this list will check for the longer prefixes (e.g. "fr" vs "f") first.
     * <p>
     * For Python 2.7.13 the specification says:
     * <p>
     * <table>
     * <tr><td>stringliteral</td><td>::=</td><td>[stringprefix](shortstring | longstring)</td></tr>
     * <tr style="font-weight:bold"><td>stringprefix</td><td>::=</td><td>"r" | "u" | "ur" | "R" | "U" | "UR" | "Ur" | "uR" | "b" | "B" | "br" | "Br" | "bR" | "BR"</td></tr>
     * <tr><td>shortstring</td><td>::=</td><td>"'" shortstringitem* "'" | '"' shortstringitem* '"'</td></tr>
     * <tr><td>longstring</td><td>::=</td><td>"'''" longstringitem* "'''" | '"""' longstringitem* '"""'</td></tr>
     * <tr><td>shortstringitem</td><td>::=</td><td>shortstringchar | escapeseq</td></tr>
     * <tr><td>longstringitem</td><td>::=</td><td>longstringchar | escapeseq</td></tr>
     * <tr><td>shortstringchar</td><td>::=</td><td>&lt;any source character except "\" or newline or the quote&gt;</td></tr>
     * <tr><td>longstringchar</td><td>::=</td><td>&lt;any source character except "\"&gt;</td></tr>
     * <tr><td>escapeseq</td><td>::=</td><td>"\" &lt;any ASCII character&gt;</td></tr>
     * </table>
     * <p>
     * And for Python 3.6.rc1:
     * <p>
     * <table>
     * <tr><td>stringliteral  </td><td>::=</td><td>[stringprefix](shortstring | longstring)</td></tr>
     * <tr style="font-weight:bold"><td>stringprefix</td><td>::=</td><td>"r" | "u" | "R" | "U" | "f" | "F" | "fr" | "Fr" | "fR" | "FR" | "rf" | "rF" | "Rf" | "RF"</td></tr>
     * <tr><td>shortstring</td><td>::=</td><td>"'" shortstringitem* "'" | '"' shortstringitem* '"'</td></tr>
     * <tr><td>longstring</td><td>::=</td><td>"'''" longstringitem* "'''" | '"""' longstringitem* '"""'</td></tr>
     * <tr><td>shortstringitem</td><td>::=</td><td>shortstringchar | stringescapeseq</td></tr>
     * <tr><td>longstringitem</td><td>::=</td><td>longstringchar | stringescapeseq</td></tr>
     * <tr><td>shortstringchar</td><td>::=</td><td>&lt;any source character except "\" or newline or the quote&gt;</td></tr>
     * <tr><td>longstringchar</td><td>::=</td><td>&lt;any source character except "\"&gt;</td></tr>
     * <tr><td>stringescapeseq</td><td>::=</td><td>"\" &lt;any source character&gt;</td></tr>
     * </table>
     */
    public static final List<String> STRING_PREFIX = List.of("fr", "Fr", "fR", "FR", "rf", "rF", "Rf", "RF", "r", "u",
            "R", "U", "f", "F");
    
    /**
     * The python quotation marks used to indicate the start/end of a String.
     * <p>
     * Note that it is not a {@link Set} to make sure that methods iterating over
     * this list will check for the longer markers (e.g. "'''") first.
     * <p>
     * For Python 2.7.13 the specification says:
     * <p>
     * <table>
     * <tr><td>stringliteral</td><td>::=</td><td>[stringprefix](shortstring | longstring)</td></tr>
     * <tr><td>stringprefix</td><td>::=</td><td>"r" | "u" | "ur" | "R" | "U" | "UR" | "Ur" | "uR" | "b" | "B" | "br" | "Br" | "bR" | "BR"</td></tr>
     * <tr style="font-weight:bold"><td>shortstring</td><td>::=</td><td>"'" shortstringitem* "'" | '"' shortstringitem* '"'</td></tr>
     * <tr style="font-weight:bold"><td>longstring</td><td>::=</td><td>"'''" longstringitem* "'''" | '"""' longstringitem* '"""'</td></tr>
     * <tr><td>shortstringitem</td><td>::=</td><td>shortstringchar | escapeseq</td></tr>
     * <tr><td>longstringitem</td><td>::=</td><td>longstringchar | escapeseq</td></tr>
     * <tr><td>shortstringchar</td><td>::=</td><td>&lt;any source character except "\" or newline or the quote&gt;</td></tr>
     * <tr><td>longstringchar</td><td>::=</td><td>&lt;any source character except "\"&gt;</td></tr>
     * <tr><td>escapeseq</td><td>::=</td><td>"\" &lt;any ASCII character&gt;</td></tr>
     * </table>
     * <p>
     * And for Python 3.6.rc1:
     * <p>
     * <table>
     * <tr><td>stringliteral  </td><td>::=</td><td>[stringprefix](shortstring | longstring)</td></tr>
     * <tr><td>stringprefix</td><td>::=</td><td>"r" | "u" | "R" | "U" | "f" | "F" | "fr" | "Fr" | "fR" | "FR" | "rf" | "rF" | "Rf" | "RF"</td></tr>
     * <tr style="font-weight:bold"><td>shortstring</td><td>::=</td><td>"'" shortstringitem* "'" | '"' shortstringitem* '"'</td></tr>
     * <tr style="font-weight:bold"><td>longstring</td><td>::=</td><td>"'''" longstringitem* "'''" | '"""' longstringitem* '"""'</td></tr>
     * <tr><td>shortstringitem</td><td>::=</td><td>shortstringchar | stringescapeseq</td></tr>
     * <tr><td>longstringitem</td><td>::=</td><td>longstringchar | stringescapeseq</td></tr>
     * <tr><td>shortstringchar</td><td>::=</td><td>&lt;any source character except "\" or newline or the quote&gt;</td></tr>
     * <tr><td>longstringchar</td><td>::=</td><td>&lt;any source character except "\"&gt;</td></tr>
     * <tr><td>stringescapeseq</td><td>::=</td><td>"\" &lt;any source character&gt;</td></tr>
     * </table>
     */
    public static final List<String> STRING_QUOTATION_MARKS = List.of("'''", "\"\"\"", "'", "\"");

    /**
     * Checks whether the given String is a reserved keyword in python.
     * 
     * @param string the string to check
     * @return true if the string is a reserved keyword
     */
	public static final boolean isKeyword(String string) {
	    return KEYWORDS.contains(string);
	}
	
    /**
     * Checks whether the given String represents a boolean in python.
     * 
     * @param string the string to check
     * @return true if the string represents a boolean in python
     */
	public static final boolean isBoolean(String string) {
		return False.equals(string) || True.equals(string);
	}
	
	/**
     * Checks whether the given String represents {@code None} in python.
     * 
     * @param string the string to check
     * @return true if the string represents {@code None} in python
     */
	public static final boolean isNone(String string) {
		return None.equals(string);
	}
	
	/**
     * Checks whether the given String represents a tuple in python.
     * 
     * @param string the string to check
     * @return true if the string represents a tuple in python
     */
	public static final boolean isTuple(String string) {
		return string.startsWith("(") && string.endsWith(")");
	}
	
	/**
     * Checks whether the given String represents a dictionary in python.
     * 
     * @param string the string to check
     * @return true if the string represents a dictionary in python
     */
	public static final boolean isDictionary(String string) {
		return string.startsWith("{") && string.endsWith("}");
	}
	
	/**
     * Checks whether the given String represents a list in python.
     * 
     * @param string the string to check
     * @return true if the string represents a list in python
     */
	public static final boolean isList(String string) {
		return string.startsWith("[") && string.endsWith("]");
	}
	
    /**
     * Checks whether the given String represents a valid identifier name in python.
     * 
     * @param string the string to check
     * @return true if the string represents a valid identifier name in python
     */
	public static final boolean isValidIdentifier(String string) {
	    return PYTHON_IDENTIFIER_GRAMMAR.matcher(string).matches() && !isKeyword(string);
	}

	/**
	 * Checks whether the given String represents a python string.
	 * 
	 * @param string the string to check
	 * @return true if the string represents a valid python string
	 */
	public static final boolean isString(String string) {
	    String stringWithoutPrefixes = STRING_PREFIX.stream()
	            .filter(string::startsWith)
	            .findFirst()
	            .map(prefix -> string.substring(prefix.length()))
	            .orElse(string);

	    Predicate<String> isStringEnclosed = s -> stringWithoutPrefixes.startsWith(s) && stringWithoutPrefixes.endsWith(s);
	    return STRING_QUOTATION_MARKS.stream().anyMatch(isStringEnclosed);
	}
	
	
	
	
    /**
     * Converts a java object to multiple numpy expressions, e.g.
     * <code>new double[]{Double.NaN,0.0}</code> will become {@code np.nan,0.0}. If
     * {@code obj} is an Object array and an element is null the element is silently
     * discarded.
     * 
     * @param obj the object to convert
     * @return the object as multiple numpy expressions
     */
	public static final String toPythonArgs(Object obj) {
		if (obj == null) {
			return toPythonExpression(obj);
		} else if (obj.getClass().isArray()) {
			Class<?> componentType = obj.getClass().getComponentType();
			if (componentType.equals(Object.class)) {
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < Array.getLength(obj) - 1; ++i) {
				    var element = Array.get(obj, i);
				    if (element == null) continue;

					buffer.append(toPythonExpression(element));
					buffer.append(",");
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
     * Converts a java object to a single numpy expression, e.g.
     * <code>new double[]{Double.NaN,0.0}</code> will become {@code [np.nan,0.0]}.
     * 
     * @param obj the object to convert
     * @return the object as a single numpy expression
     */
	public static final String toPythonExpression(Object obj) {
		if (obj == null) {
			return None;
		} else if (obj.getClass().isArray()) {
		    return IntStream.range(0, Array.getLength(obj))
		             .mapToObj(i -> Array.get(obj, i))
		             .map(PythonGrammar::toPythonExpression)
		             .collect(Collectors.joining(", "));
		}
		
		if (obj instanceof Boolean b) {
			if (b.booleanValue()) {
				return True;
			}
			return False;
		} else if (obj instanceof Double d) {
			if (d.isNaN()) {
				return NaN;
			} else if (d.equals(Double.NEGATIVE_INFINITY)) {
				return NEGATIVE_INFINITY;
			} else if (d.equals(Double.POSITIVE_INFINITY)) {
				return POSITIVE_INFINITY;
			}
			return d.toString();
		} else if (obj instanceof Float f) {
			if (f.isNaN()) {
				return NaN;
			} else if (f.floatValue() == Float.NEGATIVE_INFINITY) {
				return NEGATIVE_INFINITY;
			} else if (f.floatValue() == Float.POSITIVE_INFINITY) {
				return POSITIVE_INFINITY;
			}
			return f.toString();
		} else if (obj instanceof String s) {
			if (isString(s) || isTuple(s) || isDictionary(s) || isList(s)) {
				return s;
			} else {
				// Check keyword arguments cases, e.g. label = "Observations".
			    String[] strings = PYTHON_KWARG_SPLITTER.split(s);
				if (strings.length > 1 && isValidIdentifier(strings[0])) {
					return s;
				}

				// Check if the string is a directory.
				if (s.contains("\\")) {
					return "r'" + s + "'";
				}
				return "'" + s + "'";
			}
		} else if (obj instanceof Supplier<?> supplier) {
			return toPythonExpression(supplier.get());
		} else if (obj instanceof PythonCode) {
			return obj.toString();
		}
		return String.valueOf(obj);
	}	
}
