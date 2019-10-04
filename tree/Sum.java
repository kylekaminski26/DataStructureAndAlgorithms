package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** Result of adding two Exprs. */
public class Sum extends Expr {

	public Sum(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}

	public int eval() {
		return left.eval() + right.eval();
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if (left instanceof Constant && left.eval() == 0)
			return right; // 0 + x = x
		if (right instanceof Constant && right.eval() == 0)
			return left; // x + 0 = x
		return this;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Sum))
			return false;
		Sum other = (Sum) obj;
		return (left.equals(other.left) && right.equals(other.right))
				|| (left.equals(other.right) && right.equals(other.left));
		//Order does not matter
	}

	public String toString() {
		return "(" + left + "+" + right + ")";
	}
}