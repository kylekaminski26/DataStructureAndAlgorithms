package sort;

import list.*;

/**
 * @author Kyle Kaminski
 * @version March 2019
 */

/** A sorting algorithm called Bubble Sort. */
public class BubbleSort<E extends Comparable<E>> implements Sorter<E> { // O(n^2)
	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		boolean swapped;
		for (int i = 0; i < list.size() - 1; i++) {
			swapped = false;
			for (int j = 0; j < list.size() - 1; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					swap(j, j + 1);
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	} // O(n^2)

	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	} // O(1) constant time
}
