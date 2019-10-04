package list;

/**
 * A List using references.
 * @author Kyle Kaminski
 * @version January 2019
 */
public class LinkedList<E> implements List<E> {
	int size = 0;
	Node<E> head = new Node<E>(null, null, null); // null value and null reference.
	Node<E> tail = new Node<E>(null, null, head); // null value and previous reference to head.
	private Node<E> ref = new Node<E> (null, null, null);
	
	/** Create a new LinkedList. */
	public LinkedList() {
		head.next = tail;
	}
	
	/** Add a new value to the end of this LinkedList. */
	public void add(E value) { 
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}
	
	/** Add a new value to the specified index of this LinkedList. */
	public void add(int ndx, E value) {
		setRef(ndx);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		size++;
	}

	/** @return the value at the specified index. */
	public E get(int ndx) {
		setRef(ndx);
		return ref.value;
	}
	
	/** Sets the reference Node's position with the specified index. */
    private void setRef(int ndx) {
		if (size / 2 > ndx) {
			ref = head.next;
			for (int i = 0; i < ndx; i++)
				ref = ref.next;
		}
		else {
			ref = tail.prev;
			for (int i = size - 1; i > ndx; i--)
				ref = ref.prev;
		}
	}

    /** Sets the specified index with the specified value.
     * @return the value of the index before being set. */
	public E set(int ndx, E value) {
		setRef(ndx);
		E result = ref.value; // Stores value before being set.
		ref.value = value;
		return result;
	}

	/** Remove the Object at the specified index.
	 * @return the removed Object. */
	public E remove(int ndx) {
		setRef(ndx);
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return ref.value;
	}

	/** @return the size of this LinkedList. */
	public int size() {
		return size;
	}

	/** Clear this LinkedList. */
	public void clear() {
		head = new Node<E>(null, tail, null);
		tail = new Node<E>(null, null, head);
		size = 0;
	}

	/** @return true iff this LinkedList is empty. */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** @return the index of the last position that holds this specified Object. */
	public int indexOfLast(Object obj) {
		ref = tail.prev;
		int i = size - 1;
		while (ref != head) {
			if (ref.value.equals(obj))
				return i;
			i--;
		}
		return -1;
	}

	/** @return true iff this LinkedList contains the specified Object. */
	public boolean contains(Object obj) {
		if(indexOf(obj) > -1)
			return true;
		return false;
	}
	
	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}
	
	public ListIterator<E> listIterator() {
		return new RefListIterator<E>(this);
	}
	
	// With specified start index.
	public ListIterator<E> listIterator(int start) {
		return new RefListIterator<E>(this, start);
	}
	
	/** @return true iff the given Object is of type List, if the sizes are equal, AND if the values are equal. */
	public boolean equals(Object obj) {
		if (obj instanceof List<?>) { // (1) If the parameter is a type List.
			List<E> list = (List<E>) obj;
			if (list.size() == this.size) { // (2) If the size of this and the parameter are the same.
				ListIterator<E> itThis = this.listIterator();
				ListIterator<E> it = list.listIterator();
				while (it.hasNext()) {
						if (!itThis.next().equals(it.next())) // (3) If value of this is not equal.
							return false;
				}
				return true;
			}
		}
		return false; // If (1), (2), or (3) were false.
	}
	
	/** @return a toString of this LinkedList. */
	public String toString() {
		if(isEmpty())
			return "[]";
		String string = "" + get(0);
		for(int i = 1; i < size; i++)
			string += ", " + get(i);
		return "[" + string + "]";
	}
	
	/** @return true iff this LinkedList is a Palindrome (front -> center = center -> back, reversed.). */
	public boolean isPalindrome() {
		Node<E> start = head.next;
		Node<E> end = tail.prev;
		for (int i = 0; i < size / 2; i++) {
			if (!(start.value.equals(end.value)))
				return false;
			// If they are equal,
			start = start.next;
			end = end.prev;
			// Eventually these nodes will meet at midpoint. That is when for loop ends.
		}
		return true; // If start node always equaled end node.
	}

	/** Removes the specified Object.
	 * @return true iff Object was removed. */
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
	
	/** @return the index of the specified Object. */
	public int indexOf(Object obj) {
		Node<E> ref = head;
		for (int i = 0; i < size; i++) {
			ref = ref.next;
			if (ref.value.equals(obj))
				return i;
		}
		return -1;
	}
	
	private int ndx(int start, Object obj) {
		if (start == size)
			return -1;
		if (ref.value.equals(obj))
			return start;
		ref = ref.next;
		return ndx(start + 1, obj);
	}

	/** All all of the elements from the specified List into this LinkedList. */
	public void addAll(List<E> list) {
		Iterator<E> itty = list.iterator();
		while (itty.hasNext())
			add(itty.next());
	}
}