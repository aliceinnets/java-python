package seed.python.matplotlib.generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import seed.python.core.PythonGrammar;
import seed.python.core.PythonScript;

/**
 * TODO instructions 
 * first take apart of functions using identifier
 * second take apart of signature, description, parameters, returns, other parameters, notes, and see also
 * third from signature, extract class name, function name and arguments
 * fourth write methods including overloaded taking into account cases f=None, *args, **kwargs and *v
 * fifth extract parameter name, type and description from parameters, returns and other parameters
 * sixth create javadoc taking into account following cases:
 * 	i) missing arguments, put undocumented with the links and refer notes and see also
 * 	ii) surplus parameter names which does not match among arguments
 * 	iii) no arguments at all
 * 	iv) return jyplot
 * last make sure that javadoc does not contain unnecessary line breaks
 * 
 * Notes: if links there then need to be connected manually
 * 
 * TODO lazy evaluation on general java object class
 * TODO jyplot web service (exec python in server) 
 * 
 * @author alice &lt;aliceinnets[at]gmail.com&gt;
 *
 */
public class JyPlotGenerator {
	
	public final static String PATH = "gsrc"+File.separator;
	public final static String PACKAGENAME = "aliceinnets.jyplot";
	public final static String CLASSNAME = "JyPlot";
	
	public final static String PYTHONMODULE = PythonScript.class.getSimpleName();
	
	public final static String IMPORT_NUMPY_AS = PythonGrammar.NUMPY;
    public final static String IMPORT_PYPLOT_AS = "plt";
	
	public final static String MATPLOTLIB_HOME = "https://matplotlib.org/";
//	public final static String MATPLOTLIB_PYPLOT_DOCS_HTML="https://matplotlib.org/api/pyplot_api.html";
	public final static String MATPLOTLIB_PYPLOT_DOCS_HTML="https://matplotlib.org/2.0.2/api/pyplot_api.html";
	
	public final static String CLASS_DOCUMENTATION = "/** \n"
			+ " * Java Python module for matplotlib.pyplot.\n"
			+ " * \n"
			+ " * @author alice &lt;aliceinnets[at]gmail.com&gt;\n"
			+ " * \n"
			+ " */";
	
	
	public final static List<PythonMethod> parsePythonFunction(String document) {
		Scanner scanner = new Scanner(document);
		
		List<String> functionDescs = new LinkedList<String>();
		StringBuffer buffer = null;
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			if(line.contains("<dl class=\"function\">")) {
				buffer = new StringBuffer();
			} else if(line.contains("</dd></dl>")) {
				functionDescs.add(buffer.toString());
				buffer = null;
			}
			if(buffer != null) {
				buffer.append(line);
				buffer.append("\n");
			}
		}
		scanner.close();
		
		functionDescs.remove(0);
		
		List<PythonMethod> pythonFunctions = new LinkedList<PythonMethod>();
		for(String functionDesc : functionDescs) {
			PythonMethod pythonFunction = new PythonMethod();
			
			String[] lines = functionDesc.split("\n");
			
			String signatureHtmlDesc = lines[2];
			parseSignatureDesc(signatureHtmlDesc, pythonFunction);
			
			parseField(lines, pythonFunction);
			
//			printPythonFunction(pythonFunction);
			
			parseDesc(pythonFunction.getDesc(), pythonFunction);
			parseParameterDescs(pythonFunction.getAllParameterDescs(), pythonFunction);
			parseReturnDescs(pythonFunction.getAllReturnDescs(), pythonFunction);
			parseOtherParameterDescs(pythonFunction.getAllOtherParameterDescs(), pythonFunction);
			parseNote(pythonFunction.getNote(), pythonFunction);
			parseSeeAlso(pythonFunction.getSeeAlso(), pythonFunction);
			
			pythonFunctions.add(pythonFunction);
		}
		
