package set;

import list.Iterator;

/**
 * Set is an ADT. No Duplicates. No ordering is imposed.
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public interface Set<E> {
	/** @return true iff given obj is in this Set. */
	boolean contains(Object obj);

	/**
	 * Add the given value to this Set, if not already in this Set.
	 * 
	 * @return true if it was added.
	 */
	boolean add(E value);

	/**
	 * Remove the given object from this Set, if possible.
	 * 
	 * @return true iff it was removed.
	 */
	boolean remove(Object obj);

	/** @return an Iterator for this Set. */
	Iterator<E> iterator();

	/** Clear this Set. */
	void clear();

	/** @return true iff this Set is empty. */
	boolean isEmpty();

	/** @return the number of values in this Set. */
	int size();

	/** @return the union of this Set with other. */
	Set<E> union(Set<E> other);

	/**
	 * @return true iff obj is a Set which contains the same values as this Set, and
	 *         only those values which are in this Set.
	 */
	boolean equals(Object obj);

	/** @return true iff this Set is a subset of the other Set. */
	boolean isSubset(Set<E> other);

	public String toString();

	/** @return a Set which is the intersection of this 
	 * Set with the other Set */
	Set<E> intersection(Set<E> other);
}