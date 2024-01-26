package seed.python.matplotlib.generator;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 
 * 
 * The general modus operandi is as follows:
 * <ol>
 * <li>identify the functions in the documentation
 * <li>parse the identified function: the signature, description, parameters, returns, other parameters, notes and see also
 * <li>use the signature to extract the class name, method name and arguments (i.e., parameters)
 * <li>write the methods with as few as possible overloaded methods, taking into account cases with f=None, *args, **kwargs and *v
 * <li>extract the parameter name, type and the description from the parameters, returns and other parameters
 * <li>create the javadoc, including the following edge cases
 * <ul>
 * <li>missing arguments: note that these arguments are undocumented and refer to the notes and see also
 * <li>surplus parameter names that do not occur within the signature
 * <li>no arguments at all
 * </ul>
 * <li>make sure that the javadoc does not contain unnecessary line breaks
 * </ol>
 * 
 * 
 */
public final class MatplotlibApiGenerator implements Runnable {

    private final String documentation;

    public MatplotlibApiGenerator(String documentation) {
        this.documentation = Objects.requireNonNull(documentation);
    }

    @Override
    public void run() {
        extractPythonFunctions();
        
    }
    
    private void extractPythonFunctions() {
        
        List<String> functionDescs = new LinkedList<String>();
        StringBuilder function = new StringBuilder();
        for (var line : documentation.lines().toList()) {
            if (line.contains("<dl class=\"function\">")) {
                // a new function -> clear StringBuilder
                function.setLength(0); // more performant than reallocating
            } else if (line.contains("</dd></dl>")) {
                functionDescs.add(function.toString());
                continue;
            }

            function.append(line);
            function.append("\n");
        }

        System.out.println("-----------");
        System.out.println(functionDescs.get(0));
        System.out.println("-----------");
        // ??????
        functionDescs.remove(0);
        
//        System.out.println(functionDescs);
        
    }

    private static final String readUrl(String url) {
        try (InputStream in = new URL(url).openStream()) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("", e);
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
    }

    
    public static void main(String[] args) {
//        var docu = readUrl("https://matplotlib.org/2.0.2/api/pyplot_api.html");
        var docu = readUrl("https://matplotlib.org/stable/api/_as_gen/matplotlib.pyplot.acorr.html#matplotlib.pyplot.acorr");
        new MatplotlibApiGenerator(docu).run();
    }

}
