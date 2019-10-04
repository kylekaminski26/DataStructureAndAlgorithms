package sort;

import list.List;

/**
 * A sorting algorithm called Selection Sort. List should be an ArrayList. (get
 * and set are most common operations).
 * @author Kyle Kaminski
 * @version March 2019
 */
public class SelectionSort<E extends Comparable<E>> implements Sorter<E> { // O(n^2)
	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		for (int i = 0; i < list.size() - 1; i++)
			swap(i, posSmallest(i));
	} // O(n^2)

	/** @return position of smallest value, beginning at given start position. */
	private int posSmallest(int start) {
		int result = start;
		for (int i = start + 1; i < list.size(); i++) {
			if (list.get(i).compareTo(list.get(result)) < 0)
				result = i;
		}
		return result;
	} // O(n^2)

	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	} // O(1) constant time
}
