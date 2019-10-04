package tree;

import list.Iterator;

/** An iterator for EBSTs. */
public class EmptyIterator<E> implements Iterator<E> {

	public boolean hasNext() {
		return false;
	}

	public E next() {
		return null;
	}

	public void remove() {
	}

	@Override
	public boolean has2more() {
		// TODO Auto-generated method stub
		return false;
	}
}