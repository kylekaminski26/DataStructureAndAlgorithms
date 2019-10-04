package BigO;

import list.*;
import sort.*;

public class BigOMethods {
	void m(int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - i; j++) // check termination condition
				System.out.println(i + j);
		for (int i = 0; i < n; i++)
			System.out.println(i);
	} // Runtime: O(n^2).

	/*
	 * Runtime depends on the type of List used. ArrayList: No hidden loop in get()
	 * = O(1). LinkedList: Hidden loop in get() = O(n).
	 */
	void m(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++)
			System.out.println(numbers.get(i));
	} // Runtime: O(n) (ArrayList) or O(n^2) (LinkedList).

	/**
	 * Pre: numbers is an ArrayList The partition method chooses the start value as
	 * the pivot value.
	 * Average Case: O(n^3)
	 * Worst Case: O(n^3)
	 */
	public void method1(List<Integer> numbers) {
		Sorter<Integer> sorter = new QuickSort<Integer>();
		for (int i = 0; i < numbers.size(); i++)
			sorter.sort(numbers);
	}

	/** Pre: numbers is an ArrayList.
	 * Average Case: O(n^3)
	 * Worst Case: O(n^3)
	 */
	public void method2(List<Integer> numbers) {
		Sorter<Integer> sorter = new SelectionSort<Integer>();
		for (int i = 0; i < numbers.size(); i++)
			sorter.sort(numbers);
	}

	/** Pre: numbers is an ArrayList. (A flag is used to determine whether any swaps
	 * are made)
	 * Average Case: O(n^2)
	 * Worst Case: O(n^2)
	 */
	public void method3(List<Integer> numbers) {
		Sorter<Integer> sorter = new BubbleSort<Integer>();
		for (int i = 0; i < numbers.size(); i++)
			sorter.sort(numbers);
	}

	/** Pre: numbers is a LinkedList (No flag is used to determine whether any swaps
	 * are made)
	 * Average Case: O(n^2)
	 * Worst Case: O(n^2)
	 */
	public void method4(List<Integer> numbers) {
		Sorter<Integer> sorter = new BubbleSortLinked<Integer>();
		sorter.sort(numbers);
	}

	/** Pre: numbers is an ArrayList.
	 * Average Case: O(nlogn)
	 * Worst Case: O(nlogn) 
	 */
	public void method5(List<Integer> numbers) {
		BinarySearch<Integer> searcher = new BinarySearch<Integer>(numbers);
		for (int i = 0; i < numbers.size(); i++)
			System.out.println(searcher.search(i));
	}
}
