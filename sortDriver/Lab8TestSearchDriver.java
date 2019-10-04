package sortDriver;

import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the binary search algorithm.
 * 
 * @author Kyle Kaminski
 * @version (Mar 2019)
 */
public class Lab8TestSearchDriver {
	static ArrayList<Integer> grades = new ArrayList<Integer>();
//	static Random rand = new Random();
	static int MAX = 8;

	public static void main(String args[]) {

		SelectionSort<Integer> selection = new SelectionSort();
		BubbleSort<Integer> bubble = new BubbleSort();

		// Choose one of the following sorting algorithms, and uncomment that line:
		testSort(selection);
		// testSort (bubble);
		// testSort (quick);

//		BinarySearch<Integer> searcher = new BinarySearch<Integer>(grades);
//		for (int i = 0; i < MAX; i++) {
//			int target = rand.nextInt(MAX * 3);
//			System.out.println("target " + target + " found at position " + searcher.search(target));
//		}
//
//	}
		
		BinarySearch<Integer> searcher = new BinarySearch<Integer>(grades);
		for (int i = 0; i < MAX; i++) {
			//int target = rand.nextInt(MAX * 3);
			System.out.println("target " + grades.get(i) + " found at position " + searcher.search(grades.get(i)));
		}

	}

	private static void testSort(Sorter<Integer> sorter) {
		init();

		System.out.println(sorter.getClass().toString());
		System.out.println(grades);
		sorter.sort(grades);
		System.out.println(grades + "\n");

	}

	private static void init() {
		grades.clear();
		grades.add(-3);
		grades.add(-3);
		grades.add(0);
		grades.add(5);
		grades.add(12);
		grades.add(15);
		grades.add(23);
		grades.add(36);
		grades.add(99);
	}
}