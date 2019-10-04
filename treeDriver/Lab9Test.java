package treeDriver;

import tree.*;

public class Lab9Test {
	public static void main(String args[]) {
		BinaryTree<String> peopleA = new EmptyBinarySearchTree<String>();
		peopleA = peopleA.add("mary");
		peopleA = peopleA.add("harry");
		peopleA = peopleA.add("sue");
		peopleA = peopleA.add("ralph");
		peopleA = peopleA.add("sally");
		peopleA = peopleA.add("joe");
		peopleA = peopleA.add("sue");
		peopleA = peopleA.add("irv");
		peopleA = peopleA.add("harry");
		peopleA = peopleA.add("al");

		BinaryTree<String> peopleB = new EmptyBinarySearchTree<String>();
		peopleB = peopleB.add("al");
		peopleB = peopleB.add("harry");
		peopleB = peopleB.add("harry");
		peopleB = peopleB.add("irv");
		peopleB = peopleB.add("joe");
		peopleB = peopleB.add("mary");
		peopleB = peopleB.add("ralph");
		peopleB = peopleB.add("sally");
		peopleB = peopleB.add("sue");
		peopleB = peopleB.add("sue");
	}
}
