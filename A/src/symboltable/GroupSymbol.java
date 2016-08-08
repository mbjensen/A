package app.symboltable;

import java.util.ArrayList;
import java.util.List;

import app.scopetype.IScope;

public class GroupSymbol extends Symbol {
	private List<Symbol> vars;
	
	//Returns a list of symbols in the group
	public List<Symbol> getVars() { return vars; }
	
	//Constructor for GroupSymbol taking a name, a type and the scope the GroupSymbol is defined in.
	//Instantiate a List of symbols there will contain the symbols defined in the group.
	public GroupSymbol(String name, Type type, IScope scope) { 
		super(name, type, scope); 
		
		vars = new ArrayList<Symbol>();
	}
	
	//Adds a symbol to a group
	public void add(Symbol var){
		vars.add(var);
	}
}
