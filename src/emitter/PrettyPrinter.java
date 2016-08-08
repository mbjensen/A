package app.emitter;

import org.antlr.v4.runtime.misc.NotNull;
import app.antlr.AplusplusBaseListener;
import app.antlr.AplusplusParser;
import app.antlr.AplusplusParser.MultDivideExpressionContext;
import app.antlr.AplusplusParser.ParensExpressionContext;
import app.antlr.AplusplusParser.PlusMinusExpressionContext;

public class PrettyPrinter extends AplusplusBaseListener {
	
	//Root
	@Override public void enterStart(@NotNull AplusplusParser.StartContext ctx) {
		System.out.println("Start has " + ctx.getChildCount() + " children nodes.");
		String mainNodes = "";
		for(int i = 0; i < ctx.getChildCount(); i++){
			mainNodes += ctx.getChild(i).getClass().getSimpleName() + " ";
		}
		System.out.println("Main nodes are: " + mainNodes);
	}
	
	@Override public void exitStart(@NotNull AplusplusParser.StartContext ctx) { }
	
	
	
	//Setup
	@Override public void enterSetup(@NotNull AplusplusParser.SetupContext ctx) {
		// Prints the class' simple name and opens bracket
		System.out.println(ctx.getClass().getSimpleName() + "{");
	}
	
	@Override public void exitSetup(@NotNull AplusplusParser.SetupContext ctx) {
		System.out.println("}");
	}
	
	
	
	//Group
	@Override public void enterGroup(@NotNull AplusplusParser.GroupContext ctx) {
		// Prints the groupStatementContext + the group name and an open bracket
		System.out.println(ctx.getClass().getSimpleName() + " " + ctx.getChild(1).getText() + "{");
	}

	@Override public void exitGroup(@NotNull AplusplusParser.GroupContext ctx) {
		System.out.println("}");
	}
	
	@Override public void enterGroupStmt(@NotNull AplusplusParser.GroupStmtContext ctx) {
		System.out.print("\t");
	}//getClass().getSimpleName()

	@Override public void exitGroupStmt(@NotNull AplusplusParser.GroupStmtContext ctx) {
		System.out.println(ctx.getChild(0).getClass().getSimpleName() + " " + ctx.getChild(0).getText());
		//ctx.getChild(0).getClass().getSimpleName();
	}
	
	
	
	//Program
	@Override public void enterProgram(@NotNull AplusplusParser.ProgramContext ctx) {
		System.out.println(ctx.getClass().getSimpleName() + "{");
	}
	
	@Override public void exitProgram(@NotNull AplusplusParser.ProgramContext ctx) {
		System.out.println("}");
	}	
	
	
	
	//Scenarios
	@Override public void enterScenarioDcl(@NotNull AplusplusParser.ScenarioDclContext ctx) {
		System.out.println(ctx.getClass().getSimpleName() + " " + ctx.getChild(1).toString() + "{");
	}
	
	@Override public void exitScenarioDcl(@NotNull AplusplusParser.ScenarioDclContext ctx) { 
		System.out.println("}");
	}
	
	@Override public void enterInputDcl(@NotNull AplusplusParser.InputDclContext ctx) {
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitInputDcl(@NotNull AplusplusParser.InputDclContext ctx) {
		System.out.println(")");
	}
	
	@Override public void enterOutputDcl(@NotNull AplusplusParser.OutputDclContext ctx) {
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitOutputDcl(@NotNull AplusplusParser.OutputDclContext ctx) {
		System.out.println(ctx.getChild(2).getText() + ")");
	}
	
	@Override public void enterInputParameter(@NotNull AplusplusParser.InputParameterContext ctx) {
		System.out.print("(");
	}

	@Override public void exitInputParameter(@NotNull AplusplusParser.InputParameterContext ctx) {
		System.out.print(ctx.getChild(0).getText() + ": " + ctx.getChild(1).getText() + ")");
	}
	
	@Override public void enterScenStmt(@NotNull AplusplusParser.ScenStmtContext ctx) {
		System.out.print("\t");
		if(ctx.getChild(0).getText().contains("output")){
			System.out.print("output: ");
		}
	}

	@Override public void exitScenStmt(@NotNull AplusplusParser.ScenStmtContext ctx) {
		System.out.print("\n");
	}
	
	
	//Events
	@Override public void enterEventStatement(@NotNull AplusplusParser.EventStatementContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitEventStatement(@NotNull AplusplusParser.EventStatementContext ctx) {
		System.out.println(")");
	}
	
	
	//Declarations and assignments
	@Override public void enterPinDeclaration(@NotNull AplusplusParser.PinDeclarationContext ctx) {
		System.out.print("\t");
	}
	
	@Override public void exitPinDeclaration(@NotNull AplusplusParser.PinDeclarationContext ctx) {
		System.out.print("\n");
	}
	
	@Override public void enterPinDcl(@NotNull AplusplusParser.PinDclContext ctx) { }
	
	@Override public void exitPinDcl(@NotNull AplusplusParser.PinDclContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() 
				+ "( ID:" + ctx.getChild(0).getText()
				+ ", type:" + ctx.getChild(2).getText()
				+ ", Pin:[" + ctx.getChild(6).getText() //pin number
				+ ", " + ctx.getChild(4).getText() + "] )" // A/D
				);
	}
	
	@Override public void enterVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx) {
		System.out.print("\t");
	}

	@Override public void exitVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx) {
		System.out.println(ctx.getClass().getSimpleName() 
				+ "( ID:" + ctx.getChild(1).getText()
				+ ", type:" + ctx.getChild(3).getText()
				+ ", value:" + ctx.getChild(4).getText()
				+ " )"
				);
	}
	
	@Override public void enterVarDcl(@NotNull AplusplusParser.VarDclContext ctx) {
		System.out.print("\t");
	}
	
	@Override public void exitVarDcl(@NotNull AplusplusParser.VarDclContext ctx) {
		System.out.println(ctx.getClass().getSimpleName() 
				+ "( ID:" + ctx.getChild(0).getText()
				+ ", type:" + ctx.getChild(2).getText()
				+ " )"
				);
	}
	
	@Override public void enterVarAssign(@NotNull AplusplusParser.VarAssignContext ctx) {
		if(ctx.getParent().getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print("\t");
		}
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitVarAssign(@NotNull AplusplusParser.VarAssignContext ctx) {
		System.out.println("ID:" + ctx.getChild(1) + ", Value:" + ctx.getChild(2).getText() + ")");
	}
	
	
	//Expressions and statements
	@Override public void enterExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx) {//FIXME: necessary?
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(");
	}
	
	@Override public void exitExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx) {
		System.out.println(")");
	}
	
	@Override public void enterParensExpression(@NotNull ParensExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitParensExpression(@NotNull ParensExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterNotExpression(@NotNull AplusplusParser.NotExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitNotExpression(@NotNull AplusplusParser.NotExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterMultDivideExpression(@NotNull MultDivideExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}
	
	@Override public void exitMultDivideExpression(@NotNull MultDivideExpressionContext ctx) {
		System.out.print(")");
	}
	
	@Override public void enterPlusMinusExpression(@NotNull PlusMinusExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitPlusMinusExpression(@NotNull PlusMinusExpressionContext ctx) {
		System.out.print(")");
	}
	
	@Override public void enterDifferenceExpression(@NotNull AplusplusParser.DifferenceExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitDifferenceExpression(@NotNull AplusplusParser.DifferenceExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterEqualityExpression(@NotNull AplusplusParser.EqualityExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitEqualityExpression(@NotNull AplusplusParser.EqualityExpressionContext ctx) {
		
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterAndExpression(@NotNull AplusplusParser.AndExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitAndExpression(@NotNull AplusplusParser.AndExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterOrExpression(@NotNull AplusplusParser.OrExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitOrExpression(@NotNull AplusplusParser.OrExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}
	
	@Override public void enterXorExpression(@NotNull AplusplusParser.XorExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "[" + ctx.getChild(1) + "]" + "(");
	}

	@Override public void exitXorExpression(@NotNull AplusplusParser.XorExpressionContext ctx) {
		System.out.print(")");
		if(ctx.getParent().getClass().getSimpleName().contains("ConditionContext")){
			System.out.print(":\n");
		}
	}

	@Override public void enterAssignExpression(@NotNull AplusplusParser.AssignExpressionContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + "(");
	}

	@Override public void exitAssignExpression(@NotNull AplusplusParser.AssignExpressionContext ctx) {
		System.out.print(")");
	}
	

	
	@Override public void enterToggleStmt(@NotNull AplusplusParser.ToggleStmtContext ctx) {
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(");
	}
	
	@Override public void exitToggleStmt(@NotNull AplusplusParser.ToggleStmtContext ctx) {
		System.out.println(ctx.getChild(1).getText() + ")");
	}
	
	@Override public void enterScenarioInvocation(@NotNull AplusplusParser.ScenarioInvocationContext ctx) {
		System.out.print(ctx.getClass().getSimpleName() + " " + ctx.getChild(0).getText() + "(");
	}

	@Override public void exitScenarioInvocation(@NotNull AplusplusParser.ScenarioInvocationContext ctx) {
		System.out.print(")");
	}
	
	@Override public void enterCondition(@NotNull AplusplusParser.ConditionContext ctx) {
		System.out.print("\t" + ctx.getClass().getSimpleName() + "(\t");
		
	}

	@Override public void exitCondition(@NotNull AplusplusParser.ConditionContext ctx) {
		System.out.println(")");
	}	
}