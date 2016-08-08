package app.phases;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import app.scopetype.GlobalScope;
import app.scopetype.LocalScope;
import app.scopetype.IScope;
import app.scopetype.Scope;
import app.symboltable.*;
import app.antlr.*;
import app.antlr.AplusplusParser.InputParameterContext;
import app.antlr.AplusplusParser.ScenStmtBlockContext;
import app.errorhandler.CustomErrorListener;

public class ScopePhase extends AplusplusBaseListener {
	private ParseTreeProperty<IScope> scopes = new ParseTreeProperty<IScope>();
	private GlobalScope globalScope;
	private IScope currentScope;
	
	protected IScope getCurrentScope() { return currentScope; }
	
	public ParseTreeProperty<IScope> getScopes() { return scopes; }
	public GlobalScope getGlobalScope() { return globalScope; }
	
	/*
	 * Following methods creates the scope tree structure For more info read
	 * "Language Implementation Patterns..." from page 149
	 */
	@Override
	public void enterStart(AplusplusParser.StartContext ctx) {
		globalScope = new GlobalScope();
		currentScope = globalScope;
		saveScope(ctx, currentScope);
	}

	@Override
	public void exitStart(AplusplusParser.StartContext ctx) {
		currentScope = null;
	}
	
	@Override 
	public void enterGroup(@NotNull AplusplusParser.GroupContext ctx) { 
		String name = ctx.ID().getText();
		
		Symbol group = new GroupSymbol(name, Symbol.Type.Invalid, currentScope);
		
		currentScope.define(group);
	}
	
	@Override 
	public void enterGroupStmt(@NotNull AplusplusParser.GroupStmtContext ctx) {
		String groupName = ((AplusplusParser.GroupContext)ctx.getParent()).ID().getText();
		String name = ctx.ID() != null ? ctx.ID().getText() : null;
		
		if(name == null) {
			CustomErrorListener.customError(ctx.start, ctx.getStop(),
					((AplusplusParser.GroupContext)ctx.getParent()).ID().getSymbol() + " has no members.");
		}
		
		Symbol var = currentScope.resolve(name);		
		GroupSymbol group = (GroupSymbol) currentScope.resolve(groupName);
		
		group.add(var);
		
		// set group type if not already set
		if (group.getType() == Symbol.Type.Invalid){
			group.setType(var.getType());
		}
	}

	@Override
	public void enterScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {	
		String name = ctx.ID().getText();
		IScope scope = Scope.getScope(scopes, ctx);
		Symbol existing = scope.resolve(name);
		
		if (existing != null){			
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Cannot declare the scenario '" + name + "'. The scenario already exist");
			return;
		}
		
		
		ScenarioSymbol scenario = new ScenarioSymbol(name, Symbol.getScenariotype(ctx), currentScope);

		// if any input parameters, add them to the symbol
		if (ctx.inputDcl() != null){
			for (InputParameterContext p : ctx.inputDcl().inputParameter()){
				scenario.define(new VariableSymbol(p.ID().getText(), Symbol.getType(p.type()), scenario));
			}
		}
		
		// Create a new scope with current environment
		currentScope.define(scenario);
		
		// Saves the current scope to collection of scopes FIXME
		saveScope(ctx, scenario);
		
		// Set current scope as currentScope
		currentScope = scenario;
	}

	@Override
	public void exitScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {
		// Changes currentScope to the parent level scope (=global) on exit
		currentScope = currentScope.getEnclosingScope();
	}
	
	@Override 
	public void enterScenStmtBlock(@NotNull ScenStmtBlockContext ctx) {
		// enterScenStmtBlock is already in scenarioScope: make local
		currentScope = new LocalScope(currentScope);
		// Save the content of this scope to collection of scopes FIXME
		saveScope(ctx, currentScope);
	}

	@Override 
	public void exitScenStmtBlock(@NotNull AplusplusParser.ScenStmtBlockContext ctx) {
		currentScope = currentScope.getEnclosingScope();
		
	}

	@Override
	public void enterPinDcl(AplusplusParser.PinDclContext ctx) {
		// Apply pin declaration if pin number is valid (int >= 0)
		try {
			if (ctx.NONNEG_INT() != null){
				int pinNum = Integer.parseInt(ctx.NONNEG_INT().getText());
				
				// Declare pin [variable name, pin number, hardware type, analog/digital] in scope
				PinSymbol pin = new PinSymbol(ctx.ID().getText(), pinNum, 
						Symbol.getType(ctx.hardwareType()),
						Symbol.getType(ctx.pinType()),
						currentScope);
				
				// Save pin to scope
				currentScope.define(pin);
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e){
			CustomErrorListener.customError(ctx.start, ctx.getStop(),
					ctx.ID().getText() + " has invalid pin number");
		}
	}

	@Override
	public void enterVarDcl(AplusplusParser.VarDclContext ctx) {
		String name = ctx.ID().getText();
		IScope scope = Scope.getScope(scopes, ctx);
		Symbol existing = scope.resolve(name);
		
		if (existing != null){			
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Cannot declare the variable '" + name + "'. The variable already exist");
			return;
		}
		
		// Declare variable [name, type] in scope
		Symbol var = new VariableSymbol(name, Symbol.getType(ctx.type()), currentScope);
		
		currentScope.define(var);
	}

	@Override
	public void enterVarDclAssign(AplusplusParser.VarDclAssignContext ctx) {
		String name = ctx.ID().getText();
		IScope scope = Scope.getScope(scopes, ctx);
		Symbol existing = scope.resolve(name);
		
		if (existing != null){			
			CustomErrorListener.customError(ctx.start, ctx.ID().getSymbol(),
					"Cannot declare the variable '" + name + "'. The variable already exist");
			return;
		}
		
		// Declare variable [name, type] in scope
		Symbol var = new VariableSymbol(name, Symbol.getType(ctx.type()), currentScope);
		
		currentScope.define(var);
	}
	
	private void saveScope(ParserRuleContext ctx, IScope scope) {
		scopes.put(ctx, scope);
	}
}
