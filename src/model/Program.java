package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.antlr.AplusplusParser;
import app.antlr.AplusplusParser.ScenarioDclContext;

public class Program {
	private List<Event> events;
	private List<Scenario> scenarios;

	public List<Event> getEvents() { return events; }
	public List<Scenario> getScenarios() { return scenarios; }
	
	public Program(){
		events = new ArrayList<Event>();
		scenarios = new ArrayList<Scenario>();
	}
	
	public void addEvent(Event e){
		events.add(e);
	}
	
	public Event getEvent(String id){
		for (Event e : events){
			if (e.getId().matches(id)){
				return e;
			}
		}
		
		return null;
	}
	
	public void addScenario(Scenario s) {
		scenarios.add(s);
	}
	
	public Scenario getScenario(String id) {
		for (Scenario s : scenarios) {
			if (s.getId().matches(id)) {
				return s;
			}
		}
		
		return null;
	}
}
