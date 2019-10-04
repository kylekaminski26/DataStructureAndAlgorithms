package sort;

import list.List;

/**
 * QuickSort Algorithm. Efficient for ArrayList.
 * @author Kyle Kaminski
 * @version March 2019
 */
public class QuickSort<E extends Comparable<E>> implements Sorter<E> { // O(n*log(n))
	// Average Case: O(log(n))
	// Worst Case: O(n^2)

	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size() - 1);
	}

	/** Sort the part of the List beginning at start and ending at end. */
	private void qSort(int start, int end) {
		if (end - start < 1)
			return;
		int p = partition(start, end);
		qSort(start, p - 1); // left sort
		qSort(p + 1, end); // right sort
	}
	
	/** Choose the start value as the pivot. 
	 * Post: All values to the left of p are smaller than pivot. 
	 * All values to the right of p are greater than or equal to pivot.
	 * Starts by choosing the value at the middle for the pivot, 
	 * 		which makes it more efficient than regular Quick Sort.
	 * @return the position of the pivot.
	 */
	private int partition(int start, int end) {
		E pivot = list.get((start + end) / 2);
		int p = (start + end) / 2;
		list.set(p, list.get(start));
		p = start;
		for (int i = start + 1; i <= end; i++)
			if (list.get(i).compareTo(pivot) < 0) {
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		list.set(p, pivot);
		return p;
	}
}