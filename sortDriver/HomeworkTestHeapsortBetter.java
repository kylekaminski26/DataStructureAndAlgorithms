package sortDriver;

import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the Heap Sort algorithm.
 * 
 * @author Kyle Kaminski
 * @version (Apr 2019)
 */
public class HomeworkTestHeapsortBetter {
	static ArrayList<Integer> grades = new ArrayList<Integer>();
	static Random rand = new Random();

	public static void main(String args[]) {

		System.out.println("Test Heap Sort:");
		Sorter<Integer> sorter = new HeapSort<Integer>();
		testSort(sorter);

	}

	private static void testSort(Sorter<Integer> sorter) {
		init();

		int n = 30;
		System.out.println("First " + n + " before sorting");
		show(n);
		sorter.sort(grades);
		System.out.println("First " + n + " after sorting");
		show(n);
		check();

	}

	private static void init() {
		grades.clear();
		for (int i = 0; i < 20000; i++)
			grades.add(rand.nextInt(15000));

	}

	private static void show(int n) {
		for (int i = 0; i < n; i++)
			System.out.print(grades.get(i) + " ");
		System.out.println();
	}

	private static void check() {
		for (int i = 1; i < grades.size(); i++) {
			if (grades.get(i) < grades.get(i - 1))
				System.err.println("not sorted, value is " + i);
		}
		System.out.println("check terminated");
	}
}