		return pythonFunctions;
	}
	
	
	public final static void parseDesc(String desc, PythonMethod pythonFunction) {
		desc = parseHtmlDocument(desc);
		desc = desc.replaceAll("\\s+|\n+", " ");
		pythonFunction.setDesc(desc);
	}
	
	
	public final static void parseParameterDescs(String allParameterDescs, PythonMethod pythonFunction) {
		if(allParameterDescs == null) return;

		allParameterDescs = parseHtmlDocument(allParameterDescs);
		
		StringBuffer buffer = new StringBuffer();
		List<String> parameterNames = new LinkedList<String>();
		List<String> parameterTypes = new LinkedList<String>();
		List<String> parameterDescs = new LinkedList<String>();
		String[] lines = allParameterDescs.split("\n");
		for(int i=0;i<lines.length;++i) {
			if(lines[i].contains("<strong>")) {
				lines[i] = lines[i].replace("<tr class=\"field-odd field\"><th class=\"field-name\">Parameters:</th><td class=\"field-body\">", "");
				lines[i] = lines[i].replace("<p class=\"first\">", "");
				lines[i] = lines[i].replace("<p>", "");
				lines[i] = lines[i].replace("</p>", "");
				lines[i] = lines[i].replace("<strong>", "");
				lines[i] = lines[i].replace("</strong>", "");
				if(lines[i].contains(" :")) {
					String[] nameAndType = lines[i].split(" :");
					parameterNames.add(nameAndType[0].replace(" ", "").replace("\n", "").replace("*", ""));
					if(nameAndType.length > 1) {
						parameterTypes.add(nameAndType[1]);
					} else {
						parameterTypes.add("");
					}
					
					parameterDescs.add(buffer.toString());
					buffer = new StringBuffer();
				}
			} else {
				buffer.append(lines[i]);
			}
		}
		parameterDescs.add(buffer.toString());
		
		if(parameterDescs.size() > 0) {
			parameterDescs.remove(0);
		}
		
		pythonFunction.setParameterDocNames(parameterNames.toArray(new String[parameterNames.size()]));
		pythonFunction.setParameterTypes(parameterTypes.toArray(new String[parameterTypes.size()]));
		pythonFunction.setParameterDescs(parameterDescs.toArray(new String[parameterDescs.size()]));
	}
	
	
	public final static void parseReturnDescs(String allReturnDescs, PythonMethod pythonFunction) {
//		if(allParameterDescs == null) return;
		
		String returnDescs = "JyPlot object, its internal python script has now appended";
		pythonFunction.setAllReturnDescs(returnDescs);
	}
	
	
	public final static void parseOtherParameterDescs(String allOtherParameterDescs, PythonMethod pythonFunction) {
		if(allOtherParameterDescs == null) return;
		
		allOtherParameterDescs = parseHtmlDocument(allOtherParameterDescs);
		allOtherParameterDescs = allOtherParameterDescs.replace("Other Parameters:", "Other&nbsp;Parameters:");
		allOtherParameterDescs = allOtherParameterDescs.replaceAll("\\s+|\n+", " ");
		pythonFunction.setAllOtherParameterDescs(allOtherParameterDescs);
	}
	
	
	public final static void parseSeeAlso(String seeAlso, PythonMethod pythonFunction) {
		if(seeAlso == null) return;
		
		seeAlso = parseHtmlDocument(seeAlso);
		seeAlso = seeAlso.replaceAll("\\s+|\n+", " ");
		pythonFunction.setSeeAlso(seeAlso);
	}
	
	
	public final static void parseNote(String note, PythonMethod pythonFunction) {
		if(note == null) return;
		
		note = parseHtmlDocument(note);
		note = note.replace("<p>Notes</p>", "<p><b>Notes</b></p>");
		note = note.replaceAll("\\s+|\n+", " ");
		pythonFunction.setNote(note);
	}
	
	
	public final static void parseField(String[] lines, PythonMethod pythonFunction) {
		List<String> fields = new LinkedList<String>();
		StringBuffer buffer = new StringBuffer();
		for(int i=3;i<lines.length;++i) {
			if(lines[i].contains("<tr class=\"field-odd field\">") // Parameters
					|| lines[i].contains("<tr class=\"field-even field\">") // Return and other parameters
					|| lines[i].contains("<p class=\"rubric\">") // Notes
					|| lines[i].contains("<div class=\"admonition seealso\">")) { // See also
				fields.add(buffer.toString());
				buffer = new StringBuffer();
			} else {
			}
			if(i < lines.length-1) {
				buffer.append(lines[i]);
				buffer.append("\n");
			} else {
				buffer.append(lines[i].replace("</dl>", "")); // function end
			}
		}
		fields.add(buffer.toString());
		
		if(fields.size() != 0) {
			pythonFunction.setDesc(fields.remove(0));
		}
		
		for(int i=0;i<fields.size();++i) {
			if(fields.get(i).contains("<th class=\"field-name\">Parameters:</th>")) {
				pythonFunction.setAllParameterDescs(fields.get(i));
			} else if(fields.get(i).contains("<th class=\"field-name\">Returns:</th>")) {
				pythonFunction.setAllReturnDescs(fields.get(i));
			} else if(fields.get(i).contains("<th class=\"field-name\" colspan=\"2\">Other Parameters:</th>")) {
				String allOtherparameterDescs = fields.get(i);
				allOtherparameterDescs += fields.get(i+1);
				pythonFunction.setAllOtherParameterDescs(allOtherparameterDescs);
			} else if(fields.get(i).contains("<p class=\"rubric\">Notes</p>")) {
				pythonFunction.setNote(fields.get(i));
			} else if(fields.get(i).contains("<div class=\"admonition seealso\">")) {
				pythonFunction.setSeeAlso(fields.get(i));
			}
		}
	}
	
	
	public final static void parseSignatureDesc(String signatureDesc, PythonMethod pythonFunction) {
		signatureDesc = signatureDesc.replaceAll("<code class=\"descclassname\">", "");
		signatureDesc = signatureDesc.replaceAll("<code class=\"descname\">", "");
		signatureDesc = signatureDesc.replaceAll("</code>", "");
		signatureDesc = signatureDesc.replaceAll("<span class=\"sig-paren\">", "");
		signatureDesc = signatureDesc.replaceAll("</span>", "");
		signatureDesc = signatureDesc.replaceAll("<a class=.+>", "");
		signatureDesc = signatureDesc.replaceAll("</a>", "");
		signatureDesc = signatureDesc.replaceAll("</dt>", "");
		
		pythonFunction.setSignatureDesc(signatureDesc);
		signatureDesc = signatureDesc.replaceAll("<em>", "");
		signatureDesc = signatureDesc.replaceAll("</em>", "");
		
		int startParam = signatureDesc.indexOf("(");
		int endParam = signatureDesc.lastIndexOf(")");
		String[] names = signatureDesc.substring(0, startParam).split("\\.");
		String className = names[0];
		for(int i=1;i<names.length-1;++i) {
			className += "."+names[i];
		}
		String name = names[names.length-1];
		
		String arguments[] = signatureDesc.substring(startParam+1, signatureDesc.length()-1).split("\\, ");
		List<String> parameterNames = new LinkedList<String>();
		for(int i=0;i<arguments.length;++i) {
			if(arguments[i].contains("(")) {
				String argument = arguments[i];
				++i;
				while(!arguments[i].contains(")")) {
					argument += arguments[i];
					++i;
				}
				argument += ","+arguments[i];
				parameterNames.add(argument);
			} else if(arguments[i].equals("delimiter='")) { // delimiter=', ' case
				if(arguments[i+1].equals("'")) {
					parameterNames.add(arguments[i]+", '");
					++i;
				}
			} else {
				parameterNames.add(arguments[i]);
			}
		}
		
		pythonFunction.setClassName(className);
		pythonFunction.setName(name);
		if(startParam+1 != endParam) {
			pythonFunction.setParameterNames(parameterNames.toArray(new String[parameterNames.size()]));
		}
	}
	
	
	public final static void generateHeader(StringBuffer gsrc) {
		gsrc.append("/* Automatically generated python module class, updated at " + new Date() + " */\n");
		
		gsrc.append("package "+PACKAGENAME+";\n");
		gsrc.append("\n");
		
		gsrc.append("import aliceinnets.python.Parser;\n");
		gsrc.append("import aliceinnets.python."+PYTHONMODULE+";\n");
		gsrc.append("\n");
		
		gsrc.append(CLASS_DOCUMENTATION+"\n");
		gsrc.append("public class "+CLASSNAME+" extends "+PYTHONMODULE+" {\n");
		gsrc.append("\n");
		
		gsrc.append("\t/**\n");
		gsrc.append("\t * "+CLASSNAME+" generate and run a python script to plot.\n");
		gsrc.append("\t * A default python script pathname is System.getProperty(\"user.home\")/PythonScript/System.nanoTime().\n");
		gsrc.append("\t * \n");
		gsrc.append("\t * Use setPythonPath method to set the PYTHON_PATH if necessary.\n");
		gsrc.append("\t */\n");
		gsrc.append("\tpublic "+CLASSNAME+"() { }\n");
		gsrc.append("\t\n");
		
		gsrc.append("\t/**\n");
		gsrc.append("\t * "+CLASSNAME+" generate and run a python script to plot.\n");
		gsrc.append("\t * \n");
		gsrc.append("\t * Use setPythonPath method to set the PYTHON_PATH if necessary.\n");
		gsrc.append("\t * \n");
		gsrc.append("\t * @param pathname the python script pathname\n");
		gsrc.append("\t */\n");
		gsrc.append("\tpublic "+CLASSNAME+"(String pathname) {\n");
		gsrc.append("\t\tsuper(pathname);\n");
		gsrc.append("\t}\n");
		gsrc.append("\t\n");
		
		gsrc.append("\t/**\n");
		gsrc.append("\t * Convert a matplotlib figure to a Plotly graph stored locally as HTML.\n");
		gsrc.append("\t * \n");
		gsrc.append("\t * @param filename The local filename to save the outputted chart to. If the filename already exists, it will be overwritten.\n");
		gsrc.append("\t */\n");
		gsrc.append("\tpublic void saveAsPlotlyFig(Object filename) {\n");
		gsrc.append("\t\twrite(\"plotly.offline.plot_mpl(plt.gcf(), filename=\"+Parser.toPythonArgs(filename)+\", auto_open=False)\");\n");
		gsrc.append("\t}\n");
		gsrc.append("\t\n");
		
		gsrc.append("\t/**\n");
		gsrc.append("\t * Convert a matplotlib figure to a Plotly graph stored locally as HTML.\n");
		gsrc.append("\t * \n");
		gsrc.append("\t * @param filename The local filename to save the outputted chart to. If the filename already exists, it will be overwritten.\n");
		gsrc.append("\t * @param auto_open If True, open the saved file in a web browser after saving.\n");
		gsrc.append("\t */\n");
		gsrc.append("\tpublic void saveAsPlotlyFig(Object filename, Object auto_open) {\n");
		gsrc.append("\t\twrite(\"plotly.offline.plot_mpl(plt.gcf(), filename=\"+Parser.toPythonArgs(filename)+\", auto_open=\"+Parser.toPythonArgs(auto_open)+\")\");\n");
		gsrc.append("\t}\n");
		gsrc.append("\t\n");
		
	}
	
	
	public final static void generateFooter(StringBuffer gsrc) {
		gsrc.append("\t\n");
		gsrc.append("}");
	}
	
	
	public final static void generateAllDocumentAndMethods(List<PythonMethod> functions, StringBuffer gsrc) {
		for(PythonMethod function : functions) {
			generateDocumentAndMethods(function, gsrc);
		}
	}
	
	
	public final static void generateDocumentAndMethods(PythonMethod function, StringBuffer gsrc) {
		List<String> parameterNames = new LinkedList<String>();
		if(function.getParameterNames() != null) {
			for(String parameterName : function.getParameterNames()) {
				parameterNames.add(parameterName);
			}
			
			int index = parameterNames.size()-1;
			while(index >= 0 && (parameterNames.get(index).contains("=") || parameterNames.get(index).contains("*"))) {
				generateDocumentAndMethod(function, IMPORT_PYPLOT_AS, parameterNames.toArray(new String[parameterNames.size()]), gsrc);
				parameterNames.remove(index);
				--index;
			}
			if(parameterNames.isEmpty()) {
				generateDocumentAndMethod(function, IMPORT_PYPLOT_AS, null, gsrc);
			} else {
				generateDocumentAndMethod(function, IMPORT_PYPLOT_AS, parameterNames.toArray(new String[parameterNames.size()]), gsrc);
			}
		} else {
			generateDocumentAndMethod(function, IMPORT_PYPLOT_AS, function.getParameterNames(), gsrc);
		}
		
	}
	
	
	public final static void generateDocumentAndMethod(PythonMethod pythonFunction, String pythonClassName, String[] parameters, StringBuffer gsrc) {
		generateDocument(pythonFunction, parameters, gsrc);
		generateMethod(pythonFunction.getName(), pythonClassName, parameters, gsrc);
	}
	
	
	public final static void generateDocument(PythonMethod pythonFunction, String[] parameters, StringBuffer gsrc) {
		String signature = pythonFunction.getSignatureDesc();		
		
		String[] parameterDocNames = pythonFunction.getParameterDocNames();
		String[] parameterTypes = pythonFunction.getParameterTypes();
		String[] parameterDescs = pythonFunction.getParameterDescs();
		
		if(parameters != null) {
			parameters = parameters.clone();
			for (int i = 0; i < parameters.length; i++) {
				parameters[i] = parameters[i].replace("*", "");
			}
		}
		
		gsrc.append("\t/** \n");
		
		gsrc.append("\t * "+signature+"\n");
		gsrc.append("\t * \n");
		
		gsrc.append("\t * "+pythonFunction.getDesc()+"\n");
		gsrc.append("\t * \n");
		
		if(parameters != null) {
			for(String parameter : parameters) {
				boolean match = false;
				if(parameterDocNames != null) {
					for(String parameterDocName : parameterDocNames) {
						if(parameter.split("=")[0].equals(parameterDocName)) {
							match = true;
						}
					}
				}
				if(!match) {
					String link = MATPLOTLIB_PYPLOT_DOCS_HTML+"#"+pythonFunction.getClassName()+"."+pythonFunction.getName();
					gsrc.append("\t * @param "+parameter.split("=")[0]+" undocumented, see also <a href=\""+link+"\"><code>"+pythonFunction.getClassName()+"."+pythonFunction.getName()+"</code></a>, other parameters and notes\n");
					
				}
			}
		}
		if(parameters != null && parameterDocNames != null) {
			for(int i=0;i<parameterDocNames.length;++i) {
				boolean match = false;
				for(String parameter : parameters) {
					if(parameter.split("=")[0].equals(parameterDocNames[i])) {
						gsrc.append(toJavaParamDocs(parameterDocNames[i], parameterTypes[i], parameterDescs[i])+"\n");
						
						match = true;
					}
				}
				if(!match) {
					gsrc.append(toJavaParamDocs(parameterDocNames[i], parameterTypes[i], parameterDescs[i])+"\n");
				}
			}
		}
		gsrc.append("\t * \n");
		
		if(pythonFunction.getAllOtherParameterDescs() != null) {
			gsrc.append("\t * "+pythonFunction.getAllOtherParameterDescs()+"\n");
		}
		if(pythonFunction.getNote() != null) {
			gsrc.append("\t * "+pythonFunction.getNote()+"\n");
		}
		if(pythonFunction.getSeeAlso() != null) {
			gsrc.append("\t * "+pythonFunction.getSeeAlso()+"\n");
		}
		gsrc.append("\t * \n");
		
		gsrc.append("\t * @return "+pythonFunction.getAllReturnDescs()+" "+"<code>"+pythonFunction.getName()+"</code>"+"\n");
		gsrc.append("\t */\n");
	}
	
	
	public final static String toJavaParamDocs(String parameterDocNames, String parameterTypes, String parameterDescs) {
		String javaParamDocs = "\t * @param "+parameterDocNames;
		if(parameterTypes != null && !parameterTypes.equals("")) {
			javaParamDocs += " <i>"+parameterTypes+"</i>";							
		}
		if(parameterDescs != null && !parameterDescs.equals("")) {
			javaParamDocs += " "+parameterDescs;	
		}
		return javaParamDocs;
	}
	
	
	public final static void generateMethod(String name, String pythonClassName, String[] parameters, StringBuffer gsrc) {
		// java method part
		gsrc.append("\tpublic void "+name+"(");
		if(parameters != null) {
			if(parameters.length == 1) {
				gsrc.append(toMethodArgs(parameters[0], true));
			} else {
				gsrc.append(toMethodArgs(parameters[0], false));
			}
			for(int i=1;i<parameters.length-1;++i) {
				gsrc.append(", "+toMethodArgs(parameters[i], false));
			}
			if(parameters.length != 1) {
				gsrc.append(", "+toMethodArgs(parameters[parameters.length-1], false));
			}
		}
		gsrc.append(") {\n");
		
		// python function part
		gsrc.append("\t\twrite(\""+pythonClassName+"."+name+"(");
		if(parameters != null) {
			gsrc.append("\"");
			for(int i=0;i<parameters.length;++i) {
				if (i == 0) {
					gsrc.append(toPythonMethodArgs(parameters[i], false));
				} else {
					gsrc.append(toPythonMethodArgs(parameters[i], true));				
				}
			}
			gsrc.append("\"");
		}
		gsrc.append(")\");\n");
		gsrc.append("\t}\n");
		gsrc.append("\t\n");
	}
	
	
	public final static String toMethodArgs(String pythonParam, boolean lastArg) {
		String arg;
		if(pythonParam.contains("*")) {
			if(lastArg) {
				arg = "Object... ";
			} else {
				arg = "Object[] ";
			}
		} else {
			arg = "Object ";
		}
		return arg + toParameterName(pythonParam);
	}
	
	
	public final static String toPythonMethodArgs(String parameter, boolean comma) {
		String numpyArg = "Parser.toPythonArgs("+toParameterName(parameter)+")";
		if(!parameter.contains("=") && !parameter.contains("*")) {
			if(comma) {
				return "\", \"+"+numpyArg+"+";
			} else {
				return "+"+numpyArg+"+";
			}
		} else {
			if(comma) {
				return "("+toParameterName(parameter)+" != null ? (\", \"+"+numpyArg+") : \"\")+";
			} else {
				return "+("+toParameterName(parameter)+" != null ? ("+numpyArg+") : \"\")+";
			}
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
	
	
	public final static String parseHtmlDocument(String htmlDocument) {
		htmlDocument = htmlDocument.replace("class=\"reference internal\" href=\"#", "href=\"http://matplotlib.org/api/pyplot_api.html#");
		htmlDocument = htmlDocument.replace("class=\"reference external\" href=\"../", "href=\"http://matplotlib.org/");
		htmlDocument = htmlDocument.replace("class=\"reference internal\" href=\"", "href=\"http://matplotlib.org/api/");
		
		htmlDocument = htmlDocument.replace("src=\"../", "src=\""+MATPLOTLIB_HOME+"/");
		htmlDocument = htmlDocument.replace("alt=\"../", "alt=\""+MATPLOTLIB_HOME+"/");
		
		return htmlDocument;
	}
	
	
	public final static void printPythonFunction(PythonMethod pythonFunction) {
		System.out.println(String.format("====================%s====================", "Signature"));
		System.out.println(pythonFunction.getSignatureDesc());
		System.out.println(String.format("====================%s====================", "Desc"));
		System.out.println(pythonFunction.getDesc());
		System.out.println(String.format("====================%s====================", "AllParameter"));
		System.out.println(pythonFunction.getAllParameterDescs());
		System.out.println(String.format("====================%s====================", "AllReturn"));
		System.out.println(pythonFunction.getAllReturnDescs());
		System.out.println(String.format("====================%s====================", "AllOtherParameter"));
		System.out.println(pythonFunction.getAllOtherParameterDescs());
		System.out.println();
	}
	
	
	public final static String generateSource(String document) {
		List<PythonMethod> functions = parsePythonFunction(document);
		
		StringBuffer gsrc = new StringBuffer();
		generateHeader(gsrc);
		generateAllDocumentAndMethods(functions, gsrc);
		generateFooter(gsrc);
		
		return gsrc.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		boolean overwrite = false;
		
		String savePath = "src/"+JyPlotGenerator.class.getPackage().getName().replace(".", "/");
		System.out.println(savePath);
		
		String saveFileName = "pyplot_api.html";
		String pathname = WebUtils.saveUrl(MATPLOTLIB_PYPLOT_DOCS_HTML, savePath, saveFileName);
//		String pathname = savePath+File.separator+saveFileName;
		System.out.println("Document path: "+pathname);
		String document = OneLiners.read(pathname);
		
		String outpath = PATH+PACKAGENAME.replace(".", File.separator);
		OneLiners.mkdirs(outpath);
		
		outpath += File.separator+CLASSNAME+".java";
		
		if(new File(outpath).exists()) {
			if(overwrite) {
				PrintWriter out = new PrintWriter(outpath);
				out.write(generateSource(document));
				out.close();
				
				System.out.println(CLASSNAME+" is overwritten! at "+outpath);
			} else {
				System.err.println(CLASSNAME+" is already exist! at "+outpath);
			}
		} else {
			PrintWriter out = new PrintWriter(outpath);
			out.write(generateSource(document));
			out.close();
			
			System.out.println(CLASSNAME+" is generated!");
		}
		
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

}
