package app.unittests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import app.compiler.Compiler;
 

public class CodeGenTests {
	
	/* 
	 ********** Unit tests for setup and program generation **********
	 */
	
	private String removeWhiteSpace(String string) {
		return string.replaceAll(" ", "").replaceAll("\n", "");
	}
	
	@Test
	public void setupProgramCode() throws IOException {
		//Setup test for setup and program generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test setup and program generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestSetupAndProgram", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	
	/*
	 ********** Unit tests for variable datatype declaration in setup **********
	 */
	
	@Test
	public void setupDclNumberCode() throws IOException {
		//Setup test for number declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as number \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number var = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for number declaration generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclNumber", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void setupDclTimeCode() throws IOException {
		//Setup test for time declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as time \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time var = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for time declaration generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTime", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDclDurationCode() throws IOException {
		//Setup test for duration declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as duration \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration var = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for duration declaration generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDuration", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDclIntervalCode() throws IOException {
		//Setup test for interval declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"var as interval \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval var = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval declaration generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDclBooleanCode() throws IOException {
		//Setup test for boolean declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as boolean \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass var = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for boolean generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclBoolean", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDclPercentageCode() throws IOException {
		//Setup test for percentage declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as percentage \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage var = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for percentage generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclPercentage", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for hardwaretype pin analog declaration in setup **********
	 */
	
	@Test
	public void setupPinDclButtonAnalogCode() throws IOException {
		//Setup test for button declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as button at analog pin 1 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = A1;"
						+ "void setup() { Serial.begin(9600); setSyncProvider(RTC.get); delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for button generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclButton", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclLightAnalogCode() throws IOException {
		//Setup test for light declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as light at analog pin 2 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Light var = Light(A2);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for light generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclClimateAnalogCode() throws IOException {
		//Setup test for climate declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as climate at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Climate var = Climate(A3);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for climate generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclClimate", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclMotionsensorAnalogCode() throws IOException {
		//Setup test for motionsensor declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as motionsensor at analog pin 4 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = A4;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for motionsensor generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclMotionsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclTempsensorAnalogCode() throws IOException {
		//Setup test for tempsensor declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as tempsensor at analog pin 5 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = A5;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for tempsensor generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclDimmerAnalogCode() throws IOException {
		//Setup test for dimmer declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as dimmer at analog pin 6 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = A6;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for dimmer generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDimmer", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for hardwaretype pin digital declaration in setup **********
	 */
	
	@Test
	public void setupPinDclButtonDigitalCode() throws IOException {
		//Setup test for button declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as button at digital pin 1 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = 1;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for button generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclButton", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclLightDigitalCode() throws IOException {
		//Setup test for light declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as light at digital pin 2 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Light var = Light(2);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for light generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	
	@Test
	public void setupPinDclClimateDigitalCode() throws IOException {
		//Setup test for climate declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as climate at digital pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Climate var = Climate(3);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for climate generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclClimate", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclMotionsensorDigitalCode() throws IOException {
		//Setup test for motionsensor declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as motionsensor at digital pin 4 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = 4;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for motionsensor generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclMotionsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclTempsensorDigitalCode() throws IOException {
		//Setup test for tempsensor declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as tempsensor at digital pin 5 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = 5;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for tempsensor generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupPinDclDimmerDigitalCode() throws IOException {
		//Setup test for dimmer declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as dimmer at digital pin 6 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "int var_pin = 6;"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for dimmer generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDimmer", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for variable datatype assign in setup **********
	 */
	
	@Test
	public void setupAssignNumberCode() throws IOException {
		//Setup test for number Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	street as number \n"
										+ "	set street 12 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number street = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "street.assign(Number(12));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for number Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclNumber", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignTimeCode() throws IOException {
		//Setup test for time Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	clock as time \n"
										+"	set clock 14:00 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");

		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time clock = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "clock.assign(Time(14,0));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for time Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTime", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignDurationCodeHrMinSec() throws IOException {
		//Setup test for duration Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	runTime as duration \n"
										+"	set runTime 5 hr 2 min 35 sec \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration runTime = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "runTime.assign(Duration(18155000));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for duration Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDuration", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignDurationCodeHrSec() throws IOException {
		//Setup test for duration Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	runTime as duration \n"
										+"	set runTime 5 hr 35 sec \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration runTime = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "runTime.assign(Duration(18035000));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for duration Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDuration", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignDurationCodeHrMin() throws IOException {
		//Setup test for duration Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	runTime as duration \n"
										+"	set runTime 5 hr \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration runTime = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "runTime.assign(Duration(18000000));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for duration Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDuration", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignIntervalCodeTimeDayMonth() throws IOException {
		//Setup test for interval Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"atHome as interval \n"
										+"set atHome 17:00 to 23:00 mon tue wed apr may \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval atHome = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); atHome.assign(Interval(\"17:00 to 23:00 mon tue wed apr may\"));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignIntervalCodeTimeMonth() throws IOException {
		//Setup test for interval Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"atHome as interval \n"
										+"set atHome 17:00 to 23:00 apr may \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval atHome = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); atHome.assign(Interval(\"17:00 to 23:00 apr may\"));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignIntervalCodeTime() throws IOException {
		//Setup test for interval Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"atHome as interval \n"
										+"set atHome 17:00 to 23:00 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval atHome = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); atHome.assign(Interval(\"17:00 to 23:00\"));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignIntervalCodeTimeDay() throws IOException {
		//Setup test for interval Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"atHome as interval \n"
										+"set atHome 17:00 to 23:00 mon tue wed \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval atHome = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); atHome.assign(Interval(\"17:00 to 23:00 mon tue wed\"));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void setupAssignBooleanCode() throws IOException {
		//Setup test for boolean Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"night as boolean \n"
										+"set night false \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass night = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "night.assign(BoolClass(false));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for boolean Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclBoolean", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignPercentageCode() throws IOException {
		//Setup test for percentage Assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	finish as percentage \n"
										+"	set finish 83% \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage finish = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "finish.assign(Percentage(83));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for percentage Assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclPercentage", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for declaration and assign in one line of a variable of type datatype in setup **********
	 */
	
	@Test
	public void setupDeclAndAssignNumberCode() throws IOException {
		//Setup test for number, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+" set street as number 12 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number street = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "street.assign(Number(12));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for number, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclNumber", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDeclAndAssignTimeCode() throws IOException {
		//Setup test for time, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	clock as time \n"
										+"	set clock 14:00 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time clock = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "clock.assign(Time(14,0));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for time, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTime", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDeclAndAssignDurationCode() throws IOException {
		//Setup test for duration, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	runTime as duration \n"
										+"	set runTime 5 hr 2 min 35 sec \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration runTime = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "runTime.assign(Duration(18155000));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for duration, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclDuration", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDeclAndAssignIntervalCode() throws IOException {
		//Setup test for interval, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	var as interval \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval var = Interval();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); }\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for interval, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclInterval", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDeclAndAssignBooleanCode() throws IOException {
		//Setup test for boolean, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	night as boolean \n"
										+ "	set night false \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass night = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "night.assign(BoolClass(false));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for boolean, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclBoolean", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupDeclAndAssignPercentageCode() throws IOException {
		//Setup test for percentage, both declaration and assign in one line, generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	finish as percentage \n"
										+"	set finish 83% \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
			
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage finish = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); "
						+ 	 "finish.assign(Percentage(83));"
						+ "}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
			
		//Test for percentage, both declaration and assign in one line, generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclPercentage", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

/*
 ********** Unit tests for hardwaretype assign on hardwaretypes there not is used in an event **********
 */

	@Test
	public void setupAssignHardwareLightOnCode() throws IOException {
		//Setup test for light assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	kitchenLamp as light at analog pin 5 \n"
										+"  set kitchenLamp on \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Light kitchenLamp = Light(A5);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); kitchenLamp.assign(BoolClass(true));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for light assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignHardwareLightOffCode() throws IOException {
		//Setup test for light assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	kitchenLamp as light at analog pin 5 \n"
										+"  set kitchenLamp off \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Light kitchenLamp = Light(A5);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); kitchenLamp.assign(BoolClass(false));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for light assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignHardwareLightTrueCode() throws IOException {
		//Setup test for light assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	kitchenLamp as light at analog pin 5 \n"
										+"  set kitchenLamp true \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Light kitchenLamp = Light(A5);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); kitchenLamp.assign(BoolClass(true));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for light assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignHardwareLightFalseCode() throws IOException {
		//Setup test for light assign generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	kitchenLamp as light at analog pin 5 \n"
										+"  set kitchenLamp false \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Light kitchenLamp = Light(A5);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); kitchenLamp.assign(BoolClass(false));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for light assign generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclLight", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void setupAssignHardwareClimateCode0() throws IOException {
		//Setup test for climate declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	livingRoomClimate as climate at analog pin 7 \n"
										+"  set livingRoomClimate 0 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Climate livingRoomClimate = Climate(A7);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); livingRoomClimate.assign(Number(0));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for climate generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclClimate", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignHardwareClimateCode22() throws IOException {
		//Setup test for climate declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	livingRoomClimate as climate at analog pin 3 \n"
										+"  set livingRoomClimate 22 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Climate livingRoomClimate = Climate(A3);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); livingRoomClimate.assign(Number(22));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for climate generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclClimate", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void setupAssignHardwareClimateCodeMinus12() throws IOException {
		//Setup test for climate declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"	livingRoomClimate as climate at analog pin 8 \n"
										+"  set livingRoomClimate -12 \n"
										+"end setup \n"
										+"program \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Climate livingRoomClimate = Climate(A8);"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); livingRoomClimate.assign(Number(-12));}\n"
						+ "void loop() {controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for climate generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclClimate", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	/*
	 ********** Unit tests for Number methods in Arduino Library **********
	 */
	
	@Test
	public void programAddExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 14 \n"
										+"  set numberThree as number 9 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne + numberTwo + numberThree \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberThree = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(14));numberThree.assign(Number(9));}\n"
						+ "void loop() {numberOne.add(numberTwo).add(numberThree);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programMinusExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 14 \n"
										+"  set numberTree as number 9 \n"
										+"end setup \n"
										+"program \n"
										+" (numberOne - numberTwo - numberTree) \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberTree = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(14));numberTree.assign(Number(9));}\n"
						+ "void loop() {(numberOne.substract(numberTwo).substract(numberTree)); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programMultiplicationExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 14 \n"
										+"  set numberTree as number 9 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne * (numberTwo * numberTree) \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberTree = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(14));numberTree.assign(Number(9));}\n"
						+ "void loop() {numberOne.multiply((numberTwo.multiply(numberTree))); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programDivideExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 14 \n"
										+"  set numberTree as number 9 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne / (numberTwo / numberTree) \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberTree = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(14));numberTree.assign(Number(9));}\n"
						+ "void loop() {numberOne.divide((numberTwo.divide(numberTree))); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programEqualExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 19 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne is numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(19));}\n"
						+ "void loop() {numberOne.equalTo(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programEqualSignExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number -546 \n"
										+"  set numberTwo as number 18 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne = numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(-546));numberTwo.assign(Number(18));}\n"
						+ "void loop() {numberOne.equalTo(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programNotEqualExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number -18 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne is not numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(-18));}\n"
						+ "void loop() {numberOne.notEqualTo(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programNotEqualSignExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 19 \n"
										+"  set numberTwo as number 13 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne != numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(19));numberTwo.assign(Number(13));}\n"
						+ "void loop() {numberOne.notEqualTo(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programGreaterThanSignExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 20 \n"
										+"  set numberTwo as number 19 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne > numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(20));numberTwo.assign(Number(19));}\n"
						+ "void loop() {numberOne.greaterThan(numberTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programGreaterThanOrEqualSignExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 20 \n"
										+"  set numberTwo as number 2648 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne >= numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(20));numberTwo.assign(Number(2648));}\n"
						+ "void loop() {numberOne.greaterThanOrEqual(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programGreaterThanOrEqualSignTwoExpressionNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 20 \n"
										+"  set numberTwo as number 19 \n"
										+"end setup \n"
										+"program \n"
										+"  numberOne >= numberTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(20));numberTwo.assign(Number(19));}\n"
						+ "void loop() {numberOne.greaterThanOrEqual(numberTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for Time methods in Arduino Library **********
	 */
	
	@Test
	public void programExpressionNumberAddDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set durationOne as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne + durationOne\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Duration durationOne = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));durationOne.assign(Duration(18182000));}\n"
						+ "void loop() {timeOne.add(durationOne); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionNumberSubstractDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set durationOne as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne - durationOne \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Duration durationOne = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));durationOne.assign(Duration(18182000));}\n"
						+ "void loop() {timeOne.substract(durationOne); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeEqualTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 11:54 \n"
										+"end setup \n"
										+"program \n"
										+"  if timeOne is timeTwo \n"
										+ "end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(11,54));}\n"
						+ "void loop() {if (timeOne.equalTo(timeTwo).value) {}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeEqualSignTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 11:54 \n"
										+"end setup \n"
										+"program \n"
										+"  if timeOne = timeTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
				+ "Time timeOne = Time();"
				+ "Time timeTwo = Time();"
				+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(11,54));}\n"
				+ "void loop() {if (timeOne.equalTo(timeTwo).value) {}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeNotEqualTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 11:54 \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne is not timeTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(11,54));}\n"
						+ "void loop() {timeOne.notEqualTo(timeTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeNotEqualSignTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 11:54 \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne != timeTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(11,54));}\n"
						+ "void loop() {timeOne.notEqualTo(timeTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeGreaterThenTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 23:54 \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne > timeTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(23,54));}\n"
						+ "void loop() {timeOne.greaterThan(timeTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeGreaterThenEqualTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 08:15 \n"
										+"  set timeTwo as time 17:45 \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne >= timeTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(8,15));timeTwo.assign(Time(17,45));}\n"
						+ "void loop() {timeOne.greaterThanOrEqual(timeTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionTimeGreaterThenEqualTwoTime() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set timeOne as time 11:54 \n"
										+"  set timeTwo as time 11:54 \n"
										+"end setup \n"
										+"program \n"
										+"  timeOne => timeTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Time timeOne = Time();"
						+ "Time timeTwo = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); timeOne.assign(Time(11,54));timeTwo.assign(Time(11,54));}\n"
						+ "void loop() {timeOne.greaterThanOrEqual(timeTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for Duration methods in Arduino Library **********
	 */
	
	@Test
	public void programExpressionDurationAddDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne + durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.add(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationSubstractDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationTwo - durationOne\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000);  durationOne.assign(Duration(9244000)); durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() { durationTwo.substract(durationOne);    controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationEqualDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne is durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.equalTo(durationTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationEqualSignDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne = durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.equalTo(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationNotEqualDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne is not durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.notEqualTo(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationNotEqualSignDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne != durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.notEqualTo(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationGreaterThenDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne > durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.greaterThan(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationGreaterThenEqualDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne >= durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.greaterThanOrEqual(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationGreaterThenEqualTwoDuration() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 2hr 34min 4sec \n"
										+"  set durationTwo as duration 5hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne => durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(9244000));durationTwo.assign(Duration(18182000));}\n"
						+ "void loop() {durationOne.greaterThanOrEqual(durationTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionDurationAddDurationLargerThen50Days() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set durationOne as duration 720hr 34min 4sec \n"
										+"  set durationTwo as duration 720hr 3min 2sec \n"
										+"end setup \n"
										+"program \n"
										+"  durationOne + durationTwo\n"
										+"end program \n", true); 
		compiler.compile("");
		String expected = "ThreadController controller = ThreadController();"
						+ "Duration durationOne = Duration();"
						+ "Duration durationTwo = Duration();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); durationOne.assign(Duration(2594044000));  durationTwo.assign(Duration(2592182000));}\n"
						+ "void loop() {durationOne.add(durationTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for Percentage methods in Arduino Library **********
	 */

	@Test
	public void programExpressionPercentageAddPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 23% \n"
										+"  set percentageTwo as percentage 59% \n"
										+"end setup \n"
										+"program \n"
										+"  percentageOne + percentageTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(23));  percentageTwo.assign(Percentage(59));}\n"
						+ "void loop() {percentageOne.add(percentageTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageSubstractPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 23% \n"
										+"  set percentageTwo as percentage 59% \n"
										+"end setup \n"
										+"program \n"
										+"  percentageOne - percentageTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(23)); percentageTwo.assign(Percentage(59));}\n"
						+ "void loop() {percentageOne.substract(percentageTwo); controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageEqualPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 23% \n"
										+"  set percentageTwo as percentage 59% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne is percentageTwo \n"
										+ " end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(23));percentageTwo.assign(Percentage(59));}\n"
						+ "void loop() {if (percentageOne.equalTo(percentageTwo).value) {    } controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageEqualSignPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 23% \n"
										+"  set percentageTwo as percentage 59% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne = percentageTwo \n"
										+ " end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
				+ "Percentage percentageOne = Percentage();"
				+ "Percentage percentageTwo = Percentage();"
				+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(23));percentageTwo.assign(Percentage(59));}\n"
				+ "void loop() {if (percentageOne.equalTo(percentageTwo).value) {}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageNotEqualPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 51% \n"
										+"  set percentageTwo as percentage 21% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne is not percentageTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(51));percentageTwo.assign(Percentage(21));}\n"
						+ "void loop() {if (percentageOne.notEqualTo(percentageTwo).value){}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageNotEqualSignPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 87% \n"
										+"  set percentageTwo as percentage 21% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne != percentageTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
				+ "Percentage percentageOne = Percentage();"
				+ "Percentage percentageTwo = Percentage();"
				+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(87));percentageTwo.assign(Percentage(21));}\n"
				+ "void loop() {if (percentageOne.notEqualTo(percentageTwo).value) {    } controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageGreaterThenPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 32% \n"
										+"  set percentageTwo as percentage 86% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne > percentageTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(32));percentageTwo.assign(Percentage(86));}\n"
						+ "void loop() {if (percentageOne.greaterThan(percentageTwo).value) {    } controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageGreaterThenEqualPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 23% \n"
										+"  set percentageTwo as percentage 56% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne >= percentageTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
				+ "Percentage percentageOne = Percentage();"
				+ "Percentage percentageTwo = Percentage();"
				+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(23));percentageTwo.assign(Percentage(56));}\n"
				+ "void loop() {if (percentageOne.greaterThanOrEqual(percentageTwo).value) {    } controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageGreaterThenEqualTwoPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 20% \n"
										+"  set percentageTwo as percentage 4% \n"
										+"end setup \n"
										+"program \n"
										+"  if percentageOne => percentageTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
				+ "Percentage percentageOne = Percentage();"
				+ "Percentage percentageTwo = Percentage();"
				+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Percentage(20));percentageTwo.assign(Percentage(4));}\n"
				+ "void loop() {if (percentageOne.greaterThanOrEqual(percentageTwo).value){}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}	
	
	@Test
	public void programExpressionPercentageLessThenPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 104 \n"
										+"  set percentageTwo as percentage 54 \n"
										+"end setup \n"
										+"program \n"
										+"  percentageOne < percentageTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Number(104));percentageTwo.assign(Number(54));}\n"
						+ "void loop() {percentageOne.lessThan(percentageTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageLessThenEqualPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 4 \n"
										+"  set percentageTwo as percentage 3 \n"
										+"end setup \n"
										+"program \n"
										+"  percentageOne <= percentageTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Number(4));percentageTwo.assign(Number(3));}\n"
						+ "void loop() {percentageOne.lessThanOrEqual(percentageTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionPercentageLessThenEqualTwoPercentage() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set percentageOne as percentage 10 \n"
										+"  set percentageTwo as percentage 99 \n"
										+"end setup \n"
										+"program \n"
										+"  percentageOne =< percentageTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Percentage percentageOne = Percentage();"
						+ "Percentage percentageTwo = Percentage();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); percentageOne.assign(Number(10));percentageTwo.assign(Number(99));}\n"
						+ "void loop() {percentageOne.lessThanOrEqual(percentageTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}	
	
	/*
	 ********** Unit tests for BoolClass methods in Arduino Library **********
	 */
	
	@Test
	public void programExpressionBoolClassEqualBoolClass() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set booleanOne as boolean true \n"
										+"  set booleanTwo as boolean false \n"
										+"end setup \n"
										+"program \n"
										+"  if booleanOne is booleanTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass booleanOne = BoolClass();"
						+ "BoolClass booleanTwo = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); booleanOne.assign(BoolClass(true));booleanTwo.assign(BoolClass(false));}\n"
						+ "void loop() {if (booleanOne.equalTo(booleanTwo).value){}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionBoolClassEqualSignBoolClass() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set booleanOne as boolean true \n"
										+"  set booleanTwo as boolean true \n"
										+"end setup \n"
										+"program \n"
										+"  if booleanOne = booleanTwo \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass booleanOne = BoolClass();"
						+ "BoolClass booleanTwo = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); booleanOne.assign(BoolClass(true));booleanTwo.assign(BoolClass(true));}\n"
						+ "void loop() {if (booleanOne.equalTo(booleanTwo).value){}controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	@Test
	public void programExpressionBoolClassNotEqualBoolClass() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set booleanOne as boolean false \n"
										+"  set booleanTwo as boolean false \n"
										+"end setup \n"
										+"program \n"
										+"  booleanOne is not booleanTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass booleanOne = BoolClass();"
						+ "BoolClass booleanTwo = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); booleanOne.assign(BoolClass(false));booleanTwo.assign(BoolClass(false));}\n"
						+ "void loop() {booleanOne.notEqualTo(booleanTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	@Test
	public void programExpressionBoolClassNotEqualSignBoolClass() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set booleanOne as boolean false \n"
										+"  set booleanTwo as boolean true \n"
										+"end setup \n"
										+"program \n"
										+"  booleanOne != booleanTwo \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "BoolClass booleanOne = BoolClass();"
						+ "BoolClass booleanTwo = BoolClass();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); booleanOne.assign(BoolClass(false));booleanTwo.assign(BoolClass(true));}\n"
						+ "void loop() {booleanOne.notEqualTo(booleanTwo);controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for isInInterval methods in Arduino Library **********
	 */
	
	@Test
	public void programIsInInterval() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set intervalOne as interval 10:23 to 14:43 mon sun apr \n"
										+"  set timeOne as time 10:00 \n"
										+"end setup \n"
										+"program \n"
										+"  if (intervalOne) \n"
										+"    set timeOne 11:00\n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
	
		String expected = "ThreadController controller = ThreadController();"
						+ "Interval intervalOne = Interval();"
						+ "Time timeOne = Time();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); intervalOne.assign(Interval(\"10:23 to 14:43 mon sun apr\")); timeOne.assign(Time(10,0));}\n"
						+ "void loop() {if ((intervalOne.inInterval()).value) {timeOne.assign(Time(11,0));} controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for if statement expression **********
	 */
	
	@Test
	public void programExpressionIfStatementNumber() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 5 \n"
										+"  set numberTwo as number 4 \n"
										+"  set numberThree as number 21 \n"
										+"end setup \n"
										+"program \n"
										+"  if ((numberOne * numberTwo) < numberThree) \n"
										+"    set numberOne 10 \n"
										+"  end if \n"
										+"end program \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberThree = Number();"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(5));  numberTwo.assign(Number(4));  numberThree.assign(Number(21));}\n"
						+ "void loop() {if (((numberOne.multiply(numberTwo)).lessThan(numberThree)).value) {numberOne.assign(Number(10));} controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*
	 ********** Unit tests for if Scenarios **********
	 */
	
