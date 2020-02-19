package jtm.activity08;

// TODO implement basic mathematical operations with int numbers in range
// of [-10..+10] (including)
// Note that:
// 1. input range is checked using assertions (so if they are disabled, inputs can be any int)
// 2. outputs are always checked and exception is thrown if it is outside proper range

public class SimpleCalc {

	// TODO specify that method can throw SimpleCalcException
	public static int add(int a, int b) throws SimpleCalcException {
		// TODO implement adding operation
		validateInput(a, b);

		return validateOutput(a, b, "+");
	}

	// TODO specify that method can throw SimpleCalcException
	public static int subtract(int a, int b) throws SimpleCalcException {
		// TODO implement subtract operation
		validateInput(a, b);
		return validateOutput(a, b, "-");
	}

	// TODO specify that method can throw SimpleCalcException
	public static int multiply(int a, int b) throws SimpleCalcException	{
		// TODO implement multiply operation
		validateInput(a, b);

		return validateOutput(a, b, "*");
	}

	// TODO specify that method can throw SimpleCalcException
	public static int divide(int a, int b) throws SimpleCalcException {
		// TODO implement divide operation
		validateInput(a, b);

		return validateOutput(a, b, "/");
	}

	// TODO Validate that inputs are in range of -10..+10 using assertions
	// Use following messages for assertion description if values are not in
	// range:
	// "input value a: A is below -10"
	// "input value a: A is above 10"
	// "input value b: B is below -10"
	// "input value b: B is above 10"
	// "input value a: A is below -10 and b: B is below -10"
	// "input value a: A is above 10 and b: B is below -10"
	// "input value a: a is below -10 and b: B is above 10"
	// "input value a: a is above 10 and b: B is above 10"
	//
	// where: A and B are actual values of a and b.
	//
	// hint:
	// note that assert allows only simple boolean expression
	// (i.e. without &, |, () and similar constructs).
	// therefore for more complicated checks use following approach:
	// if (long && complicated || statement)
	// assert false: "message if statement not fulfilled";
	//
	private static void validateInput(int a, int b) {
		assert a >= -10 || b >= 10 || b <= -10 : "input value a: " + a + " is below -10";
		assert a <= 10 || b >= 10 || b <= -10 : "input value a: " + a + " is above 10";
		assert b >= -10 || a >= 10 || a <= -10 : "input value b: " + b + " is below -10";
		assert b <= 10 || a >= 10 || a <= -10 : "input value b: " + b + " is above 10";
		assert a >= -10 || b >= -10 : "input value a: " + a + " is below -10 and b: " + b + " is below -10";
		assert a <= 10 || b >= -10 : "input value a: " + a + " is above 10 and b: " + b + " is below -10";
		assert a >= -10 || b <= 10 : "input value a: " + a + " is below -10 and b: " + b + " is above 10";
		assert a <= 10 || b <= 10 : "input value a: " + a + " is above 10 and b: " + b + " is above 10";

	}

	// TODO use this method to check that result of operation is also in
	// range of -10..+10.
	// If result is not in range:
	//     throw SimpleCalcException with message:
	//     "output value a oper b = result is above 10"
	//     "output value a oper b = result is below -10"
	//     where oper is +, -, *, /
	// Else:
	//     return result
	// Hint:
	// If division by zero is performed, catch original exception and create
	// new SimpleCalcException with message "division by zero" and add
	// original division exception as a cause for it.
	private static int validateOutput(int a, int b, String operation) throws SimpleCalcException {
		int sum = 0;
		switch (operation) {
			case "+":
				sum = a+b;
				break;
			case "-":
				sum = a-b;
				break;
			case "/":
				try {
					sum = a / b;
				} catch (ArithmeticException e){
					throw new SimpleCalcException("division by zero", e);
				}
				break;
			case "*":
				sum = a*b;
				break;
		}
		if(sum > 10){
			throw new SimpleCalcException("output value " + a + " " + operation + " " +  b +" = " + sum + " is above 10");
		} else if ( sum <-10){
			throw new SimpleCalcException("output value " + a + " " + operation + " " +  b +" = " + sum + " is below -10");
		}
		return sum;
	}
}
