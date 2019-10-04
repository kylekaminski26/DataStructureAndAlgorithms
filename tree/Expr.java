package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */

/** Arithmetic expressions for ints. */
public abstract class Expr {
	Expr left, right; // operands
	
	/** @return the value of this Expr. */
	public abstract int eval();
	
	/** Simplify this Expr, if possible.
	 * @return the simplified Expr. */
	public abstract Expr simplify();
}