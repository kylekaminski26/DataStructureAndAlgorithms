package hash;

import list.*;

/** Use a List of Lists for quick access to data. 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class HashTable<K> {
	List <List<K>> lists;
	int size = 0; // Size of this entire HashTable, NOT size of any individual LinkedList.
	int capSize; // Global variable that stores user specified cap size from Constructor.
	
	public HashTable() {
		this(10); // Initial size of top-level ArrayList
		// When debugging, change to smaller value to make it easier to search through (ex. 3)
	}
	
	/** Creates a HashTable with a specified cap. */
	public HashTable(int cap) {
		capSize = cap;
		lists = new ArrayList<List<K>>(cap);
		for (int i = 0; i < cap; i++)
			lists.add(new LinkedList<K>());
	}
	
	/** @return true iff this HashTable contains given key. */
	public boolean containsKey(Object obj) {
		int ndx = getIndex(obj);
		return lists.get(ndx).contains(obj);
	} // O(n/10) = O(n) in theory as n --> infinity
	// In practice, if you have a lot of short LinkedLists, O(1)
	
	/** @return the key in this HashTable, which equals the given key, or null if not in the table. */
	public K get(K key) {
		int ndx = getIndex(key);
		List<K> list = lists.get(ndx);
		ndx = list.indexOf(key);
		if (ndx < 0)
			return null; // key not in table
		return list.get(ndx);
	}
	
	/** @return a valid index to lists, using the given object. */
	private int getIndex(Object obj) {
		int ndx = obj.hashCode();
		ndx = Math.abs(ndx); // Absolute value
		try {
			ndx = ndx % lists.size(); // Divide by 0 error.
		} catch (ArithmeticException e) {
			System.err.println("Cannot divide by 0.");
		}
		return ndx;
	}
	
	/** Put the given key into this HashTable. */
	public void put(K key) {
		int ndx = getIndex(key);
		lists.get(ndx).add(key);
		size++;
	}
	
	/** Remove the given obj from this HashTable if possible.
	 * @return true iff it was removed. */
	public boolean remove(Object obj) {
		int ndx = getIndex(obj);
		List<K> list = lists.get(ndx);
		if (list.remove(obj)) {
			size--;
			return true;
		}
		return false;
	}

	/** @return the number of keys in this HashTable. */
	public int size() {
		return size;
	}
	 
	/** Clear this HashTable. */
	public void clear() {
		lists = new ArrayList<List<K>>(capSize);
		//lists.clear(); // redundant since ArrayList is reinitialized.
		for (int i = 0; i < capSize; i++)
			lists.add(new LinkedList<K>());
		size = 0;
	}
	 
	/** @return true iff this HashTable is empty. */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** @return an Iterator for this HashTable. */
	public Iterator<K> iterator() {
		return new TableIterator<K>(this);
	}
	
	/** @return a toString for this HashTable. */
	public String toString() {
		Iterator<K> it = this.iterator();
		String result = "[";
		while (it.hasNext())
			result += it.next() + "," + "\n";
		result = result.substring(0, result.length() - 2);
		return result + "]";
	}
}