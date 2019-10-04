package list;

/**
 * @author Kyle Kaminski
 * @version Feb 2019
 */

/** An implementation of List, using an array */
public class ArrayList<E> implements List<E> {
	int size = 0;
	E[] values; // initially stores a null reference.

	/** Constructor with default size. */
	public ArrayList() {
		this(10); // Default size when creating new ArrayList.
	}

	/** Constructor where client specified size. */
	public ArrayList(int cap) {
		values = (E[]) new Object[cap]; // Takes whatever the object type of the values are and casts it into an ArrayList of that type.
	}

	public ArrayList(List<E> list) { // copy constructor
		this(list.size() + 10);
		addAll(list);
	}

	/** @return the value at the specified index. */
	public E get(int ndx) {
		return values[ndx];
	}

	/** @return what was initially at the index before setting a new value. */
	public E set(int ndx, E value) {
		E result = values[ndx]; // Saves a copy to be returned.
		values[ndx] = value;
		return result;
	}

	/** Adds the specified object to the end of the ArrayList. */
	public void add(E value) {
		add(size, value);
	}

	/** Adds the specified object to the specified index.
	 * Shifts all other values to the right. */
	public void add(int ndx, E value) { 
		if (size == values.length)
			alloc(); // Increases size of array.
		for (int i = size; i > ndx; i--)
			values[i] = values[i - 1];
		values[ndx] = value;
		size++;
	}

	/** Creates a new array of greater size, and copies values of previous array to this. */
	private void alloc() {
		E[] temp = (E[]) new Object[values.length * 2];
		for (int i = 0; i < size; i++)
			temp[i] = values[i];
		values = temp;
	}

	/** @return the item that was removed from the List. */
	public E remove(int ndx) {
		E result = values[ndx];
		for (int i = ndx; i < size - 1; i++)
			values[i] = values[i + 1];
		size--;
		return result;
	}

	/** @return the size of this List. */
	public int size() {
		return size;
	}

	/** Clear this List. */
	public void clear() {
		for (int i = 0; i < size; i++)
			values[i] = null;
		size = 0;
	}

	/** @return true iff this List is empty. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** @return the index of the last occurence of obj in this ArrayList, or -1 if not found. */
	public int indexOfLast(Object obj) {
		for (int i = size - 1; i >= 0; i--) {
			if (get(i).equals(obj))
				return i; // Return found index (List scanned from back to front).
		}
		return -1;
	}

	/** @return true if this ArrayList contains the given Object. */
	public boolean contains(Object obj) {
		if (indexOf(obj) > -1)
			return true;
		return false;
	}

	/** @return a new ArrayIterator for this ArrayList. */
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}

	/** @return true iff the given Object is of type List, if the sizes are equal, AND if the values are equal. */
	public boolean equals(Object obj) {
		if (obj instanceof List<?>) { // (1) If the parameter is a type List.
			List<E> list = (List<E>) obj;
			if (list.size() == this.size) { // (2) If the size of this and the parameter are the same.
				ListIterator<E> itThis = this.listIterator();
				ListIterator<E> it = list.listIterator();
				while (it.hasNext())
					if (!itThis.next().equals(it.next())) // (3) If value of this is not equal to value of parameter.
						return false;
				return true;
			} // end inner if.
		} // end outer if.
		return false; // If (1), (2), or (3) were false.
	}

	/** @return new ArrayListIterator for this ArrayList. */
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E>(this);
	}

	/** @return new ArrayListIterator for this ArrayList, with specified start index. */
	public ListIterator<E> listIterator(int start) {
		return new ArrayListIterator<E>(this, start);
	}

	/** @return true iff this ArrayList is a Palindrome (front -> center = center -> back, reversed). */
	public boolean isPalindrome() {
		for (int i = 0; i < size / 2; i++)
			if (!(get(i).equals(get(size - i - 1))))
				return false; // If at any point the values are not equal.
		return true;
	}

	/** @return a toString of this ArrayList. */
	public String toString() {
		if (isEmpty())
			return "[]";
		String string = "[" + get(0);
		for (int i = 1; i < size; i++)
			string += (", " + get(i));
		return string + "]";
	}

	/** Not yet tested. */
	/** @return the removed Object from this ArrayList, if found. */
	public boolean remove(Object obj) {
		Iterator<E> it = iterator();
		while (it.hasNext()) {
			if (it.next().equals(obj)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	/** @return the index of the Object in this ArrayList. */
	public int indexOf(Object obj) {
		return ndx(0, obj);
	}

	private int ndx(int start, Object obj) {
		if (start == size) // May also be start >= size
			return -1;
		if (get(start).equals(obj))
			return start;
		return ndx(start + 1, obj);
	}

	/** All all of the elements from the specified List into this ArrayList. */
	public void addAll(List<E> other) {
		Iterator<E> itty = other.iterator();
		while (itty.hasNext())
			add(itty.next());
	}
}