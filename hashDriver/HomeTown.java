package hashDriver;

/**
 * Hometown class for Lab 11.
 * 
 * @author Kyle Kaminski
 * @version April 2019
 */
public class HomeTown {
	String name;
	String state;
	String zipCode;

	public HomeTown(String name, String state, String zip) {
		this.name = name;
		this.state = state;
		this.zipCode = zip;
	}

	public boolean equals(HomeTown h) { // Zipcodes must be equal
		if (zipCode.equals(h.zipCode))
			return true;
		return false;
	}

	public String toString() {
		return name + ", " + state + " " + zipCode;
	}
}