package app.symboltable;

import app.scopetype.IScope;

public class VariableSymbol extends Symbol {
	public VariableSymbol(String name, Type type, IScope scope) { super(name, type, scope); }
}
