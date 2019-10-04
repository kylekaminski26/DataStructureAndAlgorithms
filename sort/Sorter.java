package sort;

import list.*;

/**
 * @author Kyle Kaminski
 * @version March 2019
 */

/** An ADT for sorting Lists of values which are Comparable. */
public interface Sorter<E extends Comparable<E>> {
	void sort(List<E> list);
}