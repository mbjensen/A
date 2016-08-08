package app.errorhandler;

import org.antlr.v4.runtime.Token;

import app.antlr.AplusplusParser;

public class CustomError {
	private int line;
	private int offset;
	private Token startToken;
	private Token offendingToken;
	private String msg;
	
	// Constructor
	CustomError(int line, int offset, Token startToken, Token offendingToken, String msg) {
		this.line = line;
        this.offset = offset;
        this.startToken = startToken;
        this.offendingToken = offendingToken;
        this.msg = msg;
	}

	// The method toString is overridden to build a custom error message
	@Override
    public String toString() {
		String customErrorMsg = String.format("Error at line %d, with offset %d: %s\n", line, offset, msg);
    	String underlinedErrorMsg = customUnderlineError(startToken, offendingToken, line, offset);
    	
    	return String.format("%s\n%s", customErrorMsg, underlinedErrorMsg);
    }
	
	/* 
	 * Method used to underline the line of code containing the error
	 * with ^ symbols indicating the offending token. 
	 */
	private static String customUnderlineError(Token startToken, Token offendingToken, int line, 
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
				
				String input = startToken.getTokenSource().getInputStream().toString();
				String[] lines = input.split("\n");

				String errorLine = lines[startToken.getLine() - 1];

				// Whitespaces and tabs are removed from the error message
				int errorLineLength = errorLine.length();
				String trimmedErrorLine = errorLine.replaceAll("\t", "").trim();;
				int lengthDiff = errorLineLength - trimmedErrorLine.length();
				
				stringBuilder.append(String.format("%s\n", trimmedErrorLine));
				
				// The length difference is used to add whitespaces until the error token is reached
				for (int i = 0; i < offset - lengthDiff + 1; i++) {
					stringBuilder.append(" ");
				}
				
				int start = offendingToken.getStartIndex();
				int stop = offendingToken.getStopIndex();
				
				// Adds an ^ symbol for each character in the offending token
				if (start >= 0 && stop >= 0) {
					for (int i = start; i <= stop; i++) {
						stringBuilder.append("^");
					}
				} else {
					for (int i = offset + 1; i <= offset + 3; i++) {
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