package hash;

import list.*;

/** An Iterator for HashTables. 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class TableIterator<K> implements Iterator<K> {
	HashTable<K> table;
	// currently iterating through this LinkedList
	int ndx = 0;
	// Iterator for a LinkedList
	Iterator<K> itty;

	/** Creates a new TableIterator. */
	TableIterator(HashTable<K> table) {
		this.table = table;
		setItty(0);
	}

	/** Set itty to the given LinkedList. */
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}

	/**
	 * @return the position of the next non-Empty LinkedList, or -1 if not found.
	 */
	private int nextList() {
		for (int i = ndx + 1; i < table.lists.size(); i++)
			if (!table.lists.get(i).isEmpty())
				return i;
		return -1;
	}

	/** @return true if there is another element in this TableIterator. */
	public boolean hasNext() {
		if (itty.hasNext())
			return true;
		return nextList() > 0;
	}

	/** @return the next element the Iterator finds. 
	 * Pre: hasNext() must be true. (Otherwise IndexOutOfBoundsException).
	 */
	public K next() {
		if (!itty.hasNext()) { // Cannot be -1
			ndx = nextList();
			setItty(ndx);
		}
		return itty.next();
	}

	/** Removes the element the Iterator is currently at. */
	public void remove() {
		itty.remove();
		table.size--;
	}

	@Override
	public boolean has2more() {
		// TODO Auto-generated method stub
		return false;
	}
}