package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to
 * be printed.
 * @author Kyle Kaminski
 * @version Feb 2019
 */
public class Printer implements Comparable {
	private int speed; // speed of this printer, blocks per step
	private QueueADT<Doc> docs; // Queue of documents waiting to be printed
	private String id; // name of this Printer
	private int sizeTemp;
	private Doc currDoc;

	/** Constructor. */
	public Printer(int speed, String id) {
		this.speed = speed;
		docs = new PriorityQueue<Doc>();
		this.id = id;
	}

	/** Add a document to this printer's queue Display the document and printer on
	 * stdout. */
	public void add(Doc doc) {
		docs.add(doc);
		System.out.println(doc + " added to " + this);
	}

	/** Print several blocks, if necessary, determined by this printer's speed.
	 * Display a completion message, if necessary. */
	public void print() {
			if (!docs.isEmpty()) {
				if (sizeTemp <= 0)
					addToQueue();
				sizeTemp -= speed;
				if (sizeTemp <= 0)
					System.out.println(this.id + " finished printing Document of size " + currDoc.size());
			}
	}

	private void addToQueue() {
		currDoc = docs.remove();
		sizeTemp = currDoc.size();
	}

	/** @return the number of documents in this Printer's queue */
	public int size() {
		return docs.size();
	}

	public String toString() {
		return id + ", speed: " + speed + ", docs in queue: " + size();
	}

	public int compareTo(Object obj) {
		if (!(obj instanceof Printer))
			return 0;
		return -1;
	}
}