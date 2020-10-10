
/**
 * Homework 2
 * Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 */

import java.util.HashSet;

public class Album {

	/**
	 * Name of the album
	 */
	private String name;

	/**
	 * Set of photos
	 */
	private HashSet<Photo> photos;

	/**
	 * Constructor method for the Album
	 * 
	 * @param name String name of the album
	 */
	public Album(String name) {
		this.name = name;
		this.photos = new HashSet<Photo>();
	}

	/**
	 * Getter for the name of the album
	 * 
	 * @return String name of the album
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the photos
	 * 
	 * @return HashSet photos of the album
	 */
	public HashSet<Photo> getPhotos() {
		return this.photos;
	}

	/**
	 * Adds photo to the album if it was not there initially
	 * 
	 * @param Photo p the photo that should be added to the album
	 * @return true if the photo was added and false if if was not
	 */
	public boolean addPhoto(Photo p) {
		if (p == null) {
			return false;
		} else if (this.photos.contains(p)) {
			return false;
		} else {
			this.photos.add(p);
			return true;
		}
	}

	/**
	 * Checks if the photo is in the hash set
	 * 
	 * @param Photo p that will be checked
	 * @return true if the photo is in the album and false if the photo is not
	 */
	public boolean hasPhoto(Photo p) {
		if (this.photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes photo from the album
	 * 
	 * @param Photo p that should be removed from the album
	 * @return true if the photo was removed and false if the photo was not removed
	 */
	public boolean removePhoto(Photo p) {
		if (this.photos.contains(p)) {
			this.photos.remove(p);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Provides the number of photos in the album
	 * 
	 * @return int number of photos in the album.
	 */
	public int numPhotos() {
		return this.photos.size();
	}

	/**
	 * Compares two albums
	 * 
	 * @param Object o the object that will be compared to the initial album
	 * @return true if the albums are equal and return false if they are not equal
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Album) {
			Album a = (Album) o;
			if (this.name.equals(a.name)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Is used to find the String representation of the album
	 * 
	 * @return String representation of the album
	 */
	public String toString() {
		return ("Name of the album: " + this.name + "/n" + "Photos from the album: " + this.photos);
	}

	/**
	 * Is used to find the hash code of the album
	 * 
	 * @return the hash code for the album's name
	 */
	public int hashCode() {
		return name.hashCode();
	}

}
