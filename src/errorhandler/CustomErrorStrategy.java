package app.errorhandler;

import org.antlr.v4.runtime.*;

import app.antlr.AplusplusParser;

/*
 * Extends ANTLRs DefaultErrorStrategy and provides custom error messages.
 * If the error is an EOF error the error is ignored.
 */
public class CustomErrorStrategy extends DefaultErrorStrategy {
	@Override
	public void reportNoViableAlternative(Parser parser, NoViableAltException e) throws RecognitionException {
		String customNoViableAlternativeMsg = "The syntax in the following input could not be recognized."
				+ " Please inspect the input thoroughly:";
		if(e.getOffendingToken().getType() != AplusplusParser.EOF) {
			parser.notifyErrorListeners(e.getOffendingToken(), customNoViableAlternativeMsg, e);
		}
	}

	@Override
	public void reportInputMismatch(Parser parser, InputMismatchException e) throws RecognitionException {
		String customInputMismatchMsg = "The following input is not valid:";
		if(e.getOffendingToken().getType() != AplusplusParser.EOF) {
			parser.notifyErrorListeners(e.getOffendingToken(), customInputMismatchMsg, e);
		}
	}

	@Override
	public void reportFailedPredicate(Parser parser, FailedPredicateException e) throws RecognitionException {
		String customFailedPredicateMsg = "The following input is not allowed:";
		if(e.getOffendingToken().getType() != AplusplusParser.EOF) {
			parser.notifyErrorListeners(e.getOffendingToken(), customFailedPredicateMsg, e);
		}
	}
}
