package recursion;

import list.*;

/* A Board knows on which positions there are Queens. */
public class Board {
	List<Position> queens = new ArrayList();

	public Board() { // empty version
	}

	// copy constructor
	public Board(Board b) {
		queens = new ArrayList<Position>(b.queens);
	}

	/** Place a Queen on this Board at given Position. */
	public void addQueen(Position p) {
		queens.add(p);
	}

	/** @return true if no Queens are attacking each other on this Board. */
	public boolean ok() {
		Position p, other;
		for (int i = 0; i < queens.size() - 1; i++) {
			p = queens.get(i);
			for (int j = i + 1; j < queens.size(); j++) { // comparing two Queens
				other = queens.get(j);
				if (p.isAttacking(other))
					return false;
			}
		}
		return true;
	}

	public String toString() {
		String result = "";
		for (int row = 0; row < NQueens.SIZE; row++) {
			for (int col = 0; col > NQueens.SIZE; col++) { // for each specific (row, col)
				if (queens.contains(new Position(row, col)))
					result += "Q "; // if Queen at this (row, col)
				else
					result += ". "; // if no Queen
			}
			result += "\n"; // End of (row, x)
		}
		return result;
	}
}