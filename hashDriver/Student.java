package hashDriver;

/**
 * Student class for Lab 11.
 * @author Kyle Kaminski
 * @version April 2019
 */
public class Student {
	String name;
	String idNumber;
	int credits;
	HomeTown homeTown;

	public Student(String name, String id, int cred, HomeTown home) {
		this.name = name;
		this.idNumber = id;
		this.credits = cred;
		this.homeTown = home;
	}

	public boolean equals(Object obj) { // Name, credits, hometown must be equal
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (name.equals(s.name) && credits == s.credits && homeTown.equals(s.homeTown))
				return true;
		}
		return false;
	}
	
	public int getCredits() {
		return credits;
	}

	public String toString() {
		return name + "(" + idNumber + ") " + credits + " cr " + homeTown;
	}

	public int hashCode() {
		return name.hashCode();
		// Compare name, credits, and hometown. Not just name.
	}
}