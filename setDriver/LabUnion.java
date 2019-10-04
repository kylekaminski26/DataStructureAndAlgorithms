package setDriver;

import set.*;

/**
 * Test the Sets
 *
 * @author Kyle Kaminski
 * @version (Apr 2019)
 */
public class LabUnion {
	public static void main(String[] args) { // Test HashSet
		Set<String> friends = new HashSet<String>();
		friends.add("mary");
		friends.add("joe");
		friends.add("jim");
		friends.add("jill");

		Set<String> others = new TreeSet<String>();
		others.add("jack");
		others.add("joe");
		others.add("jim");
		others.add("suzie");

		System.out.println("friends: " + friends);
		System.out.println("others: " + others);
		System.out.println();
		System.out.println("Testing  Intersection");
		System.out.println("union: " + friends.intersection(others));
		System.out.println();

		System.out.println("friends: " + friends);
		System.out.println("others: " + others);
		System.out.println();
	}
}