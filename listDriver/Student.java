package listDriver;

public class Student {
	String name;
	int ID;

	Student(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return ("{" + getName() + "," + getID() + "}");
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		Student s = (Student) obj;
		return this.ID == s.ID;
	}
}