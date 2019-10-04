package listDriver;

import list.*;

/**
 * Solution
 * 
 * @author Kyle Kaminski
 * @version Feb 2019
 */
public class LabStudentIterator {

	static List<Student> roster;

	public static void main(String args[]) {
		roster = new ArrayList<Student>();
		System.out.println("Working with an ArrayList");
		test();
		System.out.println();
		System.out.println("Working with a LinkedList");
		roster = new LinkedList<Student>();
		test();
		System.out.println();
	}

	private static void init() {
		deleteFirstDup(roster);
		roster.add(new Student("jim", 2222));
		deleteFirstDup(roster);
		roster.add(new Student("joseph", 2345));
		roster.add(new Student("joe", 2345));
		roster.add(new Student("mary", 3333));
		roster.add(new Student("maryLou", 3333));
		System.out.println("Before deletions " + roster);
	}

	private static void test() {
		init();
		deleteFirstDup(roster);
		if (roster.size() != 4)
			System.err.println("Deletion is incorrect");
		System.out.println("Roster is " + roster);
	}

	/**
	 * Search the roster for the first pair of neighbors which are equal. Delete
	 * either member of that pair.
	 * @author Kyle Kaminski
	 */
	private static void deleteFirstDup(List<Student> list) {
		if (list.size() > 1) { // We need at least 2 elements before we can compare anything.
			ListIterator<Student> it = list.listIterator();
			while (it.hasNext()) { // While there are elements to iterate through.
				if (it.hasPrevious()) {
					if (it.next().getID() == it.previous().getID()) {
						it.remove();
						return;
					}
				}
				it.next(); // Move cursor to the right.
			}
		}
	}
}