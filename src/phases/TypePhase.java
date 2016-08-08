package app.phases;

import java.util.Collection;
import java.util.Iterator;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import app.model.Event;
import app.model.Expression;
import app.model.Event.EventType;
import app.model.Expression.InvalidDatatypeException;
import app.model.Expression.InvalidExpressionException;
import app.scopetype.IScope;
import app.scopetype.Scope;
import app.symboltable.*;
import app.antlr.*;
import app.antlr.AplusplusParser.ExpressionContext;
import app.errorhandler.*;

public class TypePhase extends AplusplusBaseListener {
	private ParseTreeProperty<IScope> scopes;
	private ParseTreeWalker walker;
	
	public TypePhase(ParseTreeProperty<IScope> scopes, ParseTreeWalker walker){
		this.scopes = scopes;
		this.walker = walker;
	}

	@Override 
	public void enterGroup(@NotNull AplusplusParser.GroupContext ctx) { 
		String name = ctx.ID().getText();
		GroupSymbol group = (GroupSymbol) Scope.getScope(scopes, ctx).resolve(name);
		
		// Check if first word is a reserved keyword
		isReservedKeyword(ctx.start, group);
		
		// Empty groups are not allowed
		if (group.getType() == Symbol.Type.Invalid){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(), "Group '"+name+"' is empty");
			return;
		}
		
