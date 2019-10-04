package sort;

import list.List;

/**
 * HeapSort Algorithm. Given List should be an ArrayList.
 * @author Kyle Kaminski
 */
public class HeapSort<E extends Comparable<E>> implements Sorter<E> {
	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		int last = list.size() - 1;
		heapify(0); // nlogn + o1 + logn ?
		while (last > 0) {
			swap(0, last);
			last--;
			percDown(0, last);
		}
	}

	private void heapify(int root) {
		int max = list.size() - 1;
		if (root >= max)
			return; // Base case
		heapify(2 * root + 1); // left child
		heapify(2 * root + 2); // right child
		percDown(root, max);
	} // O(n*log(n)) (n calls to heapify(), and each call has a call to percDown())

	private void swap(int x, int y) { // Same as other sorting methods.
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	} // O(1) constant time

	private void percDown(int root, int max) {
		int bc = biggerChild(root, max);
		while ((2 * root + 1) <= max && greater(bc, root)) {
			swap(root, bc);
			root = bc;
			bc = biggerChild(root, max);
		}
	} // O(log(n))

	private int biggerChild(int root, int max) {
		int left = 2 * root + 1;
		int right = 2 * root + 2; // also can be left + 1
		if (right > max) // no right child
			return left;
		// Now assume that there must be 2 children
		if (greater(left, right))
			return left;
		return right;
	}

	/** @return true iff the value at position x is greater than the value at position y. */
	private boolean greater(int x, int y) {
		return list.get(x).compareTo(list.get(y)) > 0;
	}
}