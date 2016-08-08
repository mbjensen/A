package app.symboltable;

import app.scopetype.IScope;

public class PinSymbol extends Symbol {
	private Symbol.Type pinType;
	private int pin;
	
	public Symbol.Type getPinType() { return pinType; }
	public int getPin() { return pin; }
	
	public PinSymbol(String name, int pin, Type hardwareType, Type pinType, IScope scope) {
		super(name, hardwareType, scope); 
		
		this.pin = pin;
		this.pinType = pinType;
	}
}
