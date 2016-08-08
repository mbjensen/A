package app.errorhandler;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import app.antlr.AplusplusParser;

public class SyntaxError {
	private int line;
	private int offset;
	private Object offendingSymbol;
	private String msg;
	private Exception e;
	private Recognizer<?, ?> recognizer;
	
	// Constructor
	SyntaxError(int line, int offset, Object offendingSymbol, String msg, Exception e, Recognizer<?, ?> recognizer) {
		this.line = line;
        this.offset = offset;
        this.msg = msg;
        this.offendingSymbol = offendingSymbol;
        this.e = e;
        this.recognizer = recognizer;
	}

	// An overridden toString method is used to return custom formatted error messages  
	@Override
    public String toString() {
		// If e (ANTLR error messages) is null the error is a custom error and
		// the error message is build accordingly.
		if (e == null) {
			String customErrorMsg = String.format("Error at line %d, with offset %d:"
					+ " The input was not valid in this context.", line, offset);
        	String underlinedErrorMsg = underlineError(recognizer,(Token)offendingSymbol, line, offset);
        	
        	return String.format("%s\n%s", customErrorMsg, underlinedErrorMsg);
        // No custom error message string is created here, since ANTLR have already made it
        } else {
            String underlinedErrorMsg = String.format(underlineError(recognizer,(Token)offendingSymbol, line, offset));

            return String.format("%s\n%s", msg, underlinedErrorMsg);
        }
    }
	
	/* 
	 * Method used to underline the line of code containing the error
	 * with ^ symbols indicating the offending token. 
	 */
	private String underlineError(Recognizer<?, ?> recognizer, Token offendingToken, int line, 
			int offset) {
		StringBuilder stringBuilder = new StringBuilder();
		
		/*
		 * Some errors present with offendingToken == null. A check for this is therefore necessary.
		 * If offending token is null the value -2 is assigned to offending token.
		 * -1 cannot be used since it is the value of the EOF token.
		 */
		int offendingTokenType = offendingToken != null ? offendingToken.getType() : -2;
		
		if(offendingTokenType != -2) {
			if(offendingToken.getType() != AplusplusParser.EOF) {
				
				CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();
				String input = tokens.getTokenSource().getInputStream().toString();
				String[] lines = input.split("\n");

				String errorLine = lines[line - 1];

				// Whitespaces and tabs are removed from the error message
				int errorLineLength = errorLine.length();
				String trimmedErrorLine = errorLine.replaceAll("\t", "").trim();;
				int lengthDiff = errorLineLength - trimmedErrorLine.length();
				
				stringBuilder.append(String.format("%s\n", trimmedErrorLine));
				
				// The length difference is used to add whitespaces until the error token is reached
				for (int i = 0; i < offset - lengthDiff; i++) {
					stringBuilder.append(" ");
				}
				
				int start = offendingToken.getStartIndex();
				int stop = offendingToken.getStopIndex();
				
				// Adds an ^ symbol for each character in the offending token
				if (start >= 0 && stop >= 0) {
					for (int i = start; i <= stop; i++) {
						stringBuilder.append("^");
					}
				}
				
				return stringBuilder.toString();
			} else {
				return "EOF_ERROR_IGNORE";
			}
		} else {
			// Returns empty error message since the error is caught elsewhere.
			stringBuilder.append(String.format(""));
			
			return stringBuilder.toString();
		}	
	}
}