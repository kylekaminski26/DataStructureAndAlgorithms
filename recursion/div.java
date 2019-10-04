package recursion;

public class div {
	/** @return the quotient when x is divided by y. Pre: x and y are both positive. */
	public int div(int x, int q) {
		if (x == 0)
			return 0; // Base case
		return div(x - q, q) / q + 1; // Recursive case
	}

	int mult(int x, int y) {
		if (x == 0)
			return 0; // Base case
		return mult(x - 1, y) + y; // Recursive case
	}
}