package seed.python.matplotlib.generator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record PythonParameter(String name, boolean isMandatory, String type, String documentation) {

    public PythonParameter {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(documentation);
    }
    
    public String toJavadocParameter(int indentationLevel) {
        var indent = " ".repeat(indentationLevel);
        var param = name.transform(PythonParameter::escapeJavadoc);
        var docuLineStart = "\n" + indent + " * " + " ".repeat("@param ".length() + param.length() + " ".length());
        var docu = documentation.lines().map(String::trim).map(PythonParameter::escapeJavadoc).collect(Collectors.joining(docuLineStart));
        
//        System.out.println("========================");
//        System.out.println(docu);
//        System.exit(1);
        
        return "%s * @param %s %s<br>%s".formatted(indent, param, type.transform(PythonParameter::escapeJavadoc),
                docu);
    }

    public static String toJavadocReturn(int indentationLevel, List<PythonParameter> params) {
        Objects.requireNonNull(params);

        var indent = " ".repeat(indentationLevel);
        
        if (params.stream().allMatch(param -> (param.name() + param.type() + param.documentation()).isBlank())) {
            return "";
        } else if (params.size() == 1) {
            var docuLineStart = "\n" + indent + " * "
                    + " ".repeat("@return ".length() + params.get(0).name.length() + " ".length());
            var docu = params.get(0).documentation.lines().map(String::trim).map(PythonParameter::escapeJavadoc)
                    .collect(Collectors.joining(docuLineStart));
            return "%s * @return %s %s<br>%s".formatted(indent, params.get(0).name,
                    params.get(0).type.transform(PythonParameter::escapeJavadoc), docu);
        }
        
        StringBuilder multiParamReturnParamNames = new StringBuilder("(");
        multiParamReturnParamNames.append(params.stream().filter(Objects::nonNull).map(PythonParameter::name)
                .map(PythonParameter::escapeJavadoc).collect(Collectors.joining(",")));
        multiParamReturnParamNames.append(")");
        
        StringBuilder multiParamReturnParamTypes = new StringBuilder("(");
        multiParamReturnParamTypes.append(params.stream().filter(Objects::nonNull).map(PythonParameter::type)
                .map(PythonParameter::escapeJavadoc).collect(Collectors.joining(",")));
        multiParamReturnParamTypes.append(")");
        
        var docuLineStart = "\n" + indent + " * " + " ".repeat("@return ".length() + " ".length());
        
        var multiParamReturnParamDocu = params.stream().filter(Objects::nonNull)
                .map(PythonParameter::documentation)
                .flatMap(String::lines)
                .map(String::trim)
                .map(PythonParameter::escapeJavadoc)
                .collect(Collectors.joining(docuLineStart));
        
        return "%s * @return %s %s<br>%s".formatted(indent, multiParamReturnParamNames,
                multiParamReturnParamTypes, multiParamReturnParamDocu);
    }

    static final String escapeJavadoc(String str) {
        return str.replace("<", "&lt;").replace(">", "&gt;").replace("{", "&#123;").replace("}", "&#125;");
    }
}
