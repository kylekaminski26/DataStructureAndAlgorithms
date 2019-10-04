package tree;

import list.Iterator;
import queue.QueueADT;
import queue.Queue;

/** An Iterator for BSTs, using an inorder traversal. */
class TreeIterator<E> implements Iterator<E> {
	BinaryTree<E> tree;
	QueueADT<E> queue = new Queue<E>();
	E lastGotten; // Last value obtained by a call to next().

	TreeIterator(BinaryTree<E> tree) {
		this.tree = tree;
		buildQ(tree);
	}

	// Add all values in the given BT to a queue, using an inorder traversal of the BT.
	private void buildQ(BinaryTree<E> tree) {
		if (!tree.getLeft().isEmpty())
			buildQ(tree.getLeft());
		queue.add(tree.getValue());
		if (!tree.getRight().isEmpty())
			buildQ(tree.getRight());
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public E next() {
		lastGotten = queue.remove();
		return lastGotten;
	}

	/** Pre: The elements are unique. Pre: The size of the tree > 1. */
	public void remove() {
		if (!tree.getLeft().isEmpty() && !tree.getRight().isEmpty() || !tree.getValue().equals(lastGotten)) { // 2 children or removing root?
			tree = tree.remove(lastGotten);
			return;
		}
		E repl;
		if (tree.getLeft().isEmpty())
			repl = getSuccessorValue();
		else
			repl = getPredecessorValue();
		tree.remove(repl);
		tree.setValue(repl);
	}

	private E getSuccessorValue() {
		BinaryTree<E> temp = tree.getRight();
		while (!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		return temp.getValue();
	}

	/** Not yet tested. */
	private E getPredecessorValue() {
		BinaryTree<E> temp = tree.getLeft();
		while (!temp.getRight().isEmpty())
			temp = temp.getRight();
		return temp.getValue();
	}

	@Override
	public boolean has2more() {
		// TODO Auto-generated method stub
		return false;
	}
}