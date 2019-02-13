package lab1;

//******************************************************************
//	factorial.java
//	Caleb Phillips
//	Chapter 11, Lab #1
//	10/21/18 - 10/25/18
//******************************************************************

public class MathUtils {
	// -------------------------------------------------------------
	// Returns the factorial of the argument given
	// -------------------------------------------------------------
	public static int factorial(int n) throws myException {

		myException negative = new myException("Negative numbers are not allowed.");
		myException overflow = new myException("Arithmetic Overflow");

		int fac = 1;

		// Computes only if 'n' is non-negative and less than 17
		if (n >= 0) {
			if (n > 16) {
				throw overflow;
			} else {
				for (int i = n; i > 0; i--)
					fac *= i;
			}
		} else {
			throw negative; // throws the error 'negative' to myException
		}					// where it is then used in the Factorials program
		return fac;
	}
}