package app.errorhandler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import app.antlr.AplusplusParser;

public class CustomErrorListener extends BaseErrorListener {
	// All errors are collected in this list of strings
	private static List<String> errorList = new ArrayList<String>();
	// If any errors are present this value is set to false
	private static boolean isInputValid = true;
	private StringBuilder stringBuilder = new StringBuilder();
	
	// Properties
	public boolean getIsInputValid () { return CustomErrorListener.isInputValid; }
	public static void setIsInputValid (Boolean inputValidity) { isInputValid = inputValidity; }
	public String getErrors() { return buildErrorString(); }
	public void emptyErrorList() { errorList = new ArrayList<String>(); }
	
	// Overrides ATNLRs default syntax errors and implements custom error messages
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
			int line, int charPositionInLine, String msg, RecognitionException e) {
		
		// Error messages are added to the list using a custom toString method 
		errorList.add(new SyntaxError(line, charPositionInLine, offendingSymbol, msg, e, recognizer).toString());
		setIsInputValid(false);
	}
	
	// Handles the custom errors triggered throughout the phases of the compiler
	public static void customError(Token startToken, Token offendingToken, String msg) {
		errorList.add(new CustomError(startToken.getLine(), offendingToken.getCharPositionInLine(), 
				startToken, offendingToken, msg).toString());
		
		setIsInputValid(false);
	}

	// Builds a single string containing all error messages
	private String buildErrorString() {
		stringBuilder = new StringBuilder();
		
		for (String error : errorList) {
			stringBuilder.append(String.format("%s\n", error));
		}
		
		return stringBuilder.toString();
	}
}


