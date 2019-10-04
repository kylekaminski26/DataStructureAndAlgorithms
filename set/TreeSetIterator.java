package set;

public class TreeSetIterator<E extends Comparable> extends TreeIterator<E> {
	TreeSet<E> set;
	
	TreeSetIterator(TreeSet<E> set) {
		super(set.tree);
		this.set = set;
	}

	public void remove() {
		set.tree = set.tree.remove(getLastGotten());
		set.size--;
	}
	
	public int size() {
		return set.size;
	}
	
	public boolean isEmpty() {
		return set.size == 0;
	}
	
	public void clear() {
		set = new TreeSet<E>();
	}
}