		// Check that all variables in the group has the same type
		for (Symbol s : group.getVars()){
			if (s == null) return;
			if (s.getType() != group.getType()){
				CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(), 
						"Group '"+name+"' does not have a consistent type of "+group.getType());
				break;
			}
		}
	}

	@Override
	public void enterEvent(@NotNull AplusplusParser.EventContext ctx) {
		String id = ctx.ID() != null ? ctx.ID().getText() : null;

		if (id != null){
			Symbol var = Scope.getScope(scopes, ctx).resolve(id);
			
			if (var == null){
				CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(), 
						"Variable '"+id+"' does not exist in this context");
			} else {
				// Give errors if event and type don't match (e.g.: no button action on time)
				switch (var.getType()){
				case Climate:
				case Light:
					CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(), 
							"Cannot add event for hardware type '"+var.getType()+"'");
					break;
				case Button:
					if (ctx.sensAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.dimAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.dimAction().getStart(), 
								"Cannot add event '"+ctx.dimAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.tempAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					}
					break;
				case Dimmer:
					if (ctx.btnAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.btnAction().getStart(),
								"Cannot add event '"+ctx.btnAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.sensAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.tempAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					}
					break;
				case TempSens:
					if (ctx.btnAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.btnAction().getStart(),
								"Cannot add event '"+ctx.btnAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.dimAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.dimAction().getStart(),
								"Cannot add event '"+ctx.dimAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.sensAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					}
					break;
				case MotionSensor:
					if (ctx.btnAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.btnAction().getStart(),
								"Cannot add event '"+ctx.btnAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.dimAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.dimAction().getStart(),
								"Cannot add event '"+ctx.dimAction().getText()+"' for hardware type '"+var.getType()+"'");
					} else if (ctx.tempAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					}
					break;
				case Time:
					if (ctx.btnAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.btnAction().getStart(),
								"Cannot add event '"+ctx.btnAction().getText()+"' for event type '"+var.getType()+"'");
					} else if (ctx.dimAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.dimAction().getStart(),
								"Cannot add event '"+ctx.dimAction().getText()+"' for event type '"+var.getType()+"'");
					} else if (ctx.sensAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for event type '"+var.getType()+"'");
					} else if (ctx.tempAction() != null){
						CustomErrorListener.customError(ctx.start, ctx.sensAction().getStart(),
								"Cannot add event '"+ctx.sensAction().getText()+"' for hardware type '"+var.getType()+"'");
					}
					break;
				}
			}
		}
	}
	
	@Override
	public void enterScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {	
		String name = ctx.ID().getText();
		ScenarioSymbol scenario = (ScenarioSymbol) Scope.getScope(scopes, ctx).resolve(name);
		isReservedKeyword(ctx.start, scenario);
		
		if (scenario.getType() != Symbol.Type.Void && !hasOutput(ctx.scenStmtBlock())){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),  
					"Scenario '"+name+"()' has an output of '"+scenario.getType()
					+"' but does not have an output statement");
		}
	}
	
	// simple check if scenario has any output statement
	private boolean hasOutput(ParseTree ctx){
		ScenarioListener scenListener = new ScenarioListener();
		walker.walk(scenListener, ctx);
		return scenListener.getHasOutput();
	}
	
	private class ScenarioListener extends AplusplusBaseListener {
		private boolean hasOutput;
		
		public boolean getHasOutput() { return hasOutput; }
		
		@Override 
		public void enterOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx) { 
			hasOutput = true;
		}
	}

	@Override
	public void enterPinDcl(AplusplusParser.PinDclContext ctx) {
		Scope scope = (Scope) Scope.getScope(scopes, ctx);
		String name = ctx.ID().getText();
		PinSymbol pin = (PinSymbol) scope.resolve(name);
		
		if (pin == null) return;
		
		isReservedKeyword(ctx.start, pin);
		
		PinSymbol existing = null;
		
		// Check if declared pin already exists 
		for (PinSymbol ps : scope.getPins()){
			if (ps.getPin() == pin.getPin()
					&& ps.getPinType() == pin.getPinType()){
				existing = ps;
				break;
			}
		}
		
		// Section handling correct pin type for hardware types
		
		if (existing != null && !existing.getName().matches(pin.getName())){
			CustomErrorListener.customError(ctx.start, ctx.NONNEG_INT().getSymbol(), 
					"Cannot declare "+pin.getName()+" at " 
					+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
					+ ". It is already in use by " + existing.getName());
		}
		
		if (ctx.hardwareType().getText().equals("motionsensor") && pin.getPinType() == Symbol.Type.Digital){
			CustomErrorListener.customError(ctx.start, ctx.NONNEG_INT().getSymbol(), 
					"Cannot declare " + pin.getName() + " at "
					+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
					+ ". motionSensor should be at analog pin.");
		}
		
		if (ctx.hardwareType().getText().equals("tempsensor") && pin.getPinType() == Symbol.Type.Digital){
			CustomErrorListener.customError(ctx.start, ctx.NONNEG_INT().getSymbol(), 
					"Cannot declare " + pin.getName() + " at "
					+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
					+ ". tempSensor should be at analog pin.");
		}
		
		if (ctx.hardwareType().getText().equals("climate") && pin.getPinType() == Symbol.Type.Digital){
			CustomErrorListener.customError(ctx.start, ctx.NONNEG_INT().getSymbol(), 
					"Cannot declare " + pin.getName() + " at "
					+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
					+ ". Climate should be at analog pin.");
		}
		
		if (ctx.hardwareType().getText().equals("dimmer") && pin.getPinType() == Symbol.Type.Digital){
			CustomErrorListener.customError(ctx.start, ctx.NONNEG_INT().getSymbol(), 
					"Cannot declare " + pin.getName() + " at "
					+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
					+ ". Dimmer should be at analog pin.");
		}
		
		if (pin.getPinType() == Symbol.Type.Analog) {
			if (pin.getPin() < 0 || pin.getPin() > 5) {
				CustomErrorListener.customError(ctx.start, ctx.PIN().getSymbol(), 
						"Cannot declare " + pin.getName() + " at "
						+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
						+ ". Analog pin should be between 0-5.");
			} 
		} else if (pin.getPinType() == Symbol.Type.Digital) {
			if (pin.getPin() < 0 || pin.getPin() > 13) {
				CustomErrorListener.customError(ctx.start, ctx.PIN().getSymbol(),
						"Cannot declare " + pin.getName() + " at "
						+ pin.getPinType().toString().toLowerCase()+" pin " + pin.getPin()
						+ ". Digital pin should be between 0-13.");
			}
		}
	}

	@Override
	public void enterVarDcl(AplusplusParser.VarDclContext ctx) {
		String name = ctx.ID().getText();
		Symbol var = Scope.getScope(scopes, ctx).resolve(name);
		
		isReservedKeyword(ctx.start, var);		
	}

	@Override
	public void enterVarAssign(AplusplusParser.VarAssignContext ctx) {
		String name = ctx.ID().getText();
		IScope scope = Scope.getScope(scopes, ctx);
		Symbol var = scope.resolve(name);
		
		if (var == null){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Variable '" + name + "'" + " does not exist");
			return;
		}
		
		isReservedKeyword(ctx.start, var);
		
		// Try to assign value to the variable
		try {
			Symbol.Type exprType = Expression.getDataType(ctx.expressionStatement().expression(), scope);
			if (var.getType() != exprType){
				
				if(var.getType() == Symbol.Type.Light) {
					if(exprType != Symbol.Type.Boolean && exprType != Symbol.Type.Percentage) {
						CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
								"'" + var.getName() + "'" + " cannot assign "
								+ exprType.toString() + " to variable of type "+var.getType().toString());
					}
				} else if(var.getType() == Symbol.Type.Climate) {
					if(exprType != Symbol.Type.Number) {
						CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
								"'" + var.getName() + "'" + " cannot assign "
								+ exprType.toString() + " to variable of type "+var.getType().toString());
					}
				} else {
					CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
							"'" + var.getName() + "'" + " cannot assign "
							+ exprType.toString() + " to variable of type "+var.getType().toString());
				}				
			}
		} catch (InvalidDatatypeException e) {
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"'" + var.getName() + "'" + " expression has invalid datatype: " + e.getMessage());
		} catch (InvalidExpressionException e) {
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"'" + var.getName() + "'" + " cannot assign invalid expression: " + e.getMessage());
		}
	}
	
	
	@Override
	public void enterVarDclAssign(AplusplusParser.VarDclAssignContext ctx) {
		String name = ctx.ID().getText();
		IScope scope = Scope.getScope(scopes, ctx);
		Symbol var = scope.resolve(name);
		
		//The variable is defined in scope phase, hence this error should never occur
		if (var == null){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Variable '" + name + "'" + " does not exist");
			return;
		}
		
		isReservedKeyword(ctx.start, var);
		
		// Try to assign value to the variable
		try {
			Symbol.Type exprType = Expression.getDataType(ctx.expressionStatement().expression(), scope);
			if (var.getType() != exprType){
				CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
						"'" + var.getName() + "'" + " cannot assign "
						+ exprType.toString() + " to variable of type "+var.getType().toString());
			}
		} catch (InvalidDatatypeException e) {
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"'" + var.getName() + "'" + " expression has invalid datatype: " + e.getMessage());
		} catch (InvalidExpressionException e) {
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"'" + var.getName() + "'" + " cannot assign invalid expression: " + e.getMessage());
		}
	}
	
	@Override 
	public void enterScenarioInvocation(@NotNull AplusplusParser.ScenarioInvocationContext ctx) { 
		IScope scope = Scope.getScope(scopes, ctx);
		ScenarioSymbol scenario = (ScenarioSymbol) scope.resolve(ctx.ID().getText());
		
		// Check if scenario (name) exists
		if (scenario == null){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Scenario '" + ctx.ID().getText() + "()'" + " does not exist");
			return;
		}
		
		// Check if formal and actual parameters match in count
		int actualParameterCount = ctx.argumentList() != null ? ctx.argumentList().expression().size() : 0;
		int formalParameterCount = scenario.getParameters().values().size();
		if (formalParameterCount != actualParameterCount){
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Scenario '" + ctx.ID().getText() + "()'" 
					+ " is called with "+actualParameterCount+" parameters"
					+" when "+formalParameterCount+" is expected");
			return;
		}
		
		Symbol formalParameter = null;
		Collection<Symbol> formalParameters = scenario.getParameters().values();
		Iterator<Symbol> it = formalParameters.iterator();
		
		// Check that the parameters match in type
		for (int i = 0; i < actualParameterCount; i++){
			Symbol.Type actualType = Symbol.Type.Invalid;
			formalParameter = it.next();
			ExpressionContext expr = ctx.argumentList().expression(i);
			try {
				actualType = Expression.getDataType(expr, scope);
				if (actualType != formalParameter.getType()){
					CustomErrorListener.customError(ctx.start, ctx.argumentList().expression(i).getStart(),
							"Parameter "+(i+1)+" in scenario call '" + ctx.ID().getText() + "()'" 
							+ " is of type "+actualType+" when "+formalParameter.getType()+" is expected");
				}
			} catch (InvalidDatatypeException e) {
				CustomErrorListener.customError(ctx.start, ctx.argumentList().expression(i).getStart(),
						"Expression parameter "+(i+1)+" in scenario call '" + ctx.ID().getText() + "()'" 
						+ " is of type "+actualType+" when "+formalParameter.getType()+" is expected");
			} catch (InvalidExpressionException e) {
				CustomErrorListener.customError(ctx.start, ctx.argumentList().expression(i).getStart(),
						"Invalid expression in parameter "+(i+1)+" in scenario call '" + ctx.ID().getText() + "()'");
			}
		}
	}
	
	@Override 
	public void enterOutputStmt(@NotNull AplusplusParser.OutputStmtContext ctx) {
		IScope scope = Scope.getScope(scopes, ctx);
		
		ScenarioSymbol scenario = (ScenarioSymbol) scope.getEnclosingScope();
		
		// Check if output matches output type
		try {
			Symbol.Type exprType = Expression.getDataType(ctx.expressionStatement().expression(), scope);
			
			if (exprType != scenario.getType()){
				CustomErrorListener.customError(ctx.start, ctx.expressionStatement().getStart(),
						"Cannot output type "+exprType+" in scenario '" 
								+ scenario.getName() + "()'" + " with output type "+scenario.getType());
			}
		} catch (InvalidDatatypeException e) {
			CustomErrorListener.customError(ctx.start, ctx.stop,
					"Invalid datatype in output expression in scenario '" 
							+ scenario.getName() + "()'");
		} catch (InvalidExpressionException e) {
			CustomErrorListener.customError(ctx.start, ctx.stop,
					"Cannot output  invalid expression in scenario '" 
							+ scenario.getName() + "()'");
		}	
	}

	private boolean isReservedKeyword(Token token, Symbol symbol){
		if (symbol == null) return false;
		
		if (symbol.isReservedKeyword()){
			CustomErrorListener.customError(token, token,
					"'" + symbol.getName() + "'" + " cannot be used as a variable name. It is a reserved keyword");
			return true;
		}
		
		return false;
	}
}
