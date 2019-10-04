package list;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** A ListIterator for LinkedLists. */
class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {	
	boolean forward = true; // Tells us which way we are oriented.
	
	/** Constructor. */
	RefListIterator(LinkedList<E> list) {
		super(list);
	}
	
	/** Constructor, with specified start index. */
	RefListIterator(LinkedList<E> list, int start) {
		super(list);
		Node<E> ref = theList.head;
		for (int i = 0; i < start; i++)
			cursor = cursor.next;
	}
	
	/** @return true iff there is another element. */
	public boolean hasNext() {
		if (theList.isEmpty())
			return false;
		return cursor.next != theList.tail;
	}
	
	/** @return the next element. */
	public E next() {
		if (forward) 
			cursor = cursor.next; 
		forward = true; 
		return cursor.value;
	}
	
	/** @return true if there is a previous element iterate. */
	public boolean hasPrevious() {
		if (!forward)
			return cursor.prev != theList.head; 
		return cursor != theList.head; 
	}
	
	/** @return the Object that is previous to this RefListIterator. */
	public E previous() {
		if (!forward)
			cursor = cursor.prev; 
		forward = false; 
		return cursor.value;
	}
	
	/** Remove the current element. */
	public void remove() {
		super.remove(); 
		if (!forward)
			cursor = cursor.next; 
		else 
			cursor = cursor.prev; 
	}
	
	/** Add the specified value to this RefListIterator. */
	public void add(E value) {
		if (forward) {
			Node<E> temp = new Node<E>(value, cursor.next, cursor);
			temp.prev.next = temp;
			temp.next.prev = temp;
			cursor = cursor.next;
			cursor.prev = temp.prev;
			cursor.next = temp.next;
		} else {
			Node<E> temp = new Node<E>(value, cursor, cursor.prev);
			temp.prev.next = temp;
			temp.next.prev = temp;
			cursor = cursor.prev.prev;
			cursor.prev = temp.prev;
			cursor.next = temp.next;
			forward = true;
		}
		theList.size++;
	}
}