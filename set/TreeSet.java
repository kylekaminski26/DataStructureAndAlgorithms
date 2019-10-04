package set;

import tree.*;
import list.Iterator;

/** A Set using a BinarySearchTree. Values are in natural order.
 * @author Kyle Kaminski
 * @version April 2019
 */
public class TreeSet<E extends Comparable> implements Set<E> {
	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;

	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}

	public boolean add(E value) {
		if (contains(value)) // Do not accept duplicates.
			return false;
		tree = tree.add(value); // tree must reference a BST, not an EBST.
		size++;
		return true;
	}

	public boolean remove(Object obj) {
		if (!contains(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}

	public Iterator<E> iterator() {
		if (size == 0)
			return new EmptyIterator<E>();
		return tree.iterator();
	}

	public void clear() {
		tree = new EmptyBinarySearchTree<E>();
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Set<E> union(Set<E> other) {
		Set<E> returnSet = new TreeSet<E>();
		Iterator<E> it = tree.iterator();
		Iterator<E> it2 = other.iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!other.contains(next))
				returnSet.add(next);
		}
		while (it2.hasNext())
			returnSet.add(it2.next());
		return returnSet;
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
		if (!(object.size() == this.size))
			return false;
		Iterator<E> it = this.iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!object.contains(next))
				return false;
		}
		return true;
	}

	/** @return true if this TreeSet is a subset of the comparing Set. */
	public boolean isSubset(Set<E> other) {
		Iterator<E> it = iterator();
		while (it.hasNext())
			if (!other.contains(it.next()))
				return false;
		return true;
	}
	
	public Set<E> intersection(Set<E> other) {
		Set<E> returnSet = new TreeSet<E>();
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