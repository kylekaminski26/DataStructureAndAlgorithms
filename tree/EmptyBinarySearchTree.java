package tree;

import list.Iterator;

/** A BT which is Empty. */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	public E getValue() {
		return null;
	}

	public E get(E value) {
		return null;
	}

	public boolean containsKey(Object obj) {
		return false;
	}

	public BinaryTree<E> add(E value) {
		return new BinarySearchTree<E>(value);
	}

	public BinaryTree<E> remove(Object obj) {
		return this;
	}

	public BinaryTree<E> getLeft() {
		return null;
	}

	public BinaryTree<E> getRight() {
		return null;
	}

	public void setLeft(BinaryTree<E> child) {
	}

	public void setRight(BinaryTree<E> child) {
	}

	public void setValue(E value) {
	}

	public boolean isEmpty() {
		return true;
	}

	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}
	
	public String toString() {
		return "";
	}

	public int height() {
		return 1;
	}
}