	@Test
	public void programExpressionIfStatementScenario() throws IOException {
		//Setup test for  declaration generation from APlus to ArduinoC
		Compiler compiler = new Compiler("setup \n"
										+"  set numberOne as number 10 \n"
										+"  set numberTwo as number 20 \n"
										+"  set numberThree as number 30 \n"
										+"end setup \n"
										+ ""
										+"program \n"
										+"  if (scenarioOne(numberOne, numberTwo) > scenarioTwo(numberOne, numberTwo)) \n"
										+"    set numberThree 250 \n"
										+"  end if \n"
										+"end program \n"
										+ ""
										+"scenario scenarioOne \n"
										+"  input number numberOne, number numberTwo \n"
										+"  output as number \n"
										+"	output numberOne * numberTwo \n"
										+"end scenario \n"
										+ ""
										+"scenario scenarioTwo \n"
										+"  input number numberOne, number numberTwo \n"
										+"  output as number \n"
										+"  output numberOne + numberTwo \n"
										+"end scenario \n", true); 
		compiler.compile("");
		
		String expected = "ThreadController controller = ThreadController();"
						+ "Number numberOne = Number();"
						+ "Number numberTwo = Number();"
						+ "Number numberThree = Number();"
						+ "Number scenarioOne(Number numberOne, Number numberTwo) throw() {return numberOne.multiply(numberTwo);}"
						+ "Number scenarioTwo(Number numberOne, Number numberTwo) throw() {return numberOne.add(numberTwo);}"
						+ "void setup() { Serial.begin(9600);  setSyncProvider(RTC.get);  delay(5000); numberOne.assign(Number(10)); numberTwo.assign(Number(20)); numberThree.assign(Number(30));}\n"
						+ "void loop() {if ((scenarioOne(numberOne, numberTwo).greaterThan(scenarioTwo(numberOne, numberTwo))).value) {numberThree.assign(Number(250));} controller.run();}";
		String actual = compiler.getArduinoCodeOneString();
		
		//Test for  generation from APlus to ArduinoC
		Assert.assertEquals("UnitTestDclTempsensor", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
}



