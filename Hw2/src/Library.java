
/**
 * Homework 2
 * Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Library {

	/**
	 * Holds the name of the library
	 */
	private String name;

	/**
	 * Holds the id of the library
	 */
	private final int id;

	/**
	 * Holds the array with photos
	 */
	ArrayList<Photo> photos = new ArrayList<Photo>();

	/**
	 * Holds the albums of the library
	 */
	private HashSet<Album> albums;

	/**
	 * Constructor method of the library class
	 * 
	 * @param name parameter that is used to define the library name
	 * @param id   is used to define the id of the library
	 */
	public Library(String name, int id) {
		this.id = id;
		this.name = name;
		this.albums = new HashSet<Album>();
	}

	/**
	 * Getter for the name of the library
	 * 
	 * @return String name of the library
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the name of the id
	 * 
	 * @return int id of the library
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Getter for the objects of the library
	 * 
	 * @return ArrayList of the photos of the library
	 */
	public ArrayList<Photo> getPhotos() {
		return this.photos;
	}

	/**
	 * Getter for the albums
	 * 
	 * @return the Hash Set of the Albums
	 */
	public HashSet<Album> getAlbums() {
		return this.albums;
	}

	/**
	 * Setter for the name of the library
	 * 
	 * @param String name of the library
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Add object Photo to the ArrayList of the photos of the library if the object
	 * is not in the library.
	 * 
	 * @param Photo object that will be added to the library
	 * @return true if the photo was added and returns false if the photo was not
	 *         added
	 */
	public boolean addPhoto(Photo p) {
		if (this.photos.contains(p)) {
			return false;
		} else {
			this.photos.add(p);
			return true;
		}
	}

	/**
	 * Checks is the Photo in the library of not
	 * 
	 * @param Photo object that is searched in the library
	 * @return true if the photo is in the library of false if the photo is not in
	 *         the library
	 */
	public boolean hasPhoto(Photo p) {
		if (this.photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * If the library contains photo, deletes it
	 * 
	 * @param Photo object that is searched in the library
	 * @return true if the object was removed or false if the object was not removed
	 */
	public boolean deletePhoto(Photo p) {
		if (this.photos.indexOf(p) != -1) {
			this.photos.remove(this.photos.indexOf(p));
			for (Album i : this.albums) {
				if (i.hasPhoto(p)) {
					i.removePhoto(p);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Finds number of the photo in the library
	 * 
	 * @return int number of the photos in the library
	 */
	public int numPhotos() {
		return (this.photos.size());
	}

	/**
	 * Checks for equality of two libraries
	 * 
	 * @return true if two libraries are equal and false if two libraries are not
	 *         equal
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof Library) {
			Library newLibrary = (Library) o;
			if (newLibrary.id == this.id) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Finds the ArrayList of photos that are common for two libraries
	 * 
	 * @param a first Library
	 * @param b second Library
	 * @return ArrayList of common photos
	 */
	public static ArrayList<Photo> commonPhotos(Library a, Library b) {
		ArrayList<Photo> result = new ArrayList<Photo>();
		for (int i = 0; i < a.photos.size(); i++) {
			for (int j = 0; j < b.photos.size(); j++) {
				if (a.photos.get(i) == b.photos.get(j)) {
					result.add(a.photos.get(i));
				}
			}
		}
		return result;
	}

	/**
	 * Finds the similarity of two libraries. (ration of common photos to the
	 * smallest number of photos in the library)
	 * 
	 * @param a fists Library
	 * @param b second Library
	 * @return double value of the similarity of two libraries
	 */
	public static double similarity(Library a, Library b) {
		double result;
		int minimum;
		int common;
		if (a.photos.size() == 0 || b.photos.size() == 0) {
			result = 0.0;
		} else {
			common = commonPhotos(a, b).size();
			if (a.photos.size() >= b.photos.size()) {
				minimum = b.photos.size();
			} else {
				minimum = a.photos.size();
			}
			result = (double) common / (double) minimum;
		}
		return result;
	}

	/**
	 * Is used to create the string representation of the Library
	 * 
	 * @return String representation of the library
	 */
	public String toString() {
		return ("Library name: " + this.name + ", library id: " + this.id + ", ibrary photos: " + this.photos
				+ ", albums: " + this.albums);
	}

	/**
	 * Is used to get the photos from the album
	 * 
	 * @param int rating of the photo
	 * @return all photos with the rating bigger than the parameter
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
	 * Finds all the photos that were taken in particular year
	 * 
	 * @param int year the year when the photos are taken
	 * @return ArrayList of the photos that were taken in particular year
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
	 * Is used to find all the photos that were taken in particular month
	 * 
	 * @param int month when the photo was taken
	 * @param int year when the photo was taken
	 * @return the array list of the photos that were taken in particular month and
	 *         year
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
	 * Finds all photos between two dates
	 * 
	 * @param beginDate String of the begin date
	 * @param endDate   String of the end date
	 * @return the Array List of photos that were taken between these dates or null
	 *         if the dates are wrong (in the wrong format or DNE)
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

	/**
	 * Crates album with particular name and adds it to the list of albums
	 * 
	 * @param String albumName the name of the album
	 * @return true if the album was added and return false if the album was not
	 *         added
	 */
	public boolean createAlbum(String albumName) {
		Album x = new Album(albumName);
		if (albums.contains(x)) {
			return false;
		} else {
			albums.add(x);
			return true;
		}
	}

	/**
	 * Removes the album from the list of albums
	 * 
	 * @param String albumName is the name of the album that should be removed
	 * @return true if the album was removed and false if the album was not removed
	 */
	public boolean removeAlbum(String albumName) {
		Album x = new Album(albumName);
		if (albums.contains(x)) {
			albums.remove(x);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds photo to the album if the photo is in the photos library and the album
	 * does not contain photo already
	 * 
	 * @param Photo  p the photo that should be added to the album
	 * @param String albumName the name of the album where the photo should be added
	 * @return true if the photo was added and false if the photo was not added
	 */
	public boolean addPhotoToAlbum(Photo p, String albumName) {
		boolean added = false;
		for (Album i : this.albums) {
			if (i.getName() == albumName && this.photos.contains(p)) {
				i.addPhoto(p);
				added = true;
			}
		}
		return added;
	}

	/**
	 * Removes the photo from the album with particular name
	 * 
	 * @param Photo  p the photo that should be removed from the album
	 * @param String albumName the name of the album where the photo should be added
	 * @return true if the photo was removed and false if the photo was not removed
	 */
	public boolean removePhotoFromAlbum(Photo p, String albumName) {
		boolean removed = false;
		for (Album i : this.albums) {
			if (i.getName() == albumName && i.hasPhoto(p)) {
				i.removePhoto(p);
				removed = true;
			}
		}
		return removed;
	}

	/**
	 * Used to return the album by the name
	 * 
	 * @param String albumName the name of the album
	 * @return the album with particular name
	 */
	private Album getAlbumByName(String albumName) {
		Album x = null;
		for (Album i : this.albums) {
			if (i.getName() == albumName) {
				x = i;
			}
		}
		return x;
	}

	/**
	 * Is used to test created class and its methods
	 */
	public static void main(String[] args) {
		Photo p = new Photo("cat", "cat.png", "1998-12-02", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);

		// expected
		ArrayList<Photo> expected1 = new ArrayList<Photo>();
		expected1.add(p);
		ArrayList<Photo> expected2 = null;

		// actual
		ArrayList<Photo> actual1 = l.getPhotosInMonth(1, 1998);
		ArrayList<Photo> actual2 = l.getPhotosInMonth(13, 1998);

		System.out.println();
	}
}
