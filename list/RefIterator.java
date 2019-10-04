package list;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** An Iterator for LinkedLists. */
class RefIterator<E> implements Iterator<E>{
	LinkedList<E> theList;
	Node<E> cursor;
	
	/** Constructor. */
	RefIterator(LinkedList<E> list) {
		theList = list;
		cursor = theList.head;
	}

	/** @return true iff there is an element after the cursor. */
	public boolean hasNext() {
		return cursor.next != theList.tail;
	}

	/** @return the next element. */
	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}

	/** Removes the current element. */
	public void remove() {
		cursor.prev.next = cursor.next; 
		cursor.next.prev = cursor.prev; 
		theList.size--;
	}

	/** @return true iff there are at least two more elements after the current element. */
	public boolean has2more() {
		return hasNext() && cursor.next.next != theList.tail;
	}	
}