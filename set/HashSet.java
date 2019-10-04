package set;

import hash.HashTable;
import list.Iterator;

/**
 * A Set using a HashTable.
 * @author Kyle Kaminski
 * @version April 2019
 */
public class HashSet<E> implements Set<E> {
	HashTable<E> table;

	public HashSet() {
		this(10);
	}

	public HashSet(int cap) {
		table = new HashTable<E>(cap);
	}

	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}

	public boolean add(E value) {
		if (contains(value)) // Do not accept duplicates.
			return false;
		table.put(value);
		return true;
	}

	public boolean remove(Object obj) {
		return table.remove(obj);
	}

	public Iterator<E> iterator() {
		return table.iterator();
	}

	public void clear() {
		table.clear();
	}

	public int size() {
		return table.size();
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public Set<E> union(Set<E> other) {
		Set<E> result = new HashSet<E>();
		Iterator<E> it = table.iterator();
		Iterator<E> it2 = other.iterator();
		while (it.hasNext()) {
			E next = it.next();
			result.add(next);
		}
		while (it2.hasNext())
			result.add(it2.next());
		return result;
	}

	public String toString() {
		Iterator<E> it = this.iterator();
		String out = "";
		while (it.hasNext())
			out += it.next().toString() + " ";
		return out;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Set))
			return false;
		Set<E> object = (Set<E>) obj;
		if (!(object.size() == this.size()))
			return false;
		Iterator<E> it = this.iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!object.contains(next))
				return false;
		}
		return true;
	}

	/** @return true if this HashSet is a subset of the comparing Set. */
	public boolean isSubset(Set<E> other) {
		Iterator<E> it = iterator();
		while (it.hasNext())
			if (!other.contains(it.next()))
				return false;
		return true;
	}
	
	public Set<E> intersection(Set<E> other) {
		Set<E> returnSet = new HashSet<E>();
		Iterator<E> it = this.iterator();
		while (it.hasNext()) {
			if (this.contains(it) && other.contains(it)) {
				// if both Sets contain the same value
				E next = it.next();
				returnSet.add(next); // Add to temp Set
			}
		}
		return returnSet;
	}
}