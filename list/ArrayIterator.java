package list;

import hash.HashTable;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** An Iterator for ArrayLists. */
class ArrayIterator<E> implements Iterator<E>{
	List<E> theList;
	
	// Position of last value obtained.
	int ndx = -1;
	
	ArrayIterator(List<E> list) {
		theList = list;
	}

	public boolean hasNext() {
		return ndx < theList.size() - 1;
	}

	public E next() {
		ndx++;
		return theList.get(ndx);
	}

	public void remove() {
		theList.remove(ndx);
		ndx--;
	}

	public boolean has2more() {
		return ndx < theList.size() - 2;
	}
}