
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Library extends PhotoContainer {

	/**
	 * Holds the id of the library
	 */
	private final int id;

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
		super(name);
		this.id = id;
		this.name = name;
		this.albums = new HashSet<Album>();
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
	 * Getter for the albums
	 * 
	 * @return the Hash Set of the Albums
	 */
	public HashSet<Album> getAlbums() {
		return this.albums;
	}

	/**
	 * If the library contains photo, deletes it
	 * 
	 * @param Photo object that is searched in the library
	 * @return true if the object was removed or false if the object was not removed
	 */
	public boolean removePhoto(Photo p) {
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
