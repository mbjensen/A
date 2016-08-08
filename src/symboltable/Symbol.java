package app.symboltable;

import org.antlr.v4.runtime.ParserRuleContext;

import app.antlr.AplusplusParser.BooleanContext;
import app.antlr.AplusplusParser.ButtonContext;
import app.antlr.AplusplusParser.ClimateContext;
import app.antlr.AplusplusParser.DatatypeContext;
import app.antlr.AplusplusParser.DimmerContext;
import app.antlr.AplusplusParser.DurationContext;
import app.antlr.AplusplusParser.HardwareTypeContext;
import app.antlr.AplusplusParser.IntervalContext;
import app.antlr.AplusplusParser.LightContext;
import app.antlr.AplusplusParser.MotionSensorContext;
import app.antlr.AplusplusParser.NumberContext;
import app.antlr.AplusplusParser.OutputDclContext;
import app.antlr.AplusplusParser.PercentageContext;
import app.antlr.AplusplusParser.PinTypeContext;
import app.antlr.AplusplusParser.ScenarioDclContext;
import app.antlr.AplusplusParser.TempSensorContext;
import app.antlr.AplusplusParser.TimeContext;
import app.antlr.AplusplusParser.TypeContext;
import app.errorhandler.CustomErrorListener;
import app.scopetype.IScope;

public class Symbol {

	public static enum Type { Invalid, Void, Number, Boolean, Duration,
		Time, Interval, Percentage, Light, Button, Climate, MotionSensor, TempSens, Dimmer,
		Analog, Digital }
	
	/* 
	 * 	Reserved keywords from C, C++ and Arduino specific code.
	 * 	Implemented in order to make sure the programmer cannot use variable
	 *  names that are reserved in the three languages
	 */
	
	public static String[] resKeywords = {
		//C Keywords
		"auto", "break", "case", "char", "const", "continue", "default", "do",
		"double", "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register", "return", "short",
		"signed", "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned", "void", "volatile", "while",
		//C++ Keywords
		"alignas", "alignof", "and", "and_eq", "asm", "auto", "bitand", "bitor", "bool", "case", "catch", "char", 
		"char16_t", "char32_t", "class", "compl", "concept", "constexpr", "const_cast", "decltype", "delete", "dynamic_cast", 
		"explicit", "export", "extern", "false", "float", "friend", "inline", "mutable", "namespace", "new", "noexcept", 
		"not", "not_eq", "nullptr", "operator", "or", "or_eq", "private", "protected", "public", "reinterpret_cast", "requires", 
		"short", "signed", "static", "static_assert", "static_cast", "struct", "switch", "template", "this", "thread_local", 
		"throw", "true", "try", "typedef", "typeid", "typename", "using", "virtual", "void", "wchar_t", "xor", "xor_eq",
		//ArduinoC Keywords
		"setup", "loop", "HIGH", "LOW", "INPUT", "OUTPUT", "INPUT_PULLUP", "byte", "word", "string", "String", "array", "PROGMEM", 
		"pinMode", "digitalWrite", "digitalRead", "analogReference", "analogRead", "analogWrite", "analogReadResolution", 
		"analogWriteResolution", "tone", "noTone", "shiftOut", "shiftIn", "pulseIn", "millis", "micros", "delay", "delayMicroseconds", 
		"min", "max", "abs", "constrain", "map", "pow", "sqrt", "sin", "cos", "tan", "randomSeed", "random", "lowByte", "highByte", 
		"bitRead", "bigWrite", "bitSet", "bitClear", "bit", "attachInterrupt", "detachInterrupt", "interrupts", "noInterrupts", 
		"Serial", "Stream", "Keyboard", "Mouse"	
	};
	
	private String name;
	private Type type;
	private IScope scope;
	
	public String getName() { return name; }
	public Type getType() { return type; }
	public void setType(Type t) { type = t; }
	public IScope getScope() { return scope; }
	
	public Symbol(String name, Type type, IScope scope) {
		this.type = type;
		this.scope = scope;
		this.name = name;
	}

	public String toString() {
		if (type != Type.Invalid) {
			return "<" + getName() + ":" + type + ">";
		}
		return getName();
	}
	
	public boolean isReservedKeyword(){
		if (name == null){
			return true;
		}
		
		for (int i = 0; i < Symbol.resKeywords.length; i++) {
			if (name.matches(Symbol.resKeywords[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Symbol.Type getType(ParserRuleContext ctx){
		if (ctx instanceof TypeContext){
			return getDatatype((TypeContext) ctx);
		} else if (ctx instanceof HardwareTypeContext) {
			return getHardwaretype(ctx);
		} else if (ctx instanceof PinTypeContext){
			if (ctx.getText().matches("analog")){
				return Type.Analog;
			} else if (ctx.getText().matches("digital")){
				return Type.Digital;
			}
		} else if (ctx instanceof ScenarioDclContext){
			return getScenariotype((ScenarioDclContext) ctx);
		}
		
		return Symbol.Type.Invalid;
	}
	
	public static Symbol.Type getDatatype(TypeContext ctx){
		if (ctx.getText().matches("number")){
			return Symbol.Type.Number;
		} else if (ctx.getText().matches("percentage")){
			return Symbol.Type.Percentage;
		} else if (ctx.getText().matches("time")){
			return Symbol.Type.Time;
		} else if (ctx.getText().matches("duration")){
			return Symbol.Type.Duration;
		} else if (ctx.getText().matches("boolean")){
			return Symbol.Type.Boolean;
		} else if (ctx.getText().matches("interval")){
			return Symbol.Type.Interval;
		}
		
		return Symbol.Type.Invalid;
	}
	
	public static Symbol.Type getHardwaretype(ParserRuleContext ctx){
		if (ctx.getText().matches("climate")){
			return Symbol.Type.Climate;
		} else if (ctx.getText().matches("button")){
			return Symbol.Type.Button;
		} else if (ctx.getText().matches("light")){
			return Symbol.Type.Light;
		} else if (ctx.getText().matches("motionsensor")){
			return Symbol.Type.MotionSensor;
		} else if (ctx.getText().matches("tempsensor")){
			return Symbol.Type.TempSens;
		} else if (ctx.getText().matches("dimmer")){
			return Symbol.Type.Dimmer;
		}
		
		return Symbol.Type.Invalid;
	}
	
	public static Symbol.Type getScenariotype(ScenarioDclContext ctx){
		OutputDclContext output = ctx.outputDcl();
		
		if (output != null){
			return getType(output.type());
		} else {
			return Symbol.Type.Void;
		}
	}
}
