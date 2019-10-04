package tree;

public class Assign extends Expr {
		
	public Assign(Expr left, Expr right) {
		super.left = left;
		super.right= right;
	}
	
	public int eval() {
		((Variable) left).value = new Constant(right.eval());
		return left.eval(); // Return new value of variable.
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		return this;
	}
	
	public String toString() {
		return "(" + left + "=" + right + ")";
	}
}