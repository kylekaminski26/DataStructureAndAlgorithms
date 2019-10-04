package treeDriver;

import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

public class Final3 {
	public static void main(String[] args) {
		BinaryTree<String> kids = new EmptyBinarySearchTree<String>();

		kids = kids.add("kimmy");
		kids = kids.add("jimmy");
		kids = kids.add("susie");
		kids = kids.add("joe");
		kids = kids.add("jo");
		
		System.out.println(kids.height());
	}
}
