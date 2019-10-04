package sort;

import list.*;

/**
 * Sort a LinkedList O(n^2).
 * 
 * @author Kyle Kaminski
 * @version (Mar 2019)
 */
public class BubbleSortLinked<E extends Comparable<E>> implements Sorter<E> { // O(n^2)
	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		ListIterator<E> it;
		E left, right;
		for (int i = 0; i < list.size() - 1; i++) {
			it = list.listIterator();
			right = it.next();
			for (int j = 0; j < list.size() - i - 1; j++) {
				left = right;
				right = it.next();
				if (left.compareTo(right) > 0) {
					it.remove();
					it.previous();
					it.add(right);
					right = it.next();
				}
			}
		}
	} // O(n^2)
}