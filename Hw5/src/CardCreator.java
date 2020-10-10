import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 5 Card Creator
 * 
 * This class defines the thread task that will "come up with" and submit
 * greeting card ideas to the print queue. We have added the code necessary to
 * read from the file, but it's up to you to handle turning off the printer
 * (keeping track of how many threads are open) and adding the read-in line from
 * the inspiration file to the queue.
 * 
 * @author Serhii Maltsev ( sm5zj )
 *
 */
public class CardCreator implements Runnable {

	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;

	/**
	 * Inspiration file name
	 */
	private String filename;

	/**
	 * CardCreator constructor
	 */
	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		Scanner s = null;
		try {
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				String next = s.nextLine(); // Read the next line from the inspiration file
				printQueue.enqueue(next); // Enqueue the line into the print queue
				Thread.sleep(1000); // Have the thread sleep for 1 second (1000) (don't used a number < 1000)
			}

		} catch (IOException e) {
			System.out.println("Could not read file");
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
			if (java.lang.Thread.activeCount() < 5) { // Source:
				// https://www.tutorialspoint.com/java/lang/thread_activecount.htm
				printQueue.turnOff(); // Turns off printQueue when # of threads < 5
			}
		}
	}
}
