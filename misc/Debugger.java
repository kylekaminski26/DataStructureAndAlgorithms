/*
 * @author Kyle Kaminski
 * @version January 2019
 */

package misc;

public class Debugger {
	public static void main(String args[]) {
		System.out.println("Starting");

		for (int i = 30; i < 200; i++) {
			method(i);
			System.out.println(i);
		}
		System.out.println("Finished");
	}

	private static void method(int parm) {
		double x = parm;
		while (x > 0.0)
			x = x / 2;
	}
}