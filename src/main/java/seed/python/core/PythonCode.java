package seed.python.core;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Record for representing python code.
 * 
 * @param code the python code as a Java String, wherein required arguments are
 *             represented as {@code %s}. May not be null.
 * @param args the arguments to the {@code code}. May not be null.
 */
public record PythonCode(String code, Object... args) {

    /**
     * Canonical constructor.
     * 
     * @param code the python code as a Java String, wherein required arguments are
     *             represented as {@code %s}. May not be null.
     * @param args the arguments to the {@code code}. May not be null.
     * @throws NullPointerException     if either {@code code} or {@code args} are
     *                                  null
     * @throws IllegalArgumentException if the number of arguments given does not
     *                                  match the number of arguments expected in
     *                                  {@code code}
     */
    public PythonCode {
        Objects.requireNonNull(code);
        Objects.requireNonNull(args);

        // make sure the given number of args fits to the number of "%s" in the code
        int numArgsRequiredForCode = 0;
        for (int i = 0; i < code.length() - 1; i++) {
            if ("%s".equals(code.substring(i, i+2))) {
                numArgsRequiredForCode++;
            }
        }

        if (numArgsRequiredForCode != args.length) {
            throw new IllegalArgumentException("The given number of arguments (" + args.length
                    + ") is not the same as the number of arguments expected by the given code ("
                    + numArgsRequiredForCode + ")!");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Note that the {@code args} are converted to
     * {@link PythonGrammar#toPythonArgs(Object) python args} and are inserted at
     * their expected position in {@code code}.
     */
    @Override
	public String toString() {
	    if (args.length == 0) return code;

	    var pythonArgs = Stream.of(args).map(PythonGrammar::toPythonArgs).toArray();
	    return String.format(code, pythonArgs);
	}
}
