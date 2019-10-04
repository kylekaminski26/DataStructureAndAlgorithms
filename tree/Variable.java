package tree;

/**
 * @author Kyle Kaminski
 * @version Mar 2019
 */
public class Variable extends Expr {
	char name;
	Constant value;
	
	public Variable(char name) { // If only name was defined
		this.name = name;
		this.value = null;
	}
	
	public Variable(char name, Constant value) { // If name and value are defined
		this.name = name;
		this.value = value;
	}
	
	/** @throws IllegalArgumentException if value is null. */
	public int eval() {
		if (value == null) {
			throw new IllegalArgumentException("Variable has no value.");
		}
		return value.value;
	}

	public Expr simplify() {
		return this; // Variable itself cannot be simplified any further.
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Variable))
			return false;
		Variable var = (Variable) obj;
		return var.name == this.name; // True if param and name are equal
	}
	
	public String toString() {
		return name + "";
	}
}