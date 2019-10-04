package BigO;

import list.*;

public class TestDriver {
	public static void main(String args[]) {
		BigOMethods Oh = new BigOMethods();
		
		long startArr = System.currentTimeMillis();
		List<Integer> Arr = new ArrayList<Integer>();
		for (int i = 0; i < 100000; i++)
			Arr.add(i);
		
		long startLin = System.currentTimeMillis();
		List<Integer> Lin = new LinkedList<Integer>();
		for (int i = 0; i < 100000; i++)
			Lin.add(i);
		
		Oh.m(Arr); // Should be done very quickly. O(n)
		long stopArr = System.currentTimeMillis();
		long timeArr = stopArr - startArr;
		
		Oh.m(Lin); // Should take much longer. O(n^2)
		long stopLin = System.currentTimeMillis();
		long timeLin = stopLin - startLin;
		
		long startM = System.currentTimeMillis();
		int a = 7;
		Oh.m(a);
		long stopM = System.currentTimeMillis();
		long timeM = stopM - startM;
		
		System.out.println("Time to run ArrayList O(n): " + timeArr + " milliseconds.");
		System.out.println("Time to run LinkedList O(n^2): " + timeLin + " milliseconds.");
		System.out.println("Time to run m() method O(n): " + timeM + " milliseconds.");
		
	}
}