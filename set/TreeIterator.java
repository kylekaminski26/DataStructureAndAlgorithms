package set;

import tree.BinaryTree;

public class TreeIterator<E> {
	BinaryTree<E> tree;
	E lastGotten;

	public TreeIterator(BinaryTree<E> tree) {
		this.tree = tree;
	}
	
	public E getLastGotten() {
		return lastGotten;
	}
}