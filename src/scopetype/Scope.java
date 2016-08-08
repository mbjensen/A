package app.scopetype;

import app.symboltable.GroupSymbol;
import app.symboltable.PinSymbol;
import app.symboltable.ScenarioSymbol;
import app.symboltable.Symbol;
import app.symboltable.VariableSymbol;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public abstract class Scope implements IScope {
	/* 
	 * symbols represents a Symbol Tabel as a LinkedHashMap for a scope. The key is the symbols name 
	 * and the value is a Symbol containing; name, type, and scope. 
	 */
	private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
	private IScope enclosingScope;
	
	public IScope getEnclosingScope() { return enclosingScope; }
	public String toString() { return symbols.keySet().toString(); }
	
	//Constructor taking a IScope as parameter. 
	public Scope(IScope enclosingScope) {
		this.enclosingScope = enclosingScope;
	}
	
	/* 
	 * Looks up symbol name in this scope and if the name is not present
	 * looks in enclosing scope instead.
	 */
    public Symbol resolve(String name) {
		Symbol symbol = symbols.get(name);
		
        if(symbol != null){
        	return symbol;
        }
        
		if(enclosingScope != null) {
			return enclosingScope.resolve(name);
		}
		return null;
	}
    
    //Adds a symbol to the Symbol Tabel in the current scope.
	public void define(Symbol symbol) {
		symbols.put(symbol.getName(), symbol);
	}
	
	//Returns a list of variable in the current scope.
	public List<VariableSymbol> getVariables(){
		List<VariableSymbol> vars = new ArrayList<VariableSymbol>();
		
		for (Symbol s : symbols.values()){
			if (s instanceof VariableSymbol){
				vars.add((VariableSymbol) s);
			}
		}
		
		return vars;
	}
	
	//Returns a list of groups in the current scope.
	public List<GroupSymbol> getGroups(){
		List<GroupSymbol> groups = new ArrayList<GroupSymbol>();
		
		for (Symbol s : symbols.values()){
			if (s instanceof GroupSymbol){
				groups.add((GroupSymbol) s);
			}
		}
		
		return groups;
	}
	
	//Returns a list of pins in the current scope.
	public List<PinSymbol> getPins(){
		List<PinSymbol> pins = new ArrayList<PinSymbol>();
		
		for (Symbol s : symbols.values()){
			if (s instanceof PinSymbol){
				pins.add((PinSymbol) s);
			}
		}
		
		return pins;
	}
	
	//Returns a list of scenarios in the current scope.
	public List<ScenarioSymbol> getScenarios() {
		List<ScenarioSymbol> scenarios = new ArrayList<ScenarioSymbol>();
		
		for (Symbol s : symbols.values()) {
			if (s instanceof ScenarioSymbol) {
				scenarios.add((ScenarioSymbol) s);
			}
		}
		
		return scenarios;
	}
	
	//Returns the scope of a RuleContext ctx. Climbing up from the current ctx in the parsetree 
	//until it finds the scope or returns null.
	public static IScope getScope(ParseTreeProperty<IScope> scopes, RuleContext ctx){
		IScope scope = null;
		RuleContext currentNode = ctx;
		
		while (scope == null){ 
			scope = scopes.get(currentNode);
			
			if (scope == null){
				currentNode = currentNode.parent;
			}
			
			if (currentNode == null) {
				return null;
			}
		}
		
		return scope;
	}
}
