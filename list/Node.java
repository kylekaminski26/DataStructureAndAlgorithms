/*
 * @author Kyle Kaminski
 * @version January 2019
 */

package list;

/* Used by LinkedList to store a value and a link to next Node. */
class Node<E> {
	E value;
	Node<E> next;
	Node<E> prev;

	/* Constructor. */
	Node(E value, Node<E> next, Node <E> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}