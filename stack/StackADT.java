package stack;

/** A Last-In, First-Out List (LIFO). */
public interface StackADT<E> {
	
	/** Add the given value at "top" of this stack.
	 * @return the value pushed. */
	E push(E value);
	
	/** Remove the value from the top of this stack.
	 * @return the removed value.
	 * Precondition: The stack is not empty. */
	E pop();
	
	/** @return the value on top of this stack.
	 * Precondition: The stack is not empty. */
	E peek();
	
	/** Clear this Stack. */
	void clear();
	 
	/** @return true iff this StackADT is empty. */
	boolean isEmpty();
	 
	/** @return the number of values in this StackADT. */
	int size();
}
