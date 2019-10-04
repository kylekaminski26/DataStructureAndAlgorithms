package recursion.fileSystem;

import list.ArrayList;
import list.List;

/**
 * @author Kyle Kaminski
 * @version March 2019
 */
public class Document extends Item {
	private DocType type;

	public Document(String name, DocType type) {
		super(name);
		this.type = type;
	}

	public DocType getDocType() {
		return type;
	}

	public List<Document> getAllDocs() {
		List<Document> print = new ArrayList<Document>();
		print.add(this);
		return print;
	}

	public void show() {
	}

	public String toString() {
		return getName() + " (" + type + ")";
	}

	protected void showHelper(String indent) {
	}
}