package stack;

import list.*;

/**
 * An implementation of StackADT using a List. Top of stack is at end of the
 * List.
 */
public class Stack<E> implements StackADT<E> {
	List<E> list = new LinkedList<E>();

	public Stack() {
	}

	public Stack(boolean arrayBased) {
		if (arrayBased)
			list = new ArrayList<E>();
	}

	public E push(E value) {
		list.add(value);
		return value;
	}

	public E pop() {
		return list.remove(list.size() - 1);
	}

	public E peek() {
		return list.get(list.size() - 1);
	}

	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public String toString() {
		Stack<E> temp = this;
		if (this.isEmpty()) {
			return "[]";
		} else if (this.size() == 1)
			return "[" + temp.pop() + "]";
		else {
			String string = "";
			while (temp.size() > 0) {
				string += temp.pop() + ", ";
			}
			string += temp.pop();
			return "[" + string + "]";
		}
	}
}