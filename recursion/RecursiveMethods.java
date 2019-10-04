package recursion;

public class RecursiveMethods {

	/** @return n! Precondition: n >= 0. */
	int fact(int n) {
		if (n == 0)
			return 1; // Base case
		return n * fact(n - 1); // Recursive case
	}

	/** @return the nth number in the Fibonacci sequence. Precondition: n > 0. */
	int fib(int n) {
		if (n < 3)
			return 1; // Base case
		return fib(n - 1) + fib(n - 2); // Recursive case
	} // Much slower and less efficient than using a loop.

	/** @return true iff the given String is a Palindrome. */
	boolean isPal(String s) {
		if (s.length() < 2)
			return true; // Base case
		if (s.charAt(0) != s.charAt(s.length() - 1))
			return false; // Base case
		return isPal(s.substring(1, s.length() - 1)); // Recursive case
	}

	/** @return the product x * y without using a '*'. Precondition: x >= 0. */
	int mult(int x, int y) {
		if (x == 0)
			return 0; // Base case
		return mult(x - 1, y) + y; // Recursive case
	}

	/** @return the remainder when x is divided by y. Precondition: x >= 0, y > 0. */
	int mod(int x, int y) {
		if (x < y)
			return x; // Base case.
		return mod(x - y, y) % y; // Recursive case.
	}

	/** @return the quotient when x is divided by y. Pre: x and y are both positive. */
	public int div(int x, int q) {
		if (q == 0 || x < q)
			return 0; // Base case.
		else if ((x - q) == 0)
			return 1; // Base case.
		return div(x - q, q) + 1; // Recursive case.
	}
}