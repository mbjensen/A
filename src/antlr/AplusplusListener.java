// Generated from Aplusplus.g4 by ANTLR 4.4

	package app.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AplusplusParser}.
 */
public interface AplusplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code dimChange}
	 * labeled alternative in {@link AplusplusParser#dimAction}.
	 * @param ctx the parse tree
	 */
	void enterDimChange(@NotNull AplusplusParser.DimChangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dimChange}
	 * labeled alternative in {@link AplusplusParser#dimAction}.
	 * @param ctx the parse tree
	 */
	void exitDimChange(@NotNull AplusplusParser.DimChangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Climate}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterClimate(@NotNull AplusplusParser.ClimateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Climate}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitClimate(@NotNull AplusplusParser.ClimateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btnPressed}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void enterBtnPressed(@NotNull AplusplusParser.BtnPressedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btnPressed}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void exitBtnPressed(@NotNull AplusplusParser.BtnPressedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code differenceExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDifferenceExpression(@NotNull AplusplusParser.DifferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code differenceExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDifferenceExpression(@NotNull AplusplusParser.DifferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#whileStmtScen}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmtScen(@NotNull AplusplusParser.WhileStmtScenContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#whileStmtScen}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmtScen(@NotNull AplusplusParser.WhileStmtScenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull AplusplusParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull AplusplusParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull AplusplusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull AplusplusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#toggleStmt}.
	 * @param ctx the parse tree
	 */
	void enterToggleStmt(@NotNull AplusplusParser.ToggleStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#toggleStmt}.
	 * @param ctx the parse tree
	 */
	void exitToggleStmt(@NotNull AplusplusParser.ToggleStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull AplusplusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull AplusplusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertStmt}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssertStmt(@NotNull AplusplusParser.AssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertStmt}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssertStmt(@NotNull AplusplusParser.AssertStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code waitStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterWaitStatement(@NotNull AplusplusParser.WaitStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code waitStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitWaitStatement(@NotNull AplusplusParser.WaitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(@NotNull AplusplusParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(@NotNull AplusplusParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#ifElseStmtScen}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmtScen(@NotNull AplusplusParser.IfElseStmtScenContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#ifElseStmtScen}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmtScen(@NotNull AplusplusParser.IfElseStmtScenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(@NotNull AplusplusParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(@NotNull AplusplusParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpression(@NotNull AplusplusParser.PlusMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpression(@NotNull AplusplusParser.PlusMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Button}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterButton(@NotNull AplusplusParser.ButtonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Button}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitButton(@NotNull AplusplusParser.ButtonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Light}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterLight(@NotNull AplusplusParser.LightContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Light}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitLight(@NotNull AplusplusParser.LightContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(@NotNull AplusplusParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(@NotNull AplusplusParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull AplusplusParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull AplusplusParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toggleStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterToggleStatement(@NotNull AplusplusParser.ToggleStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toggleStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitToggleStatement(@NotNull AplusplusParser.ToggleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull AplusplusParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull AplusplusParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(@NotNull AplusplusParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(@NotNull AplusplusParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#outputDcl}.
	 * @param ctx the parse tree
	 */
	void enterOutputDcl(@NotNull AplusplusParser.OutputDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#outputDcl}.
	 * @param ctx the parse tree
	 */
	void exitOutputDcl(@NotNull AplusplusParser.OutputDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#varDclAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#varDclAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#scenBlock}.
	 * @param ctx the parse tree
	 */
	void enterScenBlock(@NotNull AplusplusParser.ScenBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#scenBlock}.
	 * @param ctx the parse tree
	 */
	void exitScenBlock(@NotNull AplusplusParser.ScenBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull AplusplusParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull AplusplusParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(@NotNull AplusplusParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(@NotNull AplusplusParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#whileStmtProg}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmtProg(@NotNull AplusplusParser.WhileStmtProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#whileStmtProg}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmtProg(@NotNull AplusplusParser.WhileStmtProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#scenarioInvocation}.
	 * @param ctx the parse tree
	 */
	void enterScenarioInvocation(@NotNull AplusplusParser.ScenarioInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#scenarioInvocation}.
	 * @param ctx the parse tree
	 */
	void exitScenarioInvocation(@NotNull AplusplusParser.ScenarioInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Duration}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDuration(@NotNull AplusplusParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Duration}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDuration(@NotNull AplusplusParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivideExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultDivideExpression(@NotNull AplusplusParser.MultDivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivideExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultDivideExpression(@NotNull AplusplusParser.MultDivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#inputDcl}.
	 * @param ctx the parse tree
	 */
	void enterInputDcl(@NotNull AplusplusParser.InputDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#inputDcl}.
	 * @param ctx the parse tree
	 */
	void exitInputDcl(@NotNull AplusplusParser.InputDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(@NotNull AplusplusParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(@NotNull AplusplusParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclaration}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(@NotNull AplusplusParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclaration}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(@NotNull AplusplusParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#dayType}.
	 * @param ctx the parse tree
	 */
	void enterDayType(@NotNull AplusplusParser.DayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#dayType}.
	 * @param ctx the parse tree
	 */
	void exitDayType(@NotNull AplusplusParser.DayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull AplusplusParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull AplusplusParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#secLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSecLiteral(@NotNull AplusplusParser.SecLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#secLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSecLiteral(@NotNull AplusplusParser.SecLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Analog}
	 * labeled alternative in {@link AplusplusParser#pinType}.
	 * @param ctx the parse tree
	 */
	void enterAnalog(@NotNull AplusplusParser.AnalogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Analog}
	 * labeled alternative in {@link AplusplusParser#pinType}.
	 * @param ctx the parse tree
	 */
	void exitAnalog(@NotNull AplusplusParser.AnalogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(@NotNull AplusplusParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(@NotNull AplusplusParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tempChange}
	 * labeled alternative in {@link AplusplusParser#tempAction}.
	 * @param ctx the parse tree
	 */
	void enterTempChange(@NotNull AplusplusParser.TempChangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tempChange}
	 * labeled alternative in {@link AplusplusParser#tempAction}.
	 * @param ctx the parse tree
	 */
	void exitTempChange(@NotNull AplusplusParser.TempChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#scenarioDcl}.
	 * @param ctx the parse tree
	 */
	void enterScenarioDcl(@NotNull AplusplusParser.ScenarioDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#scenarioDcl}.
	 * @param ctx the parse tree
	 */
	void exitScenarioDcl(@NotNull AplusplusParser.ScenarioDclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pinDeclaration}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterPinDeclaration(@NotNull AplusplusParser.PinDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pinDeclaration}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitPinDeclaration(@NotNull AplusplusParser.PinDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#ifElseStmtProg}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmtProg(@NotNull AplusplusParser.IfElseStmtProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#ifElseStmtProg}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmtProg(@NotNull AplusplusParser.IfElseStmtProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#ifStmtProg}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtProg(@NotNull AplusplusParser.IfStmtProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#ifStmtProg}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtProg(@NotNull AplusplusParser.IfStmtProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterInterval(@NotNull AplusplusParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitInterval(@NotNull AplusplusParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#progStmtBlock}.
	 * @param ctx the parse tree
	 */
	void enterProgStmtBlock(@NotNull AplusplusParser.ProgStmtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#progStmtBlock}.
	 * @param ctx the parse tree
	 */
	void exitProgStmtBlock(@NotNull AplusplusParser.ProgStmtBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void enterVarDcl(@NotNull AplusplusParser.VarDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void exitVarDcl(@NotNull AplusplusParser.VarDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#assertExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssertExpr(@NotNull AplusplusParser.AssertExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#assertExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssertExpr(@NotNull AplusplusParser.AssertExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sensActive}
	 * labeled alternative in {@link AplusplusParser#sensAction}.
	 * @param ctx the parse tree
	 */
	void enterSensActive(@NotNull AplusplusParser.SensActiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sensActive}
	 * labeled alternative in {@link AplusplusParser#sensAction}.
	 * @param ctx the parse tree
	 */
	void exitSensActive(@NotNull AplusplusParser.SensActiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#waitStmt}.
	 * @param ctx the parse tree
	 */
	void enterWaitStmt(@NotNull AplusplusParser.WaitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#waitStmt}.
	 * @param ctx the parse tree
	 */
	void exitWaitStmt(@NotNull AplusplusParser.WaitStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eventStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterEventStatement(@NotNull AplusplusParser.EventStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eventStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitEventStatement(@NotNull AplusplusParser.EventStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#inputParameter}.
	 * @param ctx the parse tree
	 */
	void enterInputParameter(@NotNull AplusplusParser.InputParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#inputParameter}.
	 * @param ctx the parse tree
	 */
	void exitInputParameter(@NotNull AplusplusParser.InputParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xorExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXorExpression(@NotNull AplusplusParser.XorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xorExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXorExpression(@NotNull AplusplusParser.XorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Digital}
	 * labeled alternative in {@link AplusplusParser#pinType}.
	 * @param ctx the parse tree
	 */
	void enterDigital(@NotNull AplusplusParser.DigitalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Digital}
	 * labeled alternative in {@link AplusplusParser#pinType}.
	 * @param ctx the parse tree
	 */
	void exitDigital(@NotNull AplusplusParser.DigitalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Time}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterTime(@NotNull AplusplusParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Time}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitTime(@NotNull AplusplusParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#hourLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHourLiteral(@NotNull AplusplusParser.HourLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#hourLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHourLiteral(@NotNull AplusplusParser.HourLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#minLiteral}.
	 * @param ctx the parse tree
	 */
	void enterMinLiteral(@NotNull AplusplusParser.MinLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#minLiteral}.
	 * @param ctx the parse tree
	 */
	void exitMinLiteral(@NotNull AplusplusParser.MinLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btnDblPressed}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void enterBtnDblPressed(@NotNull AplusplusParser.BtnDblPressedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btnDblPressed}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void exitBtnDblPressed(@NotNull AplusplusParser.BtnDblPressedContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull AplusplusParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull AplusplusParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scenarioCallExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterScenarioCallExpression(@NotNull AplusplusParser.ScenarioCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scenarioCallExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitScenarioCallExpression(@NotNull AplusplusParser.ScenarioCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull AplusplusParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull AplusplusParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull AplusplusParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull AplusplusParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(@NotNull AplusplusParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(@NotNull AplusplusParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MotionSensor}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterMotionSensor(@NotNull AplusplusParser.MotionSensorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MotionSensor}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitMotionSensor(@NotNull AplusplusParser.MotionSensorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TempSensor}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterTempSensor(@NotNull AplusplusParser.TempSensorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TempSensor}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitTempSensor(@NotNull AplusplusParser.TempSensorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#elseStmtScen}.
	 * @param ctx the parse tree
	 */
	void enterElseStmtScen(@NotNull AplusplusParser.ElseStmtScenContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#elseStmtScen}.
	 * @param ctx the parse tree
	 */
	void exitElseStmtScen(@NotNull AplusplusParser.ElseStmtScenContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#ifStmtScen}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtScen(@NotNull AplusplusParser.IfStmtScenContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#ifStmtScen}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtScen(@NotNull AplusplusParser.IfStmtScenContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(@NotNull AplusplusParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(@NotNull AplusplusParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#monthType}.
	 * @param ctx the parse tree
	 */
	void enterMonthType(@NotNull AplusplusParser.MonthTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#monthType}.
	 * @param ctx the parse tree
	 */
	void exitMonthType(@NotNull AplusplusParser.MonthTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(@NotNull AplusplusParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(@NotNull AplusplusParser.VarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#intervalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntervalLiteral(@NotNull AplusplusParser.IntervalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#intervalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntervalLiteral(@NotNull AplusplusParser.IntervalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#scenStmt}.
	 * @param ctx the parse tree
	 */
	void enterScenStmt(@NotNull AplusplusParser.ScenStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#scenStmt}.
	 * @param ctx the parse tree
	 */
	void exitScenStmt(@NotNull AplusplusParser.ScenStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#pinDcl}.
	 * @param ctx the parse tree
	 */
	void enterPinDcl(@NotNull AplusplusParser.PinDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#pinDcl}.
	 * @param ctx the parse tree
	 */
	void exitPinDcl(@NotNull AplusplusParser.PinDclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Percentage}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterPercentage(@NotNull AplusplusParser.PercentageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Percentage}
	 * labeled alternative in {@link AplusplusParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitPercentage(@NotNull AplusplusParser.PercentageContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull AplusplusParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull AplusplusParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParensExpression(@NotNull AplusplusParser.ParensExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParensExpression(@NotNull AplusplusParser.ParensExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull AplusplusParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull AplusplusParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull AplusplusParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link AplusplusParser#progStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull AplusplusParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull AplusplusParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull AplusplusParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#timeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTimeLiteral(@NotNull AplusplusParser.TimeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#timeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTimeLiteral(@NotNull AplusplusParser.TimeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#scenStmtBlock}.
	 * @param ctx the parse tree
	 */
	void enterScenStmtBlock(@NotNull AplusplusParser.ScenStmtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#scenStmtBlock}.
	 * @param ctx the parse tree
	 */
	void exitScenStmtBlock(@NotNull AplusplusParser.ScenStmtBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclarationAssignment}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationAssignment(@NotNull AplusplusParser.VarDeclarationAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclarationAssignment}
	 * labeled alternative in {@link AplusplusParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationAssignment(@NotNull AplusplusParser.VarDeclarationAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dimmer}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void enterDimmer(@NotNull AplusplusParser.DimmerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dimmer}
	 * labeled alternative in {@link AplusplusParser#hardwareType}.
	 * @param ctx the parse tree
	 */
	void exitDimmer(@NotNull AplusplusParser.DimmerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#elseStmtProg}.
	 * @param ctx the parse tree
	 */
	void enterElseStmtProg(@NotNull AplusplusParser.ElseStmtProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#elseStmtProg}.
	 * @param ctx the parse tree
	 */
	void exitElseStmtProg(@NotNull AplusplusParser.ElseStmtProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(@NotNull AplusplusParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(@NotNull AplusplusParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#durationLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDurationLiteral(@NotNull AplusplusParser.DurationLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#durationLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDurationLiteral(@NotNull AplusplusParser.DurationLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void enterOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void exitOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#groupStmt}.
	 * @param ctx the parse tree
	 */
	void enterGroupStmt(@NotNull AplusplusParser.GroupStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#groupStmt}.
	 * @param ctx the parse tree
	 */
	void exitGroupStmt(@NotNull AplusplusParser.GroupStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(@NotNull AplusplusParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link AplusplusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(@NotNull AplusplusParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btnHold}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void enterBtnHold(@NotNull AplusplusParser.BtnHoldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btnHold}
	 * labeled alternative in {@link AplusplusParser#btnAction}.
	 * @param ctx the parse tree
	 */
	void exitBtnHold(@NotNull AplusplusParser.BtnHoldContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#percentageLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPercentageLiteral(@NotNull AplusplusParser.PercentageLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#percentageLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPercentageLiteral(@NotNull AplusplusParser.PercentageLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AplusplusParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(@NotNull AplusplusParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AplusplusParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(@NotNull AplusplusParser.NumberLiteralContext ctx);
}