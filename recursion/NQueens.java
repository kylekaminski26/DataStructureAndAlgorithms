package recursion;

/** Solve the NQueens problem. */
public class NQueens {
	public static final int SIZE = 8;

	public static void main(String[] args) {
		NQueens game = new NQueens();
		System.out.println(game.placeQueens(0, new Board()));
	}

	/** Pre: Queens have been safely placed on the given Board in columns 0 -> n-1.
	 * @return a Board on which Queens have been placed in all columns, or null if not possible. */
	public Board placeQueens(int col, Board b) {
		Position p;
		Board result;
		// Base case
		if (col == SIZE)
			return b;
		for (int row = 0; row < SIZE; row++) {
			p = new Position(row, col);
			result = new Board(b);
			result.addQueen(p);
			if (result.ok()) {
				result = placeQueens(col + 1, result);
				if (result != null)
					return result;
			}
		} // end loop
		return null; // no Solution can be found
	}
}