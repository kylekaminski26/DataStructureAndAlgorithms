package queue;

import list.*;

/**
 * A QueueADT which is NOT FIFO. Each value has a priority. Highest priority is
 * removed.
 * @author Kyle Kaminski
 * @version April 2019
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {
	List<E> values = new ArrayList<E>();

	public E remove() { // O(log(n))
		int last = values.size() - 1;
		E result = values.get(0);
		int avail = 0; // available for use
		int bc = biggerChild(avail);
		while (2 * avail + 1 < values.size() && greater(bc, last)) {
			values.set(avail, values.get(bc));
			avail = bc;
			bc = biggerChild(avail);
		}
		values.set(avail, values.get(last));
		values.remove(last);
		return result;
	}

	/** Precondition: Root has at least one child. */
	private int biggerChild(int root) {
		int left = 2 * root + 1;
		int right = left + 1;
		if (right >= values.size())
			return left;
		if (greater(left, right))
			return left;
		return right;
	}

	private boolean greater(int x, int y) {
		return values.get(x).compareTo(values.get(y)) > 0;
	}

	/** Precondition: values is a heap. Postcondition: values is a heap. */
	public void add(E value) { // O(log(n))
		values.add(value);
		int added = values.size() - 1;
		int parent = (added - 1) / 2;
		while (added > 0 && greater(added, parent)) {
			swap(added, parent);
			added = parent;
			parent = (added - 1) / 2;
		}
	}

	private void swap(int x, int y) { // O(1)
		E temp = values.get(x);
		values.set(x, values.get(y));
		values.set(y, temp);
	}

	public E peek() {
		return values.get(0);
	}

	public int size() {
		return values.size();
	}

	public void clear() {
		values.clear();
	}

	public boolean isEmpty() {
		return values.size() == 0;
	}
	
	public String toString() {
		return values.toString();
	}
}