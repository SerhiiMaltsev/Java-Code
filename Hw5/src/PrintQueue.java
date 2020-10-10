import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 5 PrintQueue
 * 
 * Implement the class below as specified in the homework 5 document.
 * 
 * @author Serhii Maltsev ( sm5zj )
 *
 */

public class PrintQueue {

	private LinkedList<String> toPrint; // the printer's list of documents
	private Lock documentChangeLock; // a ReentrantLock lock
	private Condition hasPrintTask; // a condition object
	private boolean isOn; // boolean variable describing if the queue is on (accepting jobs)
	static int numberOfCardsPrinted; // int variable that counts the number of printed cards

	/**
	 * Constructor
	 */
	public PrintQueue() {
		numberOfCardsPrinted = 0;
		toPrint = new LinkedList<String>(); // create the list of documents
		isOn = true; // turn on the print queue
		documentChangeLock = new ReentrantLock(); // create the lock
		hasPrintTask = documentChangeLock.newCondition(); // create the wait condition
	}

	/**
	 * dequeue is used to delete the elements from the queue of cards that should be
	 * printed it only dequeues the element if it exists and wait if it does not
	 * exist
	 */
	public String dequeue() {
		// This seems dangerous! Something needs to change here...!
		// Hint: Only remove an item from the queue if it's not empty,
		// and do not dequeue if the queue is empty, but wait if the queue is on.
		// Implement this method
		// return the first document
		documentChangeLock.lock();
		try {
			while ((toPrint.isEmpty() == true) && (isOn == true)) {
				if (numberOfCardsPrinted >= 20) { // If all cards are printed it does not wait to dequeue
					return null;
				}
				hasPrintTask.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			documentChangeLock.unlock();
		}
		return toPrint.remove();
	}

	/**
	 * enqueue is used to remove the element from the queue after it was printed on
	 * the card it signals to the other threads that element can be removed after it
	 * was added
	 */
	public void enqueue(String s) {
		documentChangeLock.lock();
		try {
			// This seems dangerous! Something needs to change here...!
			// Implement this method
			toPrint.add(s); // add to the list of documents
			numberOfCardsPrinted++;
			hasPrintTask.signalAll(); // after the element was added, signals that it can be removed
		} finally {
			documentChangeLock.unlock();
		}
	}

	/**
	 * turnOff is used to turn of the queue when all elements are printed
	 */
	public void turnOff() {
		isOn = false;
		// !Implement this method

	}

	/**
	 * isOn returns true if the queue if on and returns false if the queue is off
	 */
	public boolean isOn() {
		if (isOn == true) {
			return true;
		} else {
			return false;
		}
	}

}
