package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** Result of dividing two Exprs. */
public class Mod extends Expr {

	public Mod(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if (left instanceof Constant && right instanceof Constant && left.equals(right))
			return new Constant(1); // x % x = 1
		if (left instanceof Constant && right instanceof Constant && right.eval() == 0)
			return right; // Undefined, return 0.
		if (left instanceof Constant && right instanceof Constant && right.eval() == 1)
			return left; // x % 1 = x.
		return this;
	}

	public int eval() {
		return left.eval() % right.eval();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Mod))
			return false;
		Mod other = (Mod) obj;
		return (left.equals(other.left) && right.equals(other.right))
				|| (left.equals(other.right) && right.equals(other.left));
	}

	public String toString() {
		return "(" + left + "%" + right + ")";
	}
}