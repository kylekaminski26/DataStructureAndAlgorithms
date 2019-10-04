/* 
 * @author: Kyle Kaminski
 * @version: January 2019
 */

package list;

public interface List<E> {
	/** @return value at given ndx.
	 * @param 0 <= ndx < size */
	E get(int index);

	/** Change the value at given ndx to given value.
	 * @param 0 <= ndx < size */
	E set(int ndx, E value);

	/** Add the given value at end. */
	void add(E value);

	/** Insert given value at given ndx in this List.
	 * @param 0 <= ndx <= size */
	void add(int ndx, E value);

	/** Remove the value at given ndx from this List.
	 * @param 0 <= ndx < size */
	E remove(int ndx);
	
	/** Remove the first occurence of the given object from the List, if possible.
	 * @return true iff it was removed. */
	boolean remove(Object obj);

	/** @return the size of this List. */
	int size();

	/** Clear this List. */
	void clear();

	/** @return true iff this List is empty. */
	boolean isEmpty();

	/** @return the position of the first occurrence of the given 
	 * Object in this List, or -1 if it is not in this List. */
	int indexOf(Object obj);
	
	/** @return the index of the last occurence of obj
	 * in this ArrayList, or -1 if not found.
	 */
	int indexOfLast(Object obj);

	/** @return true only if the given Object is in this List. */
	boolean contains(Object obj);
	
	Iterator<E> iterator();
	
	/** return true only if the parameter obj is a List and contains the same elements (in the same sequence) as this List. */
	boolean equals(Object obj);
	
	ListIterator<E> listIterator();
	
	ListIterator<E> listIterator(int start);
	
	/** @return this List as a String */
	public String toString();
	
	public void addAll(List<E> list);
}