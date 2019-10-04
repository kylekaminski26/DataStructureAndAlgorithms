package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** Result of multiplying two Exprs. */
public class Product extends Expr {

	public Product(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if (right instanceof Constant && right.eval() == 1)
			return left; // left * 1 = left
		if (left instanceof Constant && left.eval() == 1)
			return right; // 1 * right = right
		if (right instanceof Constant && right.eval() == 0)
			return right; // left * 0 = 0
		if (left instanceof Constant && left.eval() == 0)
			return left; // 0 * right = 0
		return this;
	}

	public int eval() {
		return left.eval() * right.eval();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return (left.equals(other.left) && right.equals(other.right))
				|| (left.equals(other.right) && right.equals(other.left));
	}

	public String toString() {
		return "(" + left + "*" + right + ")";
	}
}