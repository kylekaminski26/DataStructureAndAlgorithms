package map;

import hash.HashTable;
import list.Iterator;
import set.*;

/**
 * A map using a HashTable.
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class HashMap<K, V> implements Map<K, V> {
	class Entry<K, V> { // Inner class.
		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		// Entries are equal if they have the same key.
		public boolean equals(Object obj) {
			Entry<K, V> other = (Entry) obj;
			return key.equals(other.key);
		}

		public int hashCode() {
			return key.hashCode();
		}

		public String toString() {
			return key + "=" + value;
		}
	} // end inner class.

	HashTable<Entry<K, V>> table;
	private Entry<K, V> entry;

	/** Default Constructor. */
	public HashMap() {
		table = new HashTable<Entry<K, V>>();
	}

	/** Constructor, with specified size. */
	public HashMap(int size) {
		table = new HashTable<Entry<K, V>>(size);
	}

	/** @return true iff this HashMap contains the specified key. */
	public boolean containsKey(K key) {
		entry = new Entry<K, V>(key, null);
		return table.containsKey(entry);
	}

	/** @return the Object at the specified key. */
	public V get(K key) {
		entry = new Entry<K, V>(key, null);
		entry = table.get(entry);
		if (entry == null)
			return null;
		return entry.value;
	}

	/** Adds a new entry to this HashMap, with a specified key and specified value. 
	 * @return the new entry. */
	public V put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value), oldEntry = table.get(newEntry);
		if (oldEntry == null) {
			table.put(newEntry);
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	/** Removes the specified key.
	 * @return the key that was removed. */
	public V remove(K key) {
		entry = new Entry<K, V>(key, null);
		entry = table.get(entry);
		if (table.remove(entry))
			return entry.value;
		return null;
	}

	public void clear() {
		table = new HashTable<Entry<K, V>>();
	}

	public boolean isEmpty() {
		return table.size() == 0;
	}

	public int size() {
		return table.size();
	}

	public String toString() {
		return table.toString();
	}

	/** @return a Set of the keys from this HashMap. */
	public Set<K> keySet() {
		Iterator it = table.iterator();
		Set set = new HashSet<K>();
		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			set.add(e.key);
		}
		return set;
	}
}