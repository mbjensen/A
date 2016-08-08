package app.phases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import app.antlr.AplusplusBaseListener;
import app.antlr.AplusplusParser;
import app.antlr.AplusplusParser.ProgStmtContext;
import app.model.Event;
import app.model.Event.EventType;
import app.model.Expression;
import app.model.Expression.Id;
import app.model.Expression.InvalidExpressionException;
import app.model.Program;
import app.model.Scenario;
import app.errorhandler.CustomErrorListener;
import app.scopetype.IScope;
import app.scopetype.Scope;
import app.symboltable.GroupSymbol;
import app.symboltable.PinSymbol;
import app.symboltable.ScenarioSymbol;
import app.symboltable.Symbol;
import app.symboltable.VariableSymbol;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class CodeGenPhase extends AplusplusBaseListener {
	private AplusplusParser parser;
	private List<String> arduinoCode = new ArrayList<String>();
	private ParseTreeProperty<IScope> scopes;
	private Program program;
	private ParseTreeWalker walker;
	private String arduinoCodeOneString = "";
	
	private int indent;
	private boolean isInSetup;
	private boolean isInEvent;
	private boolean isInCondition;
	private boolean isInScenario; 
	
	public CodeGenPhase(AplusplusParser parser, ParseTreeWalker _walker, Program program, ParseTreeProperty<IScope> scopes) {
		this.parser = parser;
		this.program = program;
		walker = _walker;
		this.scopes = scopes;
		
		indent = 0;
		isInEvent = false;
		isInScenario = false;
	}
	
	public List<String> getArduinoCode() { return arduinoCode; }
	
	public String getArduinoCodeOneString() {
		for (int i = 0; i < arduinoCode.size(); i++) {
			arduinoCodeOneString += arduinoCode.get(i);
		}
		
		return arduinoCodeOneString; 
	}

	// Append string to print to file, and takes care of formatting.
	private void emit(String line, boolean newLine){
		if (newLine){ 
			// Create indentation
			String format = "";
			for (int i = 0; i < indent; i++){
				format += "  ";
			}
			arduinoCode.add(format+line);
		} else { 
			// Append string
			String append = arduinoCode.get(arduinoCode.size() - 1);
			append += line;
			arduinoCode.set(arduinoCode.size() - 1, append);
		}
	}

	private void emitEmptyLine(){
		emit("", true);
	}
	
	private void emitVarDcl(ParserRuleContext ctx, VariableSymbol var, Expression expr){
		String type = var.getType().toString();
		
		if (var.getType() == Symbol.Type.Boolean){
			type = "BoolClass";
		}
		
		emit(type+" "+var.getName()+" = "+type+"(",true);
		if (expr != null) emitExpression(expr, ctx);
		emit(");",false);
	}
	
	private String CapitalizeName(String s){
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
	
	private void emitGroups(ParserRuleContext ctx){
		emitEmptyLine();
		
		Scope scope = (Scope) Scope.getScope(scopes, ctx);
		List<GroupSymbol> groups = scope.getGroups();
		
		// Emit each group with its variables
		for (GroupSymbol group : groups){
			emit(group.getType()+" arr_"+group.getName()+"[] = {", true);
			indent++;
			int i =0;
			for (i = 0; i < group.getVars().size(); i++){
				Symbol var = group.getVars().get(i);
				
				if (var == null) return;
				
				emit(var.getName(),true); //emit variable name followed by a newline
				
				if (i < group.getVars().size() - 1){
					emit(",",false);
				}
			}
			indent--;
			emit("};", true);
			
			emit("Group"+group.getType()+" "+group.getName()+"="+"Group"+group.getType()+"(arr_"+group.getName()+", "+i+");", true);
		}
	}
	
	private void emitEvents(){
		emitEmptyLine();
		
		List<Event> events = program.getEvents();
		for (Event e : events){
			emitEventThreadCallbackPrototype(e);
			emitEventThreadDcl(e);
		}
	}
	
	private void emitEventsCallback(){
		emitEmptyLine();
		
		List<Event> events = program.getEvents();
		for (Event e : events){
			emitEventThreadCallback(e);
		}
	}
	
	private void emitEventThreadCallback(Event e){
		emit("void "+e.getEventCallbackId()+"() {", true);
		
		indent++;
		walker.walk(this, e.getContext());
		indent--;
		
		emit("}", true);
		emitEmptyLine();
	}
	
	private void emitEventThreadCallbackPrototype(Event e){
		emit("void "+e.getEventCallbackId()+"();", true);
	}
	
	private void emitEventThreadDcl(Event e){
		switch (e.getType()){
		case Button: 
			emit("ButtonThread "+e.getEventId()
					+" = ButtonThread("+e.getId()
					+"_pin, BTN_"+e.getAction().toUpperCase()
					+", "+e.getEventCallbackId()+");", true);
			break;
		case Dimmer:
			emit("DimmerThread "+e.getId()
					+" = DimmerThread("+e.getId()
					+", DIMMER_"+e.getAction().toUpperCase()
					+"_pin, "+e.getEventCallbackId()+");", true);
			break;
		case Sensor:
			emit("MotSensThread "+e.getEventId()
					+" = MotSensThread("+e.getId()
					+"_pin, "+e.getEventCallbackId()+");", true);
			break;
		case Temp:
			emit("TempSensThread "+e.getId()
					+" = TempSensThread("+e.getId()
					+"_pin, "+e.getEventCallbackId()+");", true);
			break;
		case Time:
			emit("TimeThread "+e.getId()
					+" = TimeThread("
					+(e.getAction().contains(":") 
							? "Time("+e.getHour()+", "+e.getMinute()+")"
							: e.getAction())
					+"_pin, "+e.getEventCallbackId()+");", true);
			break;
		case Invalid:
			//ERROR!
			break;
		}
		emitEmptyLine();
	}
	
	//Pin declaration
	private void emitHardwareVars(ParserRuleContext ctx){
		emitEmptyLine();
		
		Scope scope = (Scope) Scope.getScope(scopes, ctx);
		List<PinSymbol> pins = scope.getPins();
		
		for (PinSymbol pin : pins){
			switch (pin.getType()){
			case Light:
			//case TempSens:
			case Climate:
				//A new instance of the class is initialized, with the pin number
				emit(pin.getType()+" "+pin.getName()+" = "+pin.getType()
						+"("+(pin.getPinType() == Symbol.Type.Analog ? "A" : "")+pin.getPin()+");",true);
				break;
			default:
				//If event, only the pin is declared
				emit("int "+pin.getName()+"_pin = "+(pin.getPinType() == Symbol.Type.Analog ? "A" : "")+pin.getPin()+";",true);	
			}
		}
	}
	
	private void emitVars(ParserRuleContext ctx){
		emitEmptyLine();
		
		Scope scope = (Scope) Scope.getScope(scopes, ctx);
		List<VariableSymbol> vars = scope.getVariables();
		
		for (VariableSymbol var : vars){
			emitVarDcl(ctx, var, null);
		}
	}
	
	private void emitScenarioDcl(ParserRuleContext ctx) {
		emitEmptyLine();
		
		List<Scenario> scenarios = program.getScenarios();
		for (Scenario s : scenarios) { 
		
			ScenarioSymbol scenario = (ScenarioSymbol) Scope.getScope(scopes, ctx).resolve(s.getId());	
			if(scenario.getType().toString().equals("Void")) {
				//Void is the only type we don't got a class for. So it needs to be small 'v'
				emit("void " + scenario.getName()+ "(", true);
			} else {
				emit(scenario.getType() + " " + scenario.getName()+ "(", true);
			}
			Collection<Symbol> args = scenario.getParameters().values();
			
			// emit parameters
			Iterator<Symbol> it = args.iterator();
			for (int i = 0; i < args.size(); i++){
				Symbol par = it.next();
				emit(par.getType() + " " + par.getName(), false);
			
				if (i < args.size() - 1){
					emit(", ",false);
				}
			}
		
			emit(") throw() {", false);
			indent++; 

			//Handle varibels in scenaries
			Scope varibels = (Scope) Scope.getScope(scopes, s.getContext().scenStmtBlock());
			List<VariableSymbol> vars = varibels.getVariables();
			
			for (VariableSymbol var : vars){
				emitVarDcl(ctx, var, null);
			}

			walker.walk(this, s.getContext().scenStmtBlock());
			
			indent--;
			emit("}",true);
		}
	}
	
	//Emits everything needed before main loop
	@Override
	public void enterStart(AplusplusParser.StartContext ctx) {
		emit("ThreadController controller = ThreadController();", true);
		emitHardwareVars(ctx);
		emitVars(ctx);
		emitGroups(ctx);
		emitEvents();
		emitScenarioDcl(ctx);
		emitEventsCallback();
		
	}
	
	@Override 
	public void enterSetup(@NotNull AplusplusParser.SetupContext ctx) {	
		emit("void setup() {", true);
		indent++;
		emit("Serial.begin(9600);", true); //Used for test in console
		emit("setSyncProvider(RTC.get);",true); //Gets time from real time clock
		emit("delay(5000);",true); //Give a bit of time to open console
		isInSetup = true;
	}
	
	@Override 
	public void exitSetup(@NotNull AplusplusParser.SetupContext ctx) { 
		List<Event> events = program.getEvents();
		for (Event e : events){
			if (e.getType() == EventType.Temp || e.getType() == EventType.Dimmer) {
				emit("controller.add(&"+e.getId()+");", true);
			} else {
				emit("controller.add(&"+e.getEventId()+");", true);
			}
		}
		
		indent--;
		emit("}", true);
		isInSetup = false;
	}
	
	@Override 
	public void enterEventStatement(@NotNull AplusplusParser.EventStatementContext ctx) {		
		isInEvent = true;
	}

	@Override 
	public void exitEventStatement(@NotNull AplusplusParser.EventStatementContext ctx) {
		isInEvent = false;
	}
	
	
	
	@Override
	public void enterToggleStmt(@NotNull AplusplusParser.ToggleStmtContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent | isInScenario){
			return;
		}
		
		emit(ctx.ID().getText()+".toggle();", true);
	}
	
	@Override
	public void enterScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {
		isInScenario = true;

	}
	
	@Override
	public void exitScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {
		
		isInScenario = false;
	}
	
	@Override 
	public void enterOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInScenario) {
			return;
		}
		
		emit("return ", true);
	}
	
	@Override 
	public void exitOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInScenario) {
			return;
		}
		
		emit(";", false);
	}
	
	@Override 
	public void enterProgram(@NotNull AplusplusParser.ProgramContext ctx) {
		emitEmptyLine();
		emit("void loop() ", true);

		indent++;
	}
	
	@Override 
	public void exitProgram(@NotNull AplusplusParser.ProgramContext ctx) {
		indent--;
	}
	
	@Override
	public void exitWaitStmt(AplusplusParser.WaitStmtContext ctx){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		
		//In case the wait time is a variable instead of hours, minutes and seconds
		if(ctx.ID() != null){
			arduinoCode.add("delay(" + ctx.ID().getText() + ".value);");
		} else {
			
		String time = ctx.durationLiteral().getText();
		String hour = (ctx.durationLiteral().hourLiteral() != null ? ctx.durationLiteral().hourLiteral().getText() : "");
		String min =  (ctx.durationLiteral().minLiteral()  != null ? ctx.durationLiteral().minLiteral().getText()  : "");
		String sec =  (ctx.durationLiteral().secLiteral()  != null ? ctx.durationLiteral().secLiteral().getText()  : "");
		
		
		//Time to wait specified in milliseconds
		int waitDuration = 0;
		
		//Looks at the entire durationLiteral. Use the relevant info and add it to waitDuration
		if(time.contains("hr")){
			hour = hour.substring(0, hour.length()-2);			//Remove "hr" from the string
			int hourT = Integer.parseInt(hour) * 60 * 60 * 1000;
			waitDuration += hourT;
		}
		if(time.contains("min")){
			min = min.substring(0, min.length()-3);				//Remove "min" from the string
			int minT = Integer.parseInt(min) * 60 * 1000;
			waitDuration += minT;
		}
		if(time.contains("sec")){
			sec = sec.substring(0, sec.length()-3);				//Remove "sec" from the string
			int secT  = Integer.parseInt(sec) * 1000;
			waitDuration += secT;
		}
		
		arduinoCode.add("delay(" + waitDuration + ");");
	}
	}
	
	@Override
	public void enterVarAssign(AplusplusParser.VarAssignContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario) {
			return; 
		} 
		
		emit(ctx.ID()+".assign(",true);
	}
	
	@Override
	public void exitVarAssign(AplusplusParser.VarAssignContext ctx) {
		if (isInEvent || isInScenario) {
			return;
		}
		
		emit(");",false);
	}
	
	/* This does the same as VarAssign.        *
	 * All variable declarations are moved up  *
	 * to ensure scope rules.                  */
	@Override
	public void enterVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent | isInScenario){
			return;
		}
		
		emit(ctx.ID()+".assign(",true);
	}
	
	@Override
	public void exitVarDclAssign(@NotNull AplusplusParser.VarDclAssignContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent | isInScenario){
			return;
		}
		emit(");",false);
	}
	
	///
	/// EXPRESSIONS!
	///
	
	private void enterIf(){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}

		emit("if ", true);
	}
	
	private void enterElseIf(){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		emit(" else if ", false);
	}
	
	private void enterElse(){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		emit(" else ", false);
	}
	
	private void enterBlock(){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		emit("{", false);
		indent++;
	}
	
	private void exitBlock(){
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		indent--;
		emit("}", true);
	}
	
	@Override 
	public void enterWhileStmtProg(@NotNull AplusplusParser.WhileStmtProgContext ctx) { 
		if (isInEvent || isInScenario){
			return;
		}
		emit("while ",true);
	}
	
	@Override 
	public void enterWhileStmtScen(@NotNull AplusplusParser.WhileStmtScenContext ctx) {
		if (isInEvent || isInScenario){
			return;
		}
		emit("while ",true);
	}
	
	@Override 
	public void enterIfStmtProg(@NotNull AplusplusParser.IfStmtProgContext ctx) {
		enterIf();
	}
	
	@Override 
	public void enterIfElseStmtProg(@NotNull AplusplusParser.IfElseStmtProgContext ctx) { 
		enterElseIf();
	}
	
	@Override 
	public void enterElseStmtProg(@NotNull AplusplusParser.ElseStmtProgContext ctx) {
		enterElse();
	}
	
	@Override 
	public void enterIfStmtScen(@NotNull AplusplusParser.IfStmtScenContext ctx) {
		enterIf();
	}
	
	@Override 
	public void enterIfElseStmtScen(@NotNull AplusplusParser.IfElseStmtScenContext ctx) {
		enterElseIf();
	}
	
	@Override 
	public void enterElseStmtScen(@NotNull AplusplusParser.ElseStmtScenContext ctx) {
		enterElse();
	}
	
	@Override 
	public void enterProgStmtBlock(AplusplusParser.ProgStmtBlockContext ctx) {	
		enterBlock(); 
	}
	
	public void exitProgStmtBlock(AplusplusParser.ProgStmtBlockContext ctx) {
		
		if (ctx.getParent().getClass().getSimpleName().contains("ProgramContext")) {
			emit("controller.run();", true);
		}
		exitBlock();
	}
				
	public void enterScenBlock(@NotNull AplusplusParser.ScenBlockContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		
		if (isInScenario) {
			return;
		}
		enterBlock();

	}
	
	public void exitScenBlock(@NotNull AplusplusParser.ScenBlockContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInScenario) {
			return;
		}
		exitBlock();
	}
	
	
	@Override 
	public void enterCondition(@NotNull AplusplusParser.ConditionContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		isInCondition = true;
		emit("(", false);
	}

	@Override 
	public void exitCondition(@NotNull AplusplusParser.ConditionContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		emit(".value)", false);
		isInCondition = false;
	}
	
	@Override 
	public void enterExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx) {
		// break if current walk is 'overall' code gen walk
		// this has already been outputted in enterStart
		if (isInEvent || isInScenario){
			return;
		}
		
		try {
			if (ctx.parent instanceof ProgStmtContext){
				emitEmptyLine();
			}
			
			emitExpression(Expression.buildExpression(ctx.expression()), ctx);
			
		} catch (InvalidExpressionException e) {
			CustomErrorListener.customError(ctx.start, ctx.start, "Unknown expression: This should not happen at this point");
		}
	}
	
	@Override 
	public void exitExpressionStatement(@NotNull AplusplusParser.ExpressionStatementContext ctx) {
		if (isInEvent){
			return;
		}

		if (ctx.parent instanceof ProgStmtContext){
			emit(";", false);
			emitEmptyLine();
		}
	}
	
	//Used to test
	@Override 
	public void enterAssertExpr(@NotNull AplusplusParser.AssertExprContext ctx) { 
		try {
			Expression actual = Expression.buildExpression(ctx.expression(0));
			Expression expected = Expression.buildExpression(ctx.expression(1));
			
			emitEmptyLine();
			
			
			
			emit("logAssert(\""+ctx.expression(0).getText()
					+" "+ctx.expression(1).getText()
					+"\", ", true);
			indent++;
			emitEmptyLine();
			emitExpression(actual, ctx);
			emit(".toString(), ", false);
			emitEmptyLine();
			emitExpression(expected, ctx);
			emit(".toString(), ", false);
			emitEmptyLine();
			emitExpression(actual, ctx);
			emit(".equalTo(", false);
			emitExpression(expected, ctx);
			emit(").value);", false);
			indent--;
			
		} catch (InvalidExpressionException e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 *  Determine of what type the expression is and enter the
	 *  relevant case in order to follow the precedence rules
	 */
	
	private void emitExpression(Expression e, ParserRuleContext ctx){	
		if (e == null) return;
		
		switch (e.getExpressionType()){
		case UnaryParenthesis:
			emit("(", false);
			emitExpression(((Expression.Unary)e).getArg(), ctx);
			emit(")", false);
			break;
		case UnaryNot:
			emitExpression(((Expression.Unary)e).getArg(), ctx);
			emit(".not()", false);
			break;
		case UnaryId:
			emitId((Id) e, ctx);
			break;
		case UnaryTimeLiteral:
			emit("Time("+((Expression.TimeLiteral)e).getHour()
					+","+((Expression.TimeLiteral)e).getMinute()+")", false);
			break;
		case UnaryNumberLiteral:
			emit("Number("+((Expression.NumberLiteral)e).getValue()+")", false);
			break;
		case UnaryBooleanLiteral:
			emit("BoolClass("+
					(((Expression.BooleanLiteral)e).getValue() ? "true" : "false")
					+")", false);
			break;
		case UnaryDurationLiteral:
			emit("Duration("+((Expression.DurationLiteral)e).getValue()+")", false);
			break;
		case UnaryIntervalLiteral:
			emit("Interval(\""+((Expression.IntervalLiteral)e).getValue()+"\")", false);
			if (isInCondition && !(e.getParent() instanceof Expression.ScenarioCall))
				emit(".inInterval()", false);
			break;
		case UnaryPercentageLiteral:
			emit("Percentage("+((Expression.PercentageLiteral)e).getValue()+")", false);
			break;
		
		case BinaryMultiply:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".multiply(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryDivide:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".divide(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryAddition:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".add(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinarySubtraction:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".substract(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryGreaterThan:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".greaterThan(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")",false);
			break;
		case BinaryGreaterThanEqual:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".greaterThanOrEqual(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryLessThan:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".lessThan(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryLessThanEqual:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".lessThanOrEqual(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		
		case BinaryEqual:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".equalTo(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryNotEqual:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit(".notEqualTo(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		
		case BinaryAnd:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit("._and(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryOr:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit("._or(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		case BinaryXor:
			emitExpression(((Expression.Binary)e).getArg1(), ctx);
			emit("._xor(", false);
			emitExpression(((Expression.Binary)e).getArg2(), ctx);
			emit(")", false);
			break;
		
		case Assign:
			emit(((Expression.Assign)e).getId()+".assign(", false);
			emitExpression(((Expression.Assign)e).getArg(), ctx);
			emit(")", false);
			break;
		
		case ScenarioCall:
			emit(((Expression.ScenarioCall)e).getId()+"(", false);
			int argCount = ((Expression.ScenarioCall)e).getArgs().size();
			for (int i = 0; i < argCount; i++){
				emitExpression(((Expression.ScenarioCall)e).getArgs().get(i), ctx);
				
				if (i < argCount - 1)
					emit(", ", false);
			}

			emit(")", false);
			break;
		default:
			emit("Error!", true);
		}
	}
	
	private void emitId(Expression.Id id, ParserRuleContext ctx){
		Symbol symbol = Scope.getScope(scopes, ctx).resolve(id.getId());
		
		if(symbol != null) {
			if (symbol.getType() == Symbol.Type.Interval && isInCondition
					&& !(id.getParent() instanceof Expression.ScenarioCall)) {
				emit(id.getId()+".inInterval()", false);
			} else if (symbol.getType() == Symbol.Type.TempSens) {
				emit(id.getId()+"", false);
			} else {
				emit(id.getId(), false);
			}
		}
	}
}


