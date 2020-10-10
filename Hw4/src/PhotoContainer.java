
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import java.util.ArrayList;

public abstract class PhotoContainer {

	/**
	 * Name of the container
	 */
	protected String name;

	/**
	 * Array list with photos
	 */
	protected ArrayList<Photo> photos;

	/**
	 * Constructor method for PhotoContainer
	 * 
	 * @param String name of the photo container
	 */
	public PhotoContainer(String name) {
		this.name = name;
		this.photos = new ArrayList<Photo>();
	}

	/**
	 * Setter for the name of the container
	 */
	public void setName() {
		this.name = name;
	}

	/**
	 * Getter for the name of the container
	 * 
	 * @return String name of the container
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the photos of the container
	 * 
	 * @return Array list with the photos
	 */
	public ArrayList<Photo> getPhotos() {
		return this.photos;
	}

	/**
	 * Adds photo to the container
	 * 
	 * @param Photo p that will be added to the container
	 * 
	 * @return true if the photo was added and false if the photo was not added
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
	 * Checks if the container has photo
	 * 
	 * @param Photo p that should be found in the container
	 * @return true if the photo is in the container and false if the photo is not
	 *         in the container
	 */
	public boolean hasPhoto(Photo p) {
		if (this.photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes photo from the container
	 * 
	 * @param Photo p the photo that should be removed from the container
	 * 
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
	 * Counts the number of photos in the container
	 * 
	 * @return int number of photos in the container
	 */
	public int numPhotos() {
		return this.photos.size();
	}

	/**
	 * Checks the equality of the current photo container with the other container
	 * 
	 * @param Object that is compared
	 * @return true if these objects are equal and false if they are not equal
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Album) {
			PhotoContainer a = (PhotoContainer) o;
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
	 * Converts the container to the String
	 * 
	 * @return String representation of the container
	 */
	public String toString() {
		return ("Name of the album: " + this.name + "/n" + "Photos from the album: " + this.photos);
	}

	/**
	 * Calculates the hash core of the container
	 * 
	 * @return int hash code of the container
	 */
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Finds the array list of the photos of the container
	 * 
	 * @param int rating of the photos that should be searched
	 * @return ArrayList of the photos
	 */
	public ArrayList<Photo> getPhotos(int rating) {
		ArrayList<Photo> result = new ArrayList<Photo>();
		if (rating > 5 || rating < 1) {
			return null;
		} else {
			for (Photo i : this.photos) {
				if (i.getRating() >= rating) {
					result.add(i);
				}
			}
			return result;
		}
	}

	/**
	 * Finds of the photos taken in particular year
	 * 
	 * @param int year when the photos were taken
	 * @return Array List of the photos that were taken in particular year
	 */
	public ArrayList<Photo> getPhotosInYear(int year) {
		ArrayList<Photo> result = new ArrayList<Photo>();
		if (year < 0 || year > 9999) {
			return null;
		} else {
			for (Photo i : this.photos) {
				if (DateLibrary.getYear((i.getDateTaken())) == year) {
					result.add(i);
				}
			}
			return result;
		}
	}

	/**
	 * Finds of the photos taken in particular month
	 * 
	 * @param int year when the photos were taken
	 * @param int month when the photos were taken
	 * @return Array List of the photos that were taken in particular year
	 */
	public ArrayList<Photo> getPhotosInMonth(int month, int year) {
		ArrayList<Photo> result = new ArrayList<Photo>();
		if (year < 0 || year > 9999 || month < 1 || month > 12) {
			return null;
		} else {
			for (Photo i : this.photos) {
				System.out.println(this.photos);
				if (DateLibrary.getYear((i.getDateTaken())) == year
						&& DateLibrary.getMonth((i.getDateTaken())) == month) {
					result.add(i);

				}
			}
			return result;
		}
	}

	/**
	 * Gets the photos between two dates
	 * 
	 * @param String beginDate the begin date when the photos were taken
	 * @param String endDate the end date when the photos were taken
	 * @return Array List of photos that were taken between two dates
	 */
	public ArrayList<Photo> getPhotosBetween(String beginDate, String endDate) {
		ArrayList<Photo> result = new ArrayList<Photo>();
		if (DateLibrary.isValidDate(beginDate) == false || (DateLibrary.isValidDate(endDate)) == false) {
			return null;
		} else {
			for (Photo p : this.photos) {
				if (DateLibrary.compare(p.getDateTaken(), beginDate) >= 0
						&& DateLibrary.compare(p.getDateTaken(), endDate) <= 0) {
					result.add(p);
				}
			}
		}
		return result;
	}

}
