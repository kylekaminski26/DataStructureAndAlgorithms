package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * @author Kyle Kaminski
 * @version Feb 2019
 */
public class Doc implements Comparable {
	private int size; // size of this Doc, in blocks

	/** Constructor for objects of class Printer. */
	public Doc(int size) {
		this.size = size;
	}

	public int size() {
		return size;
	}

	public String toString() {
		return "Document of size " + size;
	}

	public int compareTo(Object obj) { // Fix me
		if (!(obj instanceof Doc))
			return 0;
		Doc temp = (Doc) obj;
		if (this.size > temp.size)
			return -1;
		if (this.size == temp.size)
			return 0;
		return 1;
	}
}