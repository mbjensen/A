package app.model;

import app.antlr.AplusplusParser;
import app.model.Event.EventType;

public class Scenario {
	private String id;
	private AplusplusParser.ScenarioDclContext ctx;
	
	public Scenario(String _id, AplusplusParser.ScenarioDclContext c){
		this.id = _id;
		this.ctx = c;
	}
	
	public String getId() { return id; }
	public AplusplusParser.ScenarioDclContext getContext() { return ctx; }
}
