package app.scopetype; 

import app.symboltable.Symbol;

public interface IScope {

	public String getScopeName();   		// Checks if the scope has a name
	public IScope getEnclosingScope();  	// Checks if this scope is nested in another
	public void define(Symbol symbol);		// Defines symbols in this scope
	public Symbol resolve(String name);		// Look up name in scope
}
