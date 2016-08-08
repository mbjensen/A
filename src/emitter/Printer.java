package app.emitter;

import app.antlr.AplusplusBaseListener;
import app.antlr.AplusplusParser;

public class printer extends AplusplusBaseListener {

	public void enterProgStmt(AplusplusParser.ProgStmtContext ctx){
		System.out.println(ctx.getText());
	}
}
