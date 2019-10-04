package recursion;

/** A Position has a row number and a column number.
 * @author Kyle Kaminski
 * @version 2019
 */
public class Position {
	int row, col;

	public Position(int r, int c) {
		row = r;
		col = c;
	}

	/** @return true iff a Queen on this Position is attacking a Queen on other Position. */
	public boolean isAttacking(Position other) {
		if (this.row == other.row)
			return true;
		if (this.col == other.col)
			return true;
		// for increasing diagonal (bottom left -> top right)
		if (this.row + this.col == other.row + other.col)
			return true;
		// for decreasing diagonal (top left -> bottom right)
		if (this.row - this.col == other.row - other.col)
			return true;
		return false;
	}

	/** @return true if obj is a Position and this Position has the same row and column as the other Position. */
	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		return this.row == other.row && this.col == other.col;
	}
}