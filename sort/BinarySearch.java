package sort;

import list.*;

/** Search a sorted list for a given target. ArrayList.
 * @author Kyle Kaminski
 * @version (Mar 2019)
 */
public class BinarySearch<E extends Comparable<E>> {
	List<E> list;

	public BinarySearch(List<E> list) {
		this.list = list;
	}

	/** @return a position of given target, or -1 if not found. */
	public int search(E target) {
		return binSrch(0, list.size() - 1, target);
	}

	/** @return position of target or -1. */
	private int binSrch(int start, int end, E target) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int cmp = target.compareTo(list.get(mid));
		if (cmp == 0)
			return mid;
		if (cmp < 0)
			return binSrch(start, mid - 1, target);
		// if cmp > 0
		return binSrch(mid + 1, end, target);
	}
}
