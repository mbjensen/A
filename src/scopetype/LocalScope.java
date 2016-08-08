package app.scopetype;

public class LocalScope extends Scope {
	public LocalScope(IScope parent) { super(parent); }
    public String getScopeName() { return "locals"; }
}
