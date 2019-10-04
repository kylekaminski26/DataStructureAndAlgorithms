package map;

import set.Set;

/**
 * Values associated uniques keys. Lookup of keys is efficient.
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public interface Map<K, V> { // must take a key and a value

	/** @return true iff this Map contains given key. */
	boolean containsKey(K key);

	/** @return the value associated with given key, or null if not in Map. */
	V get(K key);

	/** Put a new entry into Map with given key and value.
	 * @return old value, or null. */
	V put(K key, V value);

	/** Remove the entry having given key from this Map, if possible.
	 * @return its value, or null. */
	V remove(K key);

	/** Clear this Map. */
	void clear();

	/** @return true iff this Map is empty. */
	boolean isEmpty();

	/** @return the number of entries in this Map. */
	int size();

	/** @return the entries in this Map as a String, in the format key=value. */
	public String toString();
	
	/** @return a Set of all the keys in this Map. */
	Set<K> keySet();
}