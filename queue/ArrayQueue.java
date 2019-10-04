package queue;

import list.*;

/** A QueueADT using an ArrayList. */
public class ArrayQueue<E> implements QueueADT<E> {
	List<E> list = new ArrayList<E>();
	int size = 0; // size of this ArrayQueue itself, NOT the list.
	int front = 0;
	int back = 0;

	public E remove() {
		E result = list.get(front);
		size--;
		// Use mod auto wrap around if front equals list size.
		front = (front + 1) % list.size();
		return result;
	}

	public void add(E value) {
		if (size == list.size()) {
			list.add(back, value);
			front = (front + 1) % list.size();
		} else
			list.set(back, value);
		back = (back + 1) % list.size();
		size++;
	}

	public E peek() {
		if (list.isEmpty())
			return null;
		return list.get(front);
	}

	public int size() {
		return size;
	}

	public void clear() {
		list.clear();
		front = back = size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		if (this.isEmpty())
			return "[]";
		if (this.size() == 1)
			return "[" + this.peek() + "]";
		ArrayQueue<E> temp = this;
		String s = "[" + temp.remove();
		if (temp.front < temp.back)
			while (temp.front != temp.back)
				s += ", " + temp.remove();
		else
			while (temp.front != temp.back) {
				s += ", " + temp.peek();
				front = (front + 1) % temp.size();
			}
		return s + "]";
	}
}