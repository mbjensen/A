package app.model;

import app.antlr.AplusplusParser;

public class Event {
	public static enum EventType {
		Invalid,
		Time,
		Button,
		Sensor,//motion sensor
		Dimmer,
		Temp
	}
	
	private EventType type;
	private String id;
	private String action;
	private AplusplusParser.EventContext ctx;
	
	public Event(EventType t, String _id, String a, AplusplusParser.EventContext c){
		type = t;
		id = _id;
		action = a;
		ctx = c;
	}
	
	public EventType getType() { return type; }
	public String getId() { return id; }
	public String getAction() { return action; }
	public AplusplusParser.EventContext getContext() { return ctx; }
	
	public String getEventId(){
		String id = "";
		
		id += getType().toString() + "_";
		id += getId() != null ? getId() + "_" : "";
		id += getAction() != null ? getAction().replaceAll(":", "") : "";
		
		return id;
	}
	
	public String getEventCallbackId(){
		return getEventId()+"_Callback";
	}
	
	public int getHour(){
		return Integer.parseInt(getAction().substring(0, 2));
	}
	
	public int getMinute(){
		return Integer.parseInt(getAction().substring(3, 5));
	}
}
