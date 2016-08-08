package app.unittests;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import app.antlr.AplusplusLexer;
import app.antlr.AplusplusParser;

public class GrammerTests {
	private AplusplusParser getParser(String sourceCode) {
		ANTLRInputStream input = new ANTLRInputStream(sourceCode);
		AplusplusLexer lexer = new AplusplusLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AplusplusParser parser = new AplusplusParser(tokens);
		parser.setBuildParseTree(true);
		parser.removeErrorListeners();
		parser.addErrorListener(new ParserErrorListener());
		return parser;
	}
	
	public class ParserErrorListener implements ANTLRErrorListener {
		private boolean hasSyntaxError;
		public void setHasSyntaxError(boolean b) { hasSyntaxError = b; }
		public boolean getHasSyntaxError() { return hasSyntaxError; }

		@Override
		public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3,
				boolean arg4, BitSet arg5, ATNConfigSet arg6) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reportAttemptingFullContext(Parser arg0, DFA arg1,
				int arg2, int arg3, BitSet arg4, ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2,
				int arg3, int arg4, ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2,
				int arg3, String arg4, RecognitionException arg5) {
			setHasSyntaxError(true);
			
		}
		
	}
	
	private boolean hasSyntaxError(Parser parser){
		return ((ParserErrorListener)parser.getErrorListeners().get(0)).getHasSyntaxError();
	}

	// var
	@Test
	public void id() {
		AplusplusParser parser = getParser("test");
		ParseTree root = parser.var();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("id", root.getChild(0).getText().matches("test"));
	}

	@Test
	public void id1() {
		AplusplusParser parser = getParser("htrehtre86");
		ParseTree root = parser.var();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("id", root.getChild(0).getText()
				.matches("htrehtre86"));
	}
	
	@Test
	public void id2() {
		AplusplusParser parser = getParser("-.,test");
		ParseTree root = parser.var();
		
		Assert.assertTrue(hasSyntaxError(parser));
	}

	// Boolean literal
	@Test
	public void booleanLiteral() {
		AplusplusParser parser = getParser("true");
		ParseTree root = parser.booleanLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("boolean literal", root.getChild(0).getText()
				.matches("true"));
	}

	@Test
	public void booleanLiteral1() {
		AplusplusParser parser = getParser("false");
		ParseTree root = parser.booleanLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("boolean literal", root.getChild(0).getText()
				.matches("false"));
	}

	@Test
	public void booleanLiteral2() {
		AplusplusParser parser = getParser("on");
		ParseTree root = parser.booleanLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("boolean literal", root.getChild(0).getText()
				.matches("on"));
	}

	@Test
	public void booleanLiteral3() {
		AplusplusParser parser = getParser("off");
		ParseTree root = parser.booleanLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("boolean literal", root.getChild(0).getText()
				.matches("off"));
	}

	// Number literal
	@Test
	public void numberLiteralMinus() {
		AplusplusParser parser = getParser("-100");
		ParseTree root = parser.numberLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Number literal",
				root.getChild(0).getText().matches("-100"));
	}
	
	@Test
	public void numberLiteralNull() {
		AplusplusParser parser = getParser("0");
		ParseTree root = parser.numberLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Number literal",
				root.getChild(0).getText().matches("0"));
	}
	
	@Test
	public void numberLiteral() {
		AplusplusParser parser = getParser("12");
		ParseTree root = parser.numberLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Number literal",
				root.getChild(0).getText().matches("12"));
	}
	
	@Test
	public void numberLiteralLarge() {
		AplusplusParser parser = getParser("1000000000000000000");
		ParseTree root = parser.numberLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Number literal",
				root.getChild(0).getText().matches("1000000000000000000"));
	}

	// time literal
	@Test
	public void timeLiteral1200() {
		AplusplusParser parser = getParser("12:00");
		ParseTree root = parser.timeLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Time literal 12:00", root.getChild(0).getText()
				.matches("12:00"));
	}

	@Test
	public void timeLiteral0000() {
		AplusplusParser parser = getParser("00:00");
		ParseTree root = parser.timeLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Time literal 00:00", root.getChild(0).getText()
				.matches("00:00"));
	}

	@Test
	public void timeLiteral2400() {
		AplusplusParser parser = getParser("24:00");
		ParseTree root = parser.timeLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Time literal 24:00", root.getChild(0).getText()
				.matches("24:00"));
	}

	// interval literal
	@Test
	public void intervalLiteral() {
		AplusplusParser parser = getParser("12:00 to 13:00");
		ParseTree root = parser.intervalLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Interval literal 12:00 to 13:00", root.getChild(0)
				.getChild(0).getText().matches("12:00")
				&& root.getChild(2).getChild(0).getText().matches("13:00"));
	}

	@Test
	public void intervalLiteral2() {
		AplusplusParser parser = getParser("12:00 to 13:00 mon");
		ParseTree root = parser.intervalLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Interval literal 12:00 to 13:00 mon", root.getChild(0)
				.getChild(0).getText().matches("12:00")
				&& root.getChild(2).getChild(0).getText().matches("13:00")
				&& root.getChild(3).getChild(0).getText().matches("mon"));
	}

	@Test
	public void intervalLiteral3() {
		AplusplusParser parser = getParser("12:00 to 13:00 jan");
		ParseTree root = parser.intervalLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Interval literal 12:00 to 13:00 jan", root.getChild(0)
				.getChild(0).getText().matches("12:00")
				&& root.getChild(2).getChild(0).getText().matches("13:00")
				&& root.getChild(3).getChild(0).getText().matches("jan"));
	}

	@Test
	public void intervalLiteral4() {
		AplusplusParser parser = getParser("12:00 to 13:00 mon jan");
		ParseTree root = parser.intervalLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Interval literal 12:00 to 13:00 mon jan", root
				.getChild(0).getChild(0).getText().matches("12:00")
				&& root.getChild(2).getChild(0).getText().matches("13:00")
				&& root.getChild(3).getChild(0).getText().matches("mon")
				&& root.getChild(4).getChild(0).getText().matches("jan"));
	}
	
	@Test
	public void intervalLiteral5() {
		AplusplusParser parser = getParser("12:00 to 13:00 mon sat jan dec");
		ParseTree root = parser.intervalLiteral();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Interval literal 12:00 to 13:00 mon sat jan dec", root
				.getChild(0).getChild(0).getText().matches("12:00")
				&& root.getChild(2).getChild(0).getText().matches("13:00")
				&& root.getChild(3).getChild(0).getText().matches("mon")
				&& root.getChild(4).getChild(0).getText().matches("sat")
				&& root.getChild(5).getChild(0).getText().matches("jan")
				&& root.getChild(6).getChild(0).getText().matches("dec"));
	}

	// duration literal
	@Test
	public void durationLiteral() {
		AplusplusParser parser = getParser("1hr 2min 3sec");
		ParseTree root = parser.durationLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Duration Literal", root.getChild(0).getChild(0)
				.getText().matches("1")
				&& root.getChild(0).getChild(1).getText().matches("hr")

				&& root.getChild(1).getChild(0).getText().matches("2")
				&& root.getChild(1).getChild(1).getText().matches("min")

				&& root.getChild(2).getChild(0).getText().matches("3")
				&& root.getChild(2).getChild(1).getText().matches("sec"));
	}

	@Test
	public void durationLiteral2() {
		AplusplusParser parser = getParser("1hr 3sec");
		ParseTree root = parser.durationLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Duration Literal", root.getChild(0).getChild(0)
				.getText().matches("1")
				&& root.getChild(0).getChild(1).getText().matches("hr")

				&& root.getChild(1).getChild(0).getText().matches("3")
				&& root.getChild(1).getChild(1).getText().matches("sec"));
	}

	@Test
	public void durationLiteral3() {
		AplusplusParser parser = getParser("111hr 3sec");
		ParseTree root = parser.durationLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Duration Literal", root.getChild(0).getChild(0)
				.getText().matches("111")
				&& root.getChild(0).getChild(1).getText().matches("hr")

				&& root.getChild(1).getChild(0).getText().matches("3")
				&& root.getChild(1).getChild(1).getText().matches("sec"));
	}

	@Test
	public void durationLiteral4() {
		AplusplusParser parser = getParser("111min 35432sec");
		ParseTree root = parser.durationLiteral();
		
		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Duration Literal", root.getChild(0).getChild(0)
				.getText().matches("111")
				&& root.getChild(0).getChild(1).getText().matches("min")

				&& root.getChild(1).getChild(0).getText().matches("35432")
				&& root.getChild(1).getChild(1).getText().matches("sec"));
	}
	
	// Expression
	@Test
	public void parensExpression1() {
		AplusplusParser parser = getParser("(var)");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression parens", root.getChild(0).getText().matches("\\(")
				&& root.getChild(2).getText().matches("\\)")
				&& root.getChild(1).getChild(0).getText().matches("var"));
	}
	
	@Test
	public void plusExpression() {
		AplusplusParser parser = getParser("var1 + var2");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression plus", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\+")
				&& root.getChild(2).getChild(0).getText().matches("var2"));
	}
	
	@Test
	public void plusPlusExpression() {
		AplusplusParser parser = getParser("var1 + var2 + var3");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression plus", root.getChild(0).getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(0).getChild(1).getText().matches("\\+")
				&& root.getChild(0).getChild(2).getChild(0).getText().matches("var2")
				&& root.getChild(1).getText().matches("\\+")
				&& root.getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void plusPlusParensExpression() {
		AplusplusParser parser = getParser("var1 + (var2 + var3)");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression plus parens", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\+")
				&& root.getChild(2).getChild(0).getText().matches("\\(")
				&& root.getChild(2).getChild(1).getChild(0).getChild(0).getText().matches("var2")
				&& root.getChild(2).getChild(1).getChild(1).getText().matches("\\+")
				&& root.getChild(2).getChild(1).getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void minusExpression() {
		AplusplusParser parser = getParser("var1 - var2");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression minus", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\-")
				&& root.getChild(2).getChild(0).getText().matches("var2"));
	}
	
	@Test
	public void minusMinusExpression() {
		AplusplusParser parser = getParser("var1 - var2 - var3");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression minus", root.getChild(0).getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(0).getChild(1).getText().matches("\\-")
				&& root.getChild(0).getChild(2).getChild(0).getText().matches("var2")
				&& root.getChild(1).getText().matches("\\-")
				&& root.getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void minusMinusParensExpression() {
		AplusplusParser parser = getParser("var1 - (var2 - var3)");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression minus parens", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\-")
				&& root.getChild(2).getChild(0).getText().matches("\\(")
				&& root.getChild(2).getChild(1).getChild(0).getChild(0).getText().matches("var2")
				&& root.getChild(2).getChild(1).getChild(1).getText().matches("\\-")
				&& root.getChild(2).getChild(1).getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void multiExpression() {
		AplusplusParser parser = getParser("var1 * var2");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression multi", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\*")
				&& root.getChild(2).getChild(0).getText().matches("var2"));
	}
	
	@Test
	public void multiMultiExpression() {
		AplusplusParser parser = getParser("var1 * var2 * var3");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression multi", root.getChild(0).getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(0).getChild(1).getText().matches("\\*")
				&& root.getChild(0).getChild(2).getChild(0).getText().matches("var2")
				&& root.getChild(1).getText().matches("\\*")
				&& root.getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void multiMultiParensExpression() {
		AplusplusParser parser = getParser("var1 * (var2 * var3)");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression multi parens", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\*")
				&& root.getChild(2).getChild(0).getText().matches("\\(")
				&& root.getChild(2).getChild(1).getChild(0).getChild(0).getText().matches("var2")
				&& root.getChild(2).getChild(1).getChild(1).getText().matches("\\*")
				&& root.getChild(2).getChild(1).getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void divExpression() {
		AplusplusParser parser = getParser("var1 / var2");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression div", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\/")
				&& root.getChild(2).getChild(0).getText().matches("var2"));
	}
	
	@Test
	public void divDivExpression() {
		AplusplusParser parser = getParser("var1 / var2 / var3");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression div", root.getChild(0).getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(0).getChild(1).getText().matches("\\/")
				&& root.getChild(0).getChild(2).getChild(0).getText().matches("var2")
				&& root.getChild(1).getText().matches("\\/")
				&& root.getChild(2).getChild(0).getText().matches("var3"));
	}
	
	@Test
	public void divDivParensExpression() {
		AplusplusParser parser = getParser("var1 / (var2 / var3)");
		ParseTree root = parser.expression();

		Assert.assertTrue(!hasSyntaxError(parser));
		Assert.assertTrue("Expression div parens", root.getChild(0).getChild(0).getText().matches("var1")
				&& root.getChild(1).getText().matches("\\/")
				&& root.getChild(2).getChild(0).getText().matches("\\(")
				&& root.getChild(2).getChild(1).getChild(0).getChild(0).getText().matches("var2")
				&& root.getChild(2).getChild(1).getChild(1).getText().matches("\\/")
				&& root.getChild(2).getChild(1).getChild(2).getChild(0).getText().matches("var3"));
	}
}
