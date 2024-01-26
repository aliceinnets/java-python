package seed.python.matplotlib.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seed.python.core.PythonGrammar;

public record PythonMethod(String name, List<PythonParameter> returnParameters, List<PythonParameter> parameters,
        String documentation, String notes, String seeAlso, String examples, String references, String leftover) {

    public PythonMethod {
        Objects.requireNonNull(name);
        Objects.requireNonNull(returnParameters);
        Objects.requireNonNull(parameters);
        Objects.requireNonNull(documentation);
        Objects.requireNonNull(notes);
        Objects.requireNonNull(seeAlso);
        Objects.requireNonNull(examples);
        Objects.requireNonNull(references);
        Objects.requireNonNull(leftover);
    }

    public static final PythonMethod fromFullDocumentation(String documentationStyle, String name, String fullDocumentation) {
        Objects.requireNonNull(documentationStyle);
        Objects.requireNonNull(name);
        Objects.requireNonNull(fullDocumentation);

        return switch (documentationStyle) {
            case "numpydoc" -> parseNumpydoc(name, fullDocumentation);
            case "google" -> throw new UnsupportedOperationException("TBD");
            case "reST" -> throw new UnsupportedOperationException("TBD");
            default -> throw new IllegalArgumentException("Unexpected value: " + documentationStyle);
        };
    }

    private static final PythonMethod EMPTY = new PythonMethod("", List.of(), List.of(), "", "", "", "", "", "");

    private static final PythonMethod parseNumpydoc(String name, String fullDocumentation) {
        try {
            var returnParameters = extractReturnParameters(fullDocumentation);
            var parameters = extractParameters(fullDocumentation);
            var documentation = extractDocumentation(fullDocumentation);
            var notes = extractNotes(fullDocumentation);
            
            var methodName = extractMethodName(fullDocumentation);
            if (!name.equals(methodName)) {
                notes += System.lineSeparator().repeat(2)
                        + "Note that the method name deviates from the description (which is for {@link #" + methodName
                        + "}). This is most likely due to " + name + " being an alias for " + methodName + ".";
            }
            
            var seeAlso = extractSeeAlso(fullDocumentation);
            var examples = extractExamples(fullDocumentation);
            var references = extractReferences(fullDocumentation);
            var leftover = extractLeftover(fullDocumentation);
            return new PythonMethod(name, returnParameters, parameters, documentation, notes, seeAlso, examples,
                    references, leftover);
        } catch (IllegalArgumentException iae) {
            return empty();
        }
    }

    public static final PythonMethod empty() {
        return EMPTY;
    }
    
    private static final Pattern METHOD_NAME_PATTERN = Pattern.compile("Python Library Documentation: function (?<methodName>\\w*) in module");

    
    private static final List<String> SECTIONS = List.of("Returns{0,1}", "Other Parameters{0,1}", "Notes{0,1}", "Examples{0,1}", "See Also",
            "Parameters{0,1}", "References{0,1}", "Raises{0,1}");
    private static final Pattern END_PATTERN = Pattern.compile("^(?<endSection>\\s*(" + String.join("|", SECTIONS) + "))\\s*-+?$",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    
    static String extractMethodName(String fullDocumentation) {
        Objects.requireNonNull(fullDocumentation);

        var matcher = METHOD_NAME_PATTERN.matcher(fullDocumentation);
        if (matcher.find()) {
            return matcher.group("methodName");
        }

        throw new IllegalArgumentException("Unable to find method name in\n" + fullDocumentation);
    }


    
    private static final String extractSection(String section, String str) {
        // unfortunately, using a single RegExp is prone to catastrophic backtracking,
        // so we apply two RegExps that are more simple to obtain the same data,
        // although at the cost of a less strict matching pattern
        
        var startPattern = Pattern.compile("^(?<startSection>\\s*" + section + "\\s*-+\\s*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        var matcher = startPattern.matcher(str);
        if (matcher.find()) {
            int endOfStart = matcher.end();
            
            matcher = END_PATTERN.matcher(str.substring(endOfStart));
            if (matcher.find()) {
                return str.substring(endOfStart, endOfStart + matcher.start());
            }
            
            return str.substring(endOfStart);
        }
        
        return "";
    }

    private static List<PythonParameter> extractReturnParameters(String fullDocumentation) {
        
        // first extract the return section, if we find one
        // then (try to) take it apart
        String returnsSection = extractSection("Returns{0,1}", fullDocumentation);
        
        // TODO add Other Parameters
        
//        var parameterPatterns = Pattern.compile("^\\s{0,4}(?<parameters>\\S.*?)\\s{0,1}:\\s{0,1}(?<types>.*)\\s*$", Pattern.MULTILINE);
        var parameterPatterns = Pattern.compile("^\\s{0,4}(?<parameterInfo>\\S.*)$", Pattern.MULTILINE);
        var matcher = parameterPatterns.matcher(returnsSection);
        var params = new ArrayList<PythonParameter>();
        while (matcher.find()) {
            String parameterInfo = matcher.group("parameterInfo");
            var parameterInfoSplitter = Pattern.compile("(?<parameters>\\S.*?)\\s{0,1}:\\s{0,1}(?<types>.*)\\s*");
            var splitter = parameterInfoSplitter.matcher(parameterInfo);
            String joinedParameters;
            String types;
            if (splitter.find()) {
                joinedParameters = splitter.group("parameters");
                types = splitter.group("types");
            } else {
                joinedParameters = parameterInfo;
                types = "";
            }
            
            String[] parameters;
            if (joinedParameters.startsWith("(") && joinedParameters.endsWith(")")) {
                parameters = new String[] { joinedParameters };
            } else {
                parameters = joinedParameters.split("\\s*,\\s*");
            }
            
            // determine documentation
            var docuMatcher = parameterPatterns.matcher(returnsSection.substring(matcher.end()));
            int end = docuMatcher.find() ? docuMatcher.start() : returnsSection.substring(matcher.end()).length();
            String documentation = returnsSection.substring(matcher.end(), matcher.end() + end);
            
            for (String parameter : parameters) {
                var isParamMandatory = !types.contains("optional") && !types.contains("Optional");
                if (isParamMandatory) isParamMandatory = checkParamOptionality(parameter.trim(), fullDocumentation); // TODO this is not correct
                params.add(new PythonParameter(parameter.trim(), true, types, documentation));
            }
        }
        if (params.isEmpty()) {
            // last try: maybe it is just None, or another single-word? Most likely a type I think
            var singleWordPattern = Pattern.compile("[^,\\s]*");
            if (singleWordPattern.matcher(returnsSection.trim()).matches()) {
                params.add(new PythonParameter("", true, returnsSection.trim(), ""));
            }
        }
        
        if (params.isEmpty()) return List.of();

        return Collections.unmodifiableList(params);
    }

    private static boolean checkParamOptionality(String parameter, String fullDocumentation) {
        String signature = fullDocumentation.split("\\n")[2];
        // we need to strip * and ** if they are part of parameter
        parameter = parameter.replace("*", "");
        var signatureInfoPattern = Pattern.compile("\\w*\\(.*?(?<parameter>\\*{0,2}" + parameter + "\\s*?)={0,1}(?<default>[^\\,\\)]*)\\,{0,1}.*\\)\\w*", Pattern.MULTILINE);
        var matcher = signatureInfoPattern.matcher(signature);
        if (!matcher.find()) {
            return false; // either error in docu, or amongst the **kwargs
        }
        if (matcher.group("parameter").startsWith("**")) return false;
        return matcher.group("default").isBlank();
    }

    private static List<PythonParameter> extractParametersFromSection(String paramSection, String fullDocumentation) {
        String parameterSection = extractSection(paramSection, fullDocumentation);
//      var parameterPatterns = Pattern.compile("^\\s{0,4}(?<parameters>\\S.*?)\\s{0,1}:\\s{0,1}(?<types>.*)\\s*$", Pattern.MULTILINE);
      var parameterPatterns = Pattern.compile("^\\s{0,4}(?<parameterInfo>\\S.*)$", Pattern.MULTILINE);
      var matcher = parameterPatterns.matcher(parameterSection);
      var params = new ArrayList<PythonParameter>();
      while (matcher.find()) {
          String parameterInfo = matcher.group("parameterInfo");
          var parameterInfoSplitter = Pattern.compile("(?<parameters>\\S.*?)\\s{0,1}:\\s{0,1}(?<types>.*)\\s*");
          var splitter = parameterInfoSplitter.matcher(parameterInfo);
          String joinedParameters;
          String types;
          if (splitter.find()) {
              joinedParameters = splitter.group("parameters");
              types = splitter.group("types");
          } else {
              joinedParameters = parameterInfo;
              types = "";
          }
          
          String[] parameters;
          if (joinedParameters.startsWith("(") && joinedParameters.endsWith(")")) {
              parameters = new String[] { joinedParameters };
          } else {
              parameters = joinedParameters.split("\\s*,\\s*");
          }
          
          // determine documentation
          var docuMatcher = parameterPatterns.matcher(parameterSection.substring(matcher.end()));
          int end = docuMatcher.find() ? docuMatcher.start() : parameterSection.substring(matcher.end()).length();
          String documentation = parameterSection.substring(matcher.end(), matcher.end() + end);
          
          for (String parameter : parameters) {
              var isParamMandatory = !types.contains("optional") && !types.contains("Optional");
              if (isParamMandatory) isParamMandatory = checkParamOptionality(parameter.trim(), fullDocumentation);
              params.add(new PythonParameter(parameter.trim(), isParamMandatory, types, documentation));
          }
      }
      return params;
    }

    private static List<PythonParameter> extractParameters(String fullDocumentation) {
        var paramsFromParameterSection = extractParametersFromSection("Parameters{0,1}", fullDocumentation);
        var paramsFromOtherParameterSection = extractParametersFromSection("Other Parameters{0,1}", fullDocumentation);
        
        var params = new ArrayList<PythonParameter>();
        params.addAll(paramsFromParameterSection);
        params.addAll(paramsFromOtherParameterSection);
        
        // we check the signature if all parameters have been found - if not, we add the
        // missing parameters
        String signature = fullDocumentation.split("\\n")[2];
        // we need to find the parameters
        var paramStart = signature.indexOf('(') + 1;
        var paramsString = signature.substring(paramStart);
        var foundSignatureParams = new ArrayList<String>();
        int openBrackets = 0;
        var inSingleQuoteString = false;
        var inBiQuoteString = false;
        var isKwargDefaultValue = false;
        var paramBuilder = new StringBuilder();
        for (int i = 0; i < paramsString.length(); i++) {
            if (paramsString.charAt(i) == '\'') inSingleQuoteString = !inSingleQuoteString;
            if (paramsString.charAt(i) == '"') inBiQuoteString = !inBiQuoteString;
            if (paramsString.charAt(i) == '=' && !inSingleQuoteString && !inBiQuoteString) {
                isKwargDefaultValue = true;
            }
            
            if ((paramsString.charAt(i) == ',' || paramsString.charAt(i) == ')') && openBrackets == 0 && !inSingleQuoteString && !inBiQuoteString) { // <= 0 so we catch the final close
                // we also skip * and ** args without any further info
                if (!paramBuilder.toString().trim().matches("\\**")) {
                    foundSignatureParams.add(paramBuilder.toString().trim());
                }
                paramBuilder.setLength(0);
                isKwargDefaultValue = false;
            } else if (!isKwargDefaultValue) {
                paramBuilder.append(paramsString.charAt(i));
            }
            if (paramsString.charAt(i) == '(') openBrackets++;
            if (paramsString.charAt(i) == ')') openBrackets--;
        }
        
        // we have to check for these cases:
        // 1. "arg" in params, "arg" in foundSignatureParams
        // 2. "arg" in params, "*arg" in foundSignatureParams
        // 3. "arg" in params, "**arg" in foundSignatureParams
        // 4. "*arg" in params, "arg" in foundSignatureParams
        // 5. "*arg" in params, "*arg" in foundSignatureParams
        // 6. "*arg" in params, "**arg" in foundSignatureParams
        // 7. "**arg" in params, "arg" in foundSignatureParams
        // 8. "**arg" in params, "*arg" in foundSignatureParams
        // 9. "**arg" in params, "**arg" in foundSignatureParams
        BiPredicate<String, String> lenientStarChecker = (s1, s2) -> Pattern.matches("\\*{0,2}" + s1.replace("*", ""), s2);
                
        foundSignatureParams.stream()
                .filter(s -> params.stream().noneMatch(param -> lenientStarChecker.test(s, param.name())))
                .map(s -> new PythonParameter(s, false, "n/a", "undocumented"))
                .forEach(params::add);

        if (params.isEmpty()) return List.of();
        
        return Collections.unmodifiableList(params);
    }

    private static String extractDocumentation(String fullDocumentation) {
        String[] lines = fullDocumentation.split("\\n");
        lines = Arrays.copyOfRange(lines, 3, lines.length);
        String joinedLinesWithoutSignature = String.join("\n", lines);
        
        var matcher = END_PATTERN.matcher(joinedLinesWithoutSignature);
        if (matcher.find()) {
            return joinedLinesWithoutSignature.substring(0, matcher.start("endSection"));
        }
        
        return joinedLinesWithoutSignature;
    }

    private static String extractNotes(String fullDocumentation) {
        return extractSection("Notes{0,1}", fullDocumentation);
    }

    private static String extractSeeAlso(String fullDocumentation) {
        return extractSection("See Also", fullDocumentation);
    }

    private static String extractExamples(String fullDocumentation) {
        return extractSection("Examples{0,1}", fullDocumentation);
    }

    private static String extractReferences(String fullDocumentation) {
        return extractSection("References{0,1}", fullDocumentation);
    }

    private static String extractLeftover(String fullDocumentation) {
        // TODO Auto-generated method stub
        return "";
    }

    public final String toJavaSource(String module, int indentationLevel, UnaryOperator<String> transform) {
        String indent = " ".repeat(indentationLevel);
        StringBuilder method = new StringBuilder();
        method.append(indent + "/**\n");
        
        String generalDocu = documentation.lines().map(transform).map(String::trim).collect(Collectors.joining("\n" + indent + " * "));
        if (!documentation.isBlank()) {
            method.append(indent + " * " + generalDocu);
        }
        
        String generalNotes = notes.lines().map(transform).map(String::trim).collect(Collectors.joining("\n" + indent + " * "));
        if (!notes.isBlank()) {
            method.append("\n" + indent + " * <p>\n");
            method.append(indent + " * <em>Notes:</em><br>\n");
            method.append(indent + " * " + generalNotes);
        }
        
        String params = parameters.stream().map(param -> param.toJavadocParameter(indentationLevel)).map(transform).collect(Collectors.joining("\n"));
        if (!parameters.isEmpty()) {
            method.append("\n" + indent + " * \n");
            method.append(params);
        }

        if (!returnParameters.isEmpty()) {
            var returnInfo = PythonParameter.toJavadocReturn(indentationLevel, returnParameters).transform(transform);
            if (!returnInfo.isBlank()) {
                method.append("\n" + indent + " * \n");
                method.append(returnInfo);
            }
        }
        
        method.append("\n");
        method.append(indent + " */\n");
        
        var isReturnTypeVoid = returnParameters.isEmpty() || (returnParameters.size() == 1 && PythonGrammar.None.equals(returnParameters.get(0).type()));
        var returnType = isReturnTypeVoid ? "void" : "Object";
        var mandatoryArgs = parameters.stream().filter(PythonParameter::isMandatory).map(param -> "Object " + param.name().trim().replace("*", "")).collect(Collectors.joining(", "));
        var optionalArgs = parameters.stream().anyMatch(Predicate.not(PythonParameter::isMandatory)) ? "Object... args" : "";
        var hasNoArgs = optionalArgs.isBlank() && mandatoryArgs.isBlank();
        var hasOneTypeOfArgs = optionalArgs.isBlank() || mandatoryArgs.isBlank();
        var args = mandatoryArgs + (hasOneTypeOfArgs ? "" : ", ") + optionalArgs;
        method.append(indent + "public final %s %s(%s) {\n".formatted(returnType, name.trim(), args));
        
        var mandatoryArgInstances = parameters.stream().filter(PythonParameter::isMandatory).map(param -> "PythonGrammar.toPythonArgs(" + param.name().replace("*", "") + ")").collect(Collectors.joining(","));
        var optionalArgInstances = optionalArgs.isBlank() ? "" : "(args!=null ? PythonGrammar.toPythonArgs(args) : \"\")";
        method.append(indent.repeat(2) + "write(\"" + module + "." + name + (hasNoArgs ? "()\");\n" : "(\"+" + mandatoryArgInstances + (hasOneTypeOfArgs ? "" : "+\",\"+") + optionalArgInstances + "+\")\");\n"));
        if (!isReturnTypeVoid) method.append(indent.repeat(2) + "return null;\n"); // TODO return actually smth
        method.append(indent + "}\n");
        
        return method.toString();
    }
}
