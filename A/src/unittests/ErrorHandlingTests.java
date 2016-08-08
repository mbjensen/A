package app.unittests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import app.compiler.Compiler;

public class ErrorHandlingTests {
	/* 
	 ********** Unit tests for error handling **********
	 */
	int i = 0;
	
	private String removeWhiteSpace(String string) {
		if(i == 0) {
			System.out.print("EXPECTED: " + string.replaceAll(" ", "").replaceAll("\n", "") + "\n");
			i++;
		} else {
			System.out.print("ACTUAL  : " + string.replaceAll(" ", "").replaceAll("\n", "") + "\n\n");
			i = 0;
		}

		return string.replaceAll(" ", "").replaceAll("\n", "");
	}
	
	/*************************** PINS ***************************/
	
	//General syntax error
	@Test
	public void enterPinDclWithNoPin() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	pinVar as light at analog pin \n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 31: The input was not valid in this context."
						+ "pinVar as light at analog pin"
                        + "^"
                        + "Error at line 2, with offset 27: pinVar has invalid pin number"
                        + "pinVar as light at analog pin   "
                        + "                             ^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Input Mismatch Exception + Custom error
	@Test
	public void enterPinDclWithInvalidPin() throws IOException {	
		Compiler compiler = new Compiler("setup \n"
										+"	pinVar as light at analog pin -1 \n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "The following input is not valid:"
						+ "pinVar as light at analog pin -1"
                        + "                              ^^"
                        + "Error at line 2, with offset 31: pinVar has invalid pin number"
                        + "pinVar as light at analog pin -1"
                        + "                              ^^";

		String actual = compiler.getCustomErrorListener().getErrors();		
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterPinDclWithOutOfRangePin() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	pinVar as light at digital pin 15\n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 28: Cannot declare pinVar at"
						+ "digital pin 15."
						+ " Digital pin should be between 0-13."
						+ "pinVar as light at digital pin 15"
						+ "                              ^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	/*************************** EVENTS ***************************/
	
	//Custom error
	@Test
	public void enterEventWhichDoesntExist() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	btn1 as button at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event btn5 pressed \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 6: "
						+ "Variable 'btn5' does not exist in this context"
						+ "event btn5 pressed"
						+ "      ^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddEventForIllegalHardwarType() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	light1 as light at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event light1 pressed \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 6:"
						+ "Cannot add event for hardware type 'Light'"
						+ "event light1 pressed"
						+ "      ^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalSensActionForButton() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	btn1 as button at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event btn1 active \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 11: Cannot add event"
						+ " 'active' for hardware type 'Button'"
						+ "event btn1 active"
						+ "           ^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalDimActionForButton() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	btn1 as button at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event btn1 change \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 11: Cannot add event"
						+ " 'change' for hardware type 'Button'"
						+ "event btn1 change"
						+ "           ^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalButtonActionForDimmer() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	dim1 as dimmer at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event dim1 doublepressed \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 11: Cannot add event"
						+ " 'doublepressed' for hardware type 'Dimmer'"
						+ "event dim1 doublepressed"
						+ "           ^^^^^^^^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalSensActionForDimmer() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	dim1 as dimmer at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event dim1 active \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 11: Cannot add event"
						+ " 'active' for hardware type 'Dimmer'"
						+ "event dim1 active"
						+ "           ^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalButtonActionForSensor() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	tempSens1 as tempsensor at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event tempSens1 hold \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 16: Cannot add event"
						+ " 'hold' for hardware type 'TempSens'"
						+ "event tempSens1 hold"
						+ "                ^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterEventAddIllegalDimActionForSensor() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	tempSens1 as tempsensor at analog pin 3 \n"
										+"end setup \n"
										+"program \n"
										+"event tempSens1 change \n"
										+" "
										+"end event \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 16: Cannot add event"
						+ " 'change' for hardware type 'TempSens'"
						+ "event tempSens1 change"
						+ "                ^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*************************** SCENARIOS ***************************/
	
	//Custom error
	@Test
	public void enterScenarioInvocationScenarioDoesntExist() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"end setup \n"
										+"program \n"
										+"testScen() \n"
										+"end program \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 4, with offset 0:"
						+ " Scenario 'testScen()' does not exist"
						+ "testScen()"
						+ "^^^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterScenarioInvocationNumberOfParamatersMismatch() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set var1 as number 10 \n"
										+"end setup \n"
										+"program \n"
										+"testScen(var1) \n"
										+"end program \n"
										+"scenario testScen \n"
										+"end scenario \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 5, with offset 0:"
						+ " Scenario 'testScen()' is called with 1 parameters "
						+ "when 0 is expected"
						+ "testScen(var1)"
						+ "^^^^^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterScenarioInvocationParamaterTypeMismatch() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set var1 as number 10 \n"
										+"	light1 as light at analog pin 2 \n"
										+"end setup \n"
										+"program \n"
										+"testScen(var1) \n"
										+"end program \n"
										+"scenario testScen \n"
										+"input light light1 \n"
										+"end scenario \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 6, with offset 9:"
						+ " Parameter 1 in scenario call 'testScen()' is of type Number "
						+ "when Invalid is expected"
						+ "testScen(var1)"
						+ "        ^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterOutputStmtOutputAndScenarioOutputTypeMismatch() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set b1 as boolean false \n"
										+"end setup \n"
										+"program \n"
										+"testScen() \n"
										+"end program \n"
										+"scenario testScen \n"
										+"output as number \n"
										+"output b1 \n"
										+"end scenario \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 9, with offset 7:"
						+ "Cannot output type Boolean in scenario 'testScen()'"
						+ " with output type Number"
						+ "output b1"
						+ "       ^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	/*************************** VARIABLES ***************************/
	
	//Custom error
	@Test
	public void enterVarDclIsReservedKeyword() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	auto as number \n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 1: 'auto' cannot be used as"
						+ " a variable name. It is a reserved keyword"
						+ "auto as number"
						+ "^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterVarDclAssignIsReservedKeyword() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set sizeof as number 10\n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 1: 'sizeof' cannot be used as"
						+ " a variable name. It is a reserved keyword"
						+ "set sizeof as number 10"
						+ "    ^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
	
	//Custom error
	@Test
	public void enterVarDclAssignVarAndExprTypeMismatch() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set var1 as time 10\n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 5: 'var1' cannot assign"
						+ " Number to variable of type Time"
						+ "set var1 as time 10"
						+ "            ^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}

	//Custom error
	@Test
	public void enterVarDclAssignInvalidExpression() throws IOException {
		Compiler compiler = new Compiler("setup \n"
										+"	set var1 as number invalid \n"
										+"end setup \n", false, true);
		
		compiler.compile("");
		
		String expected = "Error at line 2, with offset 5: 'var1' cannot assign"
						+ " invalid expression:"
						+ "variable 'invalid' does not exist in this context"
						+ "set var1 as number invalid"
						+ "    ^^^^";

		String actual = compiler.getCustomErrorListener().getErrors();
		compiler.getCustomErrorListener().emptyErrorList();
		
		Assert.assertEquals("UnitTestErrorHandling", removeWhiteSpace(expected), removeWhiteSpace(actual));
	}
}
