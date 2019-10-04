package queue;

import list.*;

/** A QueueADT, using a LinkedList. */
public class Queue<E> implements QueueADT<E> {
	List<E> list = new LinkedList<E>();

	public void add(E value) {
		list.add(value);
	}

	public E remove() {
		return list.remove(0);
	}

	public E peek() {
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public int size() {
		return list.size();
	}

	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public String toString() {
		return list.toString();
	}
}