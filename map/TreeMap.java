package map;

import list.Iterator;
import map.HashMap.Entry;
import set.HashSet;
import set.Set;
import tree.*;

/**
 * A map using a BT of entries.
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class TreeMap<K extends Comparable, V> implements Map<K, V> {
	class Entry<K extends Comparable, V> implements Comparable<Entry<K, V>> { // inner class
		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public int compareTo(Entry<K, V> other) {
			return key.compareTo(other.key);
		}
		
		public String toString() {
			return key + "=" + value;
		}
	} // end inner class.

	BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree();
	int size = 0;

	/** @return true iff this TreeMap contains the specified key. */
	public boolean containsKey(K key) {
		Entry<K, V> entry = new Entry<K, V>(key, null);
		return tree.containsKey(entry);
	}

	/** @return the value of the specified key. */
	public V get(K key) {
		Entry<K, V> entry = new Entry<K, V>(key, null);
		entry = tree.get(entry);
		if (entry == null)
			return null;
		return entry.value;
	}

	/** Adds a new entry with a specified key and specified value.
	 * @return null if the new entry was added, or the old value if a key was overriden. */
	public V put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value), oldEntry = tree.get(newEntry);
		if (oldEntry == null) {
			tree = tree.add(newEntry);
			size++; // This is the only time we add a new value.
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value; // Clobber old value. Size does not change.
		return oldValue;
	}
	
	/** Removes the specified key.
	 * @return the value that was removed. */
	public V remove(K key) {
	//	Entry<K, V> entry(key, null);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		entry = tree.get(entry);
		if (entry == null)
			return null;
		tree = tree.remove(entry);
		size--;
		return entry.value;
	}
	
	public void clear() {
		tree = new EmptyBinarySearchTree();
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		return tree.toString();
	}
	
	/** @return a Set of keys from this TreeMap. */
	public Set<K> keySet() {
		Iterator it = tree.iterator();
		Set set = new HashSet<K>();
		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			set.add(e.key);
		}
		return set;
	}
}