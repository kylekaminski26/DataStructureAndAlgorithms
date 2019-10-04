package tree;

import list.Iterator;

/** A Binary Tree (BT) may have a value, 2 children. */
public interface BinaryTree<E> {
	
	/** @return value of this BT. */
	E getValue();
	
	/** Search the family of this BT for a value.
	 * @return that value, or null if not found. */
	E get(E value);
	
	/** @return true iff the given obj is in the family of this BT. */
	boolean containsKey(Object obj);
	
	/** Add the given value to the family of this BT.
	 * @return the resulting BT. */
	BinaryTree<E> add(E value);
	
	/** Remove the given value from the family of this BT, if possible.
	 * @return the resulting BT. */
	BinaryTree<E> remove(Object obj);
	
	/** @return the left child. */
	BinaryTree<E> getLeft();
	
	/** @return the right child. */
	BinaryTree<E> getRight();
	
	/** Mutate the left child. */
	void setLeft(BinaryTree<E> child);
	
	/** Mutate the right child. */
	void setRight(BinaryTree<E> child);
	
	/** Mutate the value. */
	void setValue(E value);

	/** @return true only if this BinaryTree is empty */
	boolean isEmpty();
	
	/** @return an Inorder Iterator for this BT. */
	Iterator<E> iterator();
	
	String toString();
	
	/** @return the height of the family of this Binary Tree */
	int height();
}