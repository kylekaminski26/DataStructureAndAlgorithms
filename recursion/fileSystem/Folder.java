package recursion.fileSystem;

import list.*;

/**
 * @author Kyle Kaminski
 * @version March 2019
 */

public class Folder extends Item {
	private List<Item> items;

	public Folder(String name) {
		super(name);
		items = new ArrayList<Item>(); // Linked List.
	}

	/** Add the given Item to this Folder */
	public void addItem(Item item) {
		items.add(item);
	}

	public String toString() {
		return "Folder: " + getName();
	}

	public List<Document> getAllDocs() {
		List<Document> print = new ArrayList<Document>();
		for (int i = 0; i < items.size(); i++) {
			print.addAll(items.get(i).getAllDocs());
		}
		return print;
	}

	public void show() {
		String indent = "   ";
		System.out.println(this); // Prints root Folder.
		showHelper(indent);
	}

	protected void showHelper(String indent) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(indent + items.get(i).toString());
			items.get(i).showHelper(indent + "   ");
		}
	}
}