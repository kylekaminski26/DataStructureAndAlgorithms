package graph;

/**
 * Airport available to the Airline Airport has a name
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class Airport implements Comparable {

	String name;
	boolean visited; // true, iff airport has already been visited when searching for a path
	boolean hub;

	public Airport(String n, boolean v, boolean h) {
		name = n;
		visited = v;
		hub = h;
	}

	public Airport(String name) {
		this(name, false, false);
	}

	public void setHub(boolean b) {
		this.hub = b;
	}

	public String toString() {
		if (this.hub)
			return "(" + name + ")";
		return name;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		return name.equals(other.name);
	}

	public int compareTo(Object obj) {
		if (!(obj instanceof Airport))
			return 0;
		Airport temp = (Airport) obj;
		if (this.hub)
			return 5;
		if (temp.hub)
			return -2;
		return 0;
	}
}