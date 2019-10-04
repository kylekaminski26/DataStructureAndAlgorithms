package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** An Expr which is a constant int. */
public class Constant extends Expr {
	int value;

	public Constant(int value) {
		this.value = value;
	}

	public int eval() {
		return this.value;
	}

	public Expr simplify() {
		return this;
	}

	public boolean equals(Object obj) {
		Constant other = (Constant) obj; // Correct initialization?
		if (obj instanceof Constant)
			other = (Constant) obj;
		return this.value == other.value;
	}

	public String toString() {
		return value + "";
	}
}