package tree;

import list.List;
import list.ArrayList;
import list.Iterator;

/** A BT which satisfies properties of a BST. */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {
	E value;
	BinaryTree<E> left = new EmptyBinarySearchTree<E>();
	BinaryTree<E> right = new EmptyBinarySearchTree<E>();
	
	public BinarySearchTree(E value) {
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	public E get(E value) {
		int cmp = this.value.compareTo(value);
		if (cmp == 0)
			return this.value;
		if (cmp < 0)
			return this.right.get(value); // returns null if right is an EBST.
		return this.left.get(value); // returns null if left is an EBST.
	}

	public boolean containsKey(Object obj) { // O(log n), Double the size of the tree => 1 more comparison
		int cmp = this.value.compareTo(obj); // E value?
		if (cmp == 0)
			return true;
		if (cmp < 0)
			return right.containsKey(obj);
		return left.containsKey(obj);
	}

	public BinaryTree<E> add(E value) {
		int cmp = this.value.compareTo(value);
		if (cmp < 0)
			right = right.add(value);
		if (cmp > 0)
			left = left.add(value);
		return this;
	}
	
	public BinaryTree<E> remove(Object obj) {
		int cmp = this.value.compareTo(obj);
		if (cmp < 0)
			right = right.remove(obj);
		else if (cmp > 0)
			left = left.remove(obj);
		else { // found the obj == value
			List<BinaryTree<E>> kids = children();
			if (kids.size() == 0) // no children
				return new EmptyBinarySearchTree<E>();
			if (kids.size() == 1) // one child
				return kids.get(0);
			//Two children
			BinaryTree<E> successor = getSuccessor();
			remove(successor.getValue());
			setValue(successor.getValue());
		}
		return this;
	}
	
	private List<BinaryTree<E>> children() {
		List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>(); 
		//  List can only be a max size of 2. Type does not matter.
		if (!left.isEmpty())
			result.add(left);
		if (!right.isEmpty())
			result.add(right);
		return result;
	}

	private BinaryTree<E> getSuccessor() {
		BinaryTree<E> result = right;
		while (!result.getLeft().isEmpty())
			result = result.getLeft();
		return result;
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	public BinaryTree<E> getRight() {
		return right;
	}

	public void setLeft(BinaryTree<E> child) {
		left = child;
	}

	public void setRight(BinaryTree<E> child) {
		right = child;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return false;
	}

	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}
	
	public String toString() { // Prints in inorder (least to greatest) fashion
		return left.toString() + " " + value.toString() + " " + right.toString();
	}

	public int height() { // Worst case Big O runtime: O(log(n))
		int height = 0;
		if (getLeft() != null) {
			height++;
			getLeft(); // Step into left child // Recursive case.
		}
		if (getRight() != null) {
			height++;
			getRight(); // Step into right child. // Recursive case.
		}
		if (getRight() == null && getLeft() == null)
			height = 1; // if EBST. Base case.
		return height + 1; // Recursive call. Returns height plus 1 (for parent)
	}
}