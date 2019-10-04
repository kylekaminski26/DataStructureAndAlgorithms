package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** Result of dividing two Exprs. */
public class Quotient extends Expr {

	public Quotient(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if (left.equals(right))
			return new Constant(1); // // x / x = 1
		if (right instanceof Constant && right.eval() == 1)
			return left; // x / 1 = x
		if (left instanceof Constant && right.eval() == 1)
			return left; // x / 1 = x
		if (right instanceof Constant && right.eval() == 0)
			return right; // x / 0 = undefined, return 0
		if (left instanceof Constant && right.eval() == 0)
			return right; // x / 0 = undefined, return 0
		if (left instanceof Quotient && right instanceof Quotient) {
			if (left.right.equals(right.right))
				return new Quotient(left.left, right.left);
			if (left.left.equals(right.left))
				return new Quotient(right.right, left.right);
		}
		return this;
	}

	public int eval() {
		return left.eval() / right.eval();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Quotient))
			return false;
		Quotient other = (Quotient) obj;
		return (left.equals(other.left) && right.equals(other.right)); // Order matters
			//	|| (left.equals(other.right) && right.equals(other.left));
	}

	public String toString() {
		return "(" + left + "/" + right + ")";
	}
}