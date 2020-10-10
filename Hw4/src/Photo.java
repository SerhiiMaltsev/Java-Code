
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Photo implements Comparable<Photo> {

	/**
	 * Object that contains image's data
	 */
	protected BufferedImage imageData;

	/**
	 * Date when the photo was taken
	 */
	private final String dateTaken;

	/**
	 * Holds the caption of the photo
	 */
	private final String caption;

	/**
	 * Holds the filename of the photo
	 */
	private final String filename;

	/**
	 * Holds the rating of the photo
	 */
	private int rating;

	/**
	 * Constructor method of the photo class
	 *
	 * @param filename The filename of the photo
	 * @param caption  The caption of the photo
	 */
	public Photo(String filename, String caption) {
		this.caption = caption;
		this.filename = filename;
		this.rating = 1;
		this.dateTaken = "1901-01-01";
	}

	/**
	 * Loads the image's data
	 * 
	 * @param String filename is the path to the image file
	 * @return false if the load of the image data was successful and false if it
	 *         failed
	 */
	public boolean loadImageData(String filename) {
		try { // Here I am making an assumption that false should be returned in the case of
				// error
			this.imageData = ImageIO.read(new File(filename));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Getter for the image data
	 * 
	 * @return BufferedImage data of the image
	 */
	public BufferedImage getImageData() {
		return this.imageData;
	}

	/**
	 * Setter for the image data
	 * 
	 * @param BufferedImage newImageData new image data
	 */
	public void setImageData(BufferedImage newImageData) {
		this.imageData = newImageData;
	}

	/**
	 * Constructor method of the photo class
	 *
	 * @param filename  The filename of the photo
	 * @param caption   The caption of the photo
	 * @param rating    The rating of the photo (range from 1 to 5)
	 * @param dateTaken The date when the photo was taken
	 */
	public Photo(String filename, String caption, String dateTaken, int rating) {
		this.caption = caption;
		this.filename = filename;
		if (rating > 5 || rating < 1) {
			this.rating = 1;
		} else {
			this.rating = rating;
		}
		if (DateLibrary.isValidDate(dateTaken) == true) {
			this.dateTaken = dateTaken;
		} else {
			this.dateTaken = "1901-01-01";
		}
	}

	/**
	 * Getter for the caption of the photo
	 * 
	 * @return The caption of the photo
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * Getter for the date when the photo was taken
	 * 
	 * @return The date when the photo was taken
	 */
	public String getDateTaken() {
		return this.dateTaken;
	}

	/**
	 * Getter for the filename of the photo
	 * 
	 * @return The filename of the photo
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * Getter for the rating of the photo
	 * 
	 * @return The rating of the photo
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * Set the photo's rating if the value is in range [1, 5] and does not equal to
	 * the previous value
	 * 
	 * @param newRating The value of the new rating
	 * @return true if the value was changed and false if the value remains the same
	 */
	public boolean setRating(int newRating) {
		if (newRating == this.rating) {
			return false;
		} else if (newRating > 5 || newRating < 1) {
			return false;
		} else {
			this.rating = newRating;
			return true;
		}
	}

	/**
	 * Compares each parameter of two objects to determine are they equal or not
	 * 
	 * @param object The object that is compared to the initial object
	 * @return returns true if two objects are equal and returns false if two
	 *         objects are different
	 */
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object instanceof Photo) {
			Photo newObject = (Photo) object;
			if (this.caption.equals(newObject.getCaption()) && this.filename.equals(newObject.getFilename())) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	/**
	 * This method represents the information about the photo
	 * 
	 * @return the String information about the photo
	 */
	public String toString() {
		return ("Caption: " + this.caption + ", Filename: " + this.filename + ", Rating: " + this.rating);
	}

	/**
	 * Is used to generate the unique number for the photo
	 * 
	 * @return the unique number for the photo
	 */
	public int hashCode() {
		return this.filename.hashCode();
	}

	/**
	 * Main method that is used to test the created class and its methods
	 */
	public static void main(String[] args) {
		Photo dog = new Photo("dog", "mydog.jpg", "13-04-1998", 1);
		System.out.println(dog.getCaption());
		System.out.println(dog.getFilename());
		System.out.println(dog.getRating() + "\n");

		System.out.println("First test of the setRating: ");
		dog.setRating(2); // First test for the setRating

		System.out.println(dog.getRating() + "\n");
		System.out.println(dog.toString() + "\n");

		Photo cat = new Photo("cat", "fluffy.jpg", "01-20-1974", 2);

		System.out.println("First test of the equals: ");
		System.out.println(dog.equals(cat) + "\n"); // First test for the equals

		System.out.println("Second test of the setRating: ");
		cat.setRating(3); // Second test for the setRating
		System.out.println(cat.getRating() + "\n");

		System.out.println("Second test of the equals: ");
		System.out.println(cat.equals(dog));// Second test for the equals
	}

	/**
	 * compareTo method that compares by date taken first and then by caption
	 *
	 * @param Photo o1 the first photo to compare
	 * @param Photo o2 the second photo to compare
	 */
	@Override
	public int compareTo(Photo p) {
		int dateComp = this.dateTaken.compareTo(p.dateTaken);
		int captionComp = this.caption.compareTo(p.caption);
		if (dateComp != 0) {
			return dateComp;
		} else {
			return captionComp;
		}
	}
}
