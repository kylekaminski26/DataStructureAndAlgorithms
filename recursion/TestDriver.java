package recursion;

public class TestDriver {
	public static void main(String args[]) {
		RecursiveMethods rec = new RecursiveMethods(); // Creates instance of class.
//		System.out.println(rec.fact(7)); // 5040
//		System.out.println(rec.fib(10)); // 55
//		System.out.println(rec.isPal("")); // true
//		System.out.println(rec.isPal("racecar")); // true
//		System.out.println(rec.isPal("abcdcbaa")); // false
//		System.out.println(rec.mult(3, 9)); // 27
//		System.out.println(rec.mod(18, 13)); // 5
		System.out.println(rec.div(20, 4)); // 5
		System.out.println(rec.div(10, 4)); // 2
		System.out.println(rec.div(11, 3)); // 3
		System.out.println(rec.div(24, 7)); // 3
	}
}