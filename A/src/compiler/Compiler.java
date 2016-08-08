package app.compiler;

import app.errorhandler.*;
import app.phases.CodeGenPhase;
import app.phases.ScopePhase;
import app.phases.TypePhase;
import app.phases.ModelPhase;
import app.scopetype.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import app.antlr.AplusplusLexer;
import app.antlr.AplusplusParser;

public class Compiler {

	// Necessary header files needed to run A++ code on the Arduino
	private static final String[] includes = new String[] { "Wire.h", "Time.h",
			"DS1307RTC.h", "Thread.h", "ThreadController.h", };

	private String filename;
	private String codeString;
	private AplusplusParser parser;
	private CustomErrorStrategy customErrorStrategy;
	private CustomErrorListener customErrorListener;
	private ParserRuleContext tree;
	private Boolean runCodeString = false;
	private Boolean runErrorUnitTest = false;
	private String arduinoCodeOneString;

	private static String workDir;

	//Constructor that takes A++ code when initialized
	public Compiler(String file) {
		filename = file;
	}

	public Compiler(String code, boolean run) {
		codeString = code;
		runCodeString = run;
	}
	
	public Compiler(String code, boolean run, boolean errorRun) {
		codeString = code;
		runCodeString = run;
		runErrorUnitTest = errorRun;
	}
	
	public CustomErrorListener getCustomErrorListener() { return customErrorListener; }
	
	public String getArduinoCodeOneString() {
		try {
			return arduinoCodeOneString.replaceFirst("null", "");
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public AplusplusParser getParser() throws FileNotFoundException,
			IOException {
		String src = "";

		if (parser == null) {
			if (runCodeString != true) {
				if(runErrorUnitTest != true) {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(getClass().getClassLoader()
									.getResourceAsStream(filename)));

					String line = null;
					while ((line = reader.readLine()) != null) {
						src += line.toLowerCase();
						src += "\n";
					}
				} else {
					src = codeString;
				} 	
			} else {
				src = codeString;
			}

			
			customErrorStrategy = new CustomErrorStrategy();
			customErrorListener = new CustomErrorListener();
			
			ANTLRInputStream input = new ANTLRInputStream(src);

			AplusplusLexer lexer = new AplusplusLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new AplusplusParser(tokens);

			// Use custom made errorhandling in the compiler
			parser.setErrorHandler(customErrorStrategy);
			parser.removeErrorListeners();
			parser.addErrorListener(customErrorListener);
		}
		return parser;
	}

	// Returns the tree that is to be walked - start with the uppermost context
	private ParserRuleContext getTree() throws RecognitionException,
			FileNotFoundException, IOException {
		if (tree == null) {
			tree = getParser().start();
		}
		return tree;
	}

	public void compile(String outName) throws IOException {
		// Generic Parse Tree walker
		ParseTreeWalker walker = new ParseTreeWalker();

		/* 
		 * 	Symbols and scopes are defined by walking and annotating the tree
		 * 	This is the first time the tree is walked during compile-time
		 */
		
		ScopePhase scopePhase = new ScopePhase();
		walker.walk(scopePhase, getTree());

		// Second time the tree is walking - typechecking phase
		if (runCodeString != true) {
			// types and references are checked
			TypePhase typePhase = new TypePhase(scopePhase.getScopes(), walker);
			walker.walk(typePhase, getTree());
		}

		// No need to walk the next phases if errors are present
		if (customErrorListener.getIsInputValid()) {
			/* 
			 *  The third time the tree is walked:
			 *  A model phase is made, making it possible to move code 
			 *  to specific  locations in the generated Arduino Code
			 */
			ModelPhase model = new ModelPhase();
			walker.walk(model, getTree());
	
			CodeGenPhase codeGen = new CodeGenPhase(getParser(), walker,
					model.getProgram(), scopePhase.getScopes());
			/*  
			 *  Fourth time the tree is walked:
			 *  Go through the code generation phase and output the generated code
			 */
			
			walker.walk(codeGen, getTree());
	
			if (runCodeString != true) {
				if(runErrorUnitTest != true) {
					File arduDir = new File("out/" + outName);
					File outFile = new File("out/" + outName + "/" + outName + ".ino");
	
					arduDir.mkdirs();
	
					BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
	
					writeIncludes(out);
					writeAppLib(out);
					writeArduinoCode(out, codeGen.getArduinoCode());
	
					out.flush();
					out.close();
	
					System.err.print(customErrorListener.getErrors());
				}
			} else if (runCodeString == true) {
				arduinoCodeOneString = generateArduinoCodeOneString(codeGen);
			}			
		} else {
			System.err.print(customErrorListener.getErrors());
		}
	}

	private String generateArduinoCodeOneString(CodeGenPhase codeGen) {
		return codeGen.getArduinoCodeOneString();
	}

	// Includes header files in the generated code file, in order to use specific libraries
	private void writeIncludes(BufferedWriter out) throws IOException {
		for (String lib : includes) {
			out.write("#include <" + lib + ">");
			out.newLine();
		}
	}

	/* 
	 * 	Adds a custom and self-written C++ library above the generated code
	 */
	private void writeAppLib(BufferedWriter out) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("app-lib")));

		String line = null;
		while ((line = reader.readLine()) != null) {
			out.write(line);
			out.newLine();
		}
	}

	// Loop over code that has been added during CodeGenPhase
	private void writeArduinoCode(BufferedWriter out, List<String> code)
			throws IOException {
		System.out.println("######### ARDUINO CODE ###########");
		for (String s : code) {
			out.write(s);
			out.newLine();

			System.out.println(s);
		}
		System.out.println("##################################");
	}

	public static void main(String[] args) throws Exception {
		// Working directory of the user
		workDir = System.getProperty("user.dir");

		// Input file for the compiler. (Has to exist in the testcode folder).
		Compiler compiler = new Compiler("error_test.app");


		// Output file with Arduino Code - located in out/"name"/"name".ino
		compiler.compile("finalcode");
		compiler.getParser().start().toStringTree();
	}
}
