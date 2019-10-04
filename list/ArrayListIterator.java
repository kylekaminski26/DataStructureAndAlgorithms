package list;

import hash.HashTable;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** A ListIterator for Array Lists. */
class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {
	boolean forward = true; // remember which way we are going/facing.

	/** Creates a new ArrayListIterator. */
	ArrayListIterator(List<E> list) {
		super(list);
	}

	/** Creates a new ArrayListIterator, with a specified start index. */
	ArrayListIterator(List<E> list, int start) {
		super(list);
		ndx = start - 1;
	}

	/** @return true if there is a previous element behind this ArrayListIterator. */
	public boolean hasPrevious() {
		return ndx >= 0;
	}

	/** @return the Object at the previous index. */
	public E previous() {
		ndx--; // Move implicit cursor left.
		forward = false; // Since moving backwards with previous(), we orient left.
		return theList.get(ndx + 1);
	}

	/** Remove the Object at the index we are at/facing. */
	public void remove() {
		if (forward) { // If we are oriented right.
			theList.remove(ndx); // Remove the index we are at.
			ndx--;
		} else // If we are oriented left.
			theList.remove(ndx + 1); // Remove the index in front of us.
	}

	/** Add a new value to this ArrayListIterator. */
	public void add(E value) {
		theList.add(ndx + 1, value);
		ndx++;
	}
	
	public boolean has2more() {
		HashTable<String> names = new HashTable<String>();
		Iterator<String> itty = names.iterator();
		while (itty.has2more()) {
			if (ndx < names.size() - 2)
				return true;
			itty.next();
		}
		return false;
	}
}
