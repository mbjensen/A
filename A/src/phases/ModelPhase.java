package app.phases;

import org.antlr.v4.runtime.misc.NotNull;

import app.antlr.AplusplusBaseListener;
import app.antlr.AplusplusParser;
import app.model.Event;
import app.model.Event.EventType;
import app.model.Program;
import app.model.Scenario;

public class ModelPhase extends AplusplusBaseListener {
	private Program program;
	
	public ModelPhase(){
		program = new Program();
	}
	
	public Program getProgram() { return program; }
	
	@Override
	public void enterEvent(@NotNull AplusplusParser.EventContext ctx) {
		EventType type = EventType.Invalid;
		String id = ctx.ID() != null ? ctx.ID().getText() : null;
		String time = ctx.TIME() != null ? ctx.TIME().getText() : null;
		String action = null;
		
		// Set event type to the actual type
		if (time != null){
			action = time;
			type = EventType.Time;
		} else if (id != null){
			if (ctx.btnAction() != null){
				action = ctx.btnAction().getText();
				type = EventType.Button;
			} else if (ctx.sensAction() != null){
				action = ctx.sensAction().getText();
				type = EventType.Sensor;
			} else if (ctx.dimAction() != null){
				action = ctx.dimAction().getText();
				type = EventType.Dimmer;
			} else if (ctx.tempAction() != null){
				action = ctx.tempAction().getText();
				type = EventType.Temp;
			} else {
				action = id;
				type = EventType.Time;
			}
		}
		// Add event to the model
		program.addEvent(new Event(type, id, action, ctx));
	}
	
	@Override
	public void enterScenarioDcl(AplusplusParser.ScenarioDclContext ctx) {
		String id = ctx.ID() != null ? ctx.ID().getText() : null;
		// Add scenario to the model
		program.addScenario(new Scenario(id, ctx));
	}
}