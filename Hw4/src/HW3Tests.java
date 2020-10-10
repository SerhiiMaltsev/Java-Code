
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class HW3Tests {

	/**
	 * First test of the removePhoto for the library
	 */
	@Test
	public void testRemovePhoto1() {

		// input
		Library lib = new Library("cats", 1);
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		lib.addPhoto(photo1);
		Library lib2 = new Library("dogs", 2);

		// expected
		Library expected = new Library("cats", 1);
		ArrayList<Photo> lib2photos = lib2.photos;
		ArrayList<Photo> lib1 = new ArrayList<Photo>();
		lib1.add(photo1);
		lib2.removePhoto(photo1);
		int id = expected.getId();
		Library.commonPhotos(lib, lib2);
		Library.similarity(lib, lib2);

		// actual
		lib.removePhoto(photo1);

		assertEquals("Test of remove photo 1", expected, lib);
	}

	/**
	 * Second test of the removePhoto for the library
	 */
	@Test
	public void testRemovePhoto2() {

		Photo photo1 = new Photo("fluffy.jpg", "white cat");

		// input
		Library lib = new Library("cats", 1);
		lib.addPhoto(null);

		// expected
		boolean expected = false;

		// actual
		boolean actual = lib.removePhoto(null);

		assertEquals("Test of remove photo 2", expected, actual);
	}

	/**
	 * First test of the compareTo for the photo
	 */
	@Test
	public void testCompareTo1() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("doggy.jpg", "black dog");

		// expected
		int result = 21;

		// actual
		assertEquals("Test of compare", photo1.compareTo(photo2), result);

	}

	/**
	 * Second test of the compareTo for the photo
	 */
	@Test
	public void testCompareTo2() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("fluffy.jpg", "white cat");

		// expected
		int expected = 0;

		// actual
		int actual = photo1.compareTo(photo2);

		assertEquals("Test of compare", expected, actual);

	}

	/**
	 * First test of the comparator for the CompareCaptionComparator
	 */
	@Test
	public void testComparePhotoCaptionComparator1() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("doggy.jpg", "black dog");

		// expected
		int result = 21;

		// actual
		PhotoCaptionComparator comp = new PhotoCaptionComparator();
		int actualComp = comp.compare(photo1, photo2);

		assertEquals("Test of ComparePhotoCaptionComparator", actualComp, result);

	}

	/**
	 * Second test of the comparator for the CompareCaptionComparator
	 */
	@Test
	public void testComparePhotoCaptionComparator2() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("fluffy.jpg", "white cat");

		// expected
		int result = 0;

		// actual
		PhotoCaptionComparator comp = new PhotoCaptionComparator();
		int actualComp = comp.compare(photo1, photo2);

		assertEquals("Test of ComparePhotoCaptionComparator", actualComp, result);

	}

	/**
	 * First test of the comparator for the CompareRatingComparator
	 */
	@Test
	public void testComparePhotoRatingComparator1() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("doggy.jpg", "black dog");

		// expected
		int result = 21;

		// actual
		PhotoRatingComparator comp = new PhotoRatingComparator();
		int actualComp = comp.compare(photo1, photo2);

		assertEquals("Test of ComparePhotoCaptionComparator", actualComp, result);

	}

	/**
	 * Second test of the comparator for the CompareRatingComparator
	 */
	@Test
	public void testComparePhotoRatingComparator2() {

		// input
		Photo photo1 = new Photo("fluffy.jpg", "white cat");
		Photo photo2 = new Photo("fluffy.jpg", "white cat");

		// expected
		int result = 0;

		// actual
		PhotoRatingComparator comp = new PhotoRatingComparator();
		int actualComp = comp.compare(photo1, photo2);

		assertEquals("Test of ComparePhotoCaptionComparator", actualComp, result);

	}

}
