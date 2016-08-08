package app.symboltable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import app.antlr.AplusplusParser;
import app.scopetype.IScope;

public class ScenarioSymbol extends Symbol implements IScope {
	private Map<String, Symbol> parameters = new LinkedHashMap<String, Symbol>();
    private IScope enclosingScope;
    private String scopeName;
    
    public IScope getEnclosingScope() { return enclosingScope; }
    public String getScopeName() { return scopeName; }
    public Map<String, Symbol> getParameters() { return parameters; }
    public ArrayList<AplusplusParser.ExpressionStatementContext> getOutputScenarioContentCtx;
    
    public ScenarioSymbol(String name, Type returnType, IScope enclosingScope) {
        super(name, returnType, enclosingScope);
        this.scopeName = name+"Scope";
        this.enclosingScope = enclosingScope;
    }

    public Symbol resolve(String name) {
        Symbol symbol = parameters.get(name);
        if(symbol != null) {
        	return symbol;
        }
        if(getEnclosingScope() != null) {
            return getEnclosingScope().resolve(name);
        }
        
        return null;
    }

    public void define(Symbol symbol) {
    	parameters.put(symbol.getName(), symbol);
    }

    public String toString() { return "scenario"+super.toString()+":"+parameters.values(); }
}
