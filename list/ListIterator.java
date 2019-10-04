package list;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** An iterator for Lists, go either direction. */
public interface ListIterator<E> extends Iterator<E>{
	/** @return true iff there is another previous element. */
	boolean hasPrevious();
	
	/** @return the value to the left of the implicit cursor. */
	public E previous();
	
	/** Remove the last value obtained by a call to next() or previous(). */
	void remove();
	
	/** Insert the given value just prior to the implicit cursor position. A subsequent call to previous()
      * should return the inserted value, and a subsequent call to next() should be unaffected. */
	public void add (E value);
}