package recursion.fileSystem;

import list.*;

/**
 * @author Kyle Kaminski
 * @version March 2019
 */
public abstract class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/** @return A list of all the documents making up this Item (and all contained
	 * folders) in any order. */
	public abstract List<Document> getAllDocs();

	/** Display the name of this Item; also display all the items which it contains,
	 * on separate lines. */
	public abstract void show();

	protected abstract void showHelper(String indent);
}