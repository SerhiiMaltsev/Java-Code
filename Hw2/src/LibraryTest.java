import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testGetPhotos() {

		// input
		Photo p = new Photo("cat", "cat.png", "01-20-1998", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);

		// expected
		ArrayList<Photo> expected1 = new ArrayList<Photo>();
		expected1.add(p);
		ArrayList<Photo> expected2 = null;
		// actual

		ArrayList<Photo> actual1 = l.getPhotos(1);
		ArrayList<Photo> actual2 = l.getPhotos(10);

		assertEquals("Photos with rating 1", expected1, actual1);

	}

	@Test
	public void testGetPhotos2() {

		// input
		Photo p = new Photo("cat", "cat.png", "01-20-1998", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);

		// expected
		ArrayList<Photo> expected1 = new ArrayList<Photo>();
		expected1.add(p);
		ArrayList<Photo> expected2 = null;
		// actual

		ArrayList<Photo> actual1 = l.getPhotos(1);
		ArrayList<Photo> actual2 = l.getPhotos(10);

		assertEquals("Photos with rating 10", expected2, actual2);

	}

	@Test
	public void testGetPhotosInMonth() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
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

		assertEquals("Photos taken in January 1998", expected1, actual1);
	}

	@Test
	public void testGetPhotosInMonth2() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
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

		assertEquals("Photos taken in unexisting month", expected2, actual2);
	}

	@Test
	public void testGetPhotosBetween() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);

		// expected
		ArrayList<Photo> expected1 = new ArrayList<Photo>();
		expected1.add(p);
		ArrayList<Photo> expected2 = new ArrayList<Photo>();
		ArrayList<Photo> expected3 = null;

		// actual
		ArrayList<Photo> actual1 = l.getPhotosBetween("1997-01-02", "2000-01-01");
		ArrayList<Photo> actual2 = l.getPhotosBetween("1999-01-02", "2000-01-01");
		ArrayList<Photo> actual3 = l.getPhotosBetween("1999wqdd-01-02", "212321000-01-01");

		assertEquals("Photos taken between 1997-01-02 and 2000-01-01", expected1, actual1);
		assertEquals("Photos taken between 1999-01-02 and 2000-01-01", expected2, actual2);
	}

	@Test
	public void testGetPhotosBetween2() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);

		// expected
		ArrayList<Photo> expected1 = new ArrayList<Photo>();
		expected1.add(p);
		ArrayList<Photo> expected2 = new ArrayList<Photo>();
		ArrayList<Photo> expected3 = null;

		// actual
		ArrayList<Photo> actual1 = l.getPhotosBetween("1997-01-02", "2000-01-01");
		ArrayList<Photo> actual2 = l.getPhotosBetween("1999-01-02", "2000-01-01");
		ArrayList<Photo> actual3 = l.getPhotosBetween("1999wqdd-01-02", "212321000-01-01");

		assertEquals("Photos taken between 1999-01-02 and 2000-01-01", expected3, actual3);
	}

	@Test
	public void testDeletePhoto() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);
		Library l2 = new Library("library2", 2);

		// expected
		boolean expected1 = true;
		boolean expected2 = false;

		// actual
		boolean actual1 = l.deletePhoto(p);
		boolean actual2 = l2.deletePhoto(p);

		assertEquals("Deletion of the photo for the first time: ", expected1, actual1);
	}

	@Test
	public void testDeletePhoto2() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Library l = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l.photos.add(p);
		Library l2 = new Library("library2", 2);

		// expected
		boolean expected1 = true;
		boolean expected2 = false;

		// actual
		boolean actual1 = l.deletePhoto(p);
		boolean actual2 = l2.deletePhoto(p);

		assertEquals("Deletion of the same photot for the second time: ", expected2, actual2);
	}

	@Test
	public void testSimilarity() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Photo p1 = new Photo("dog", "dog.png", "1999-01-01", 3);
		Library l1 = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l1.addPhoto(p);
		Library l2 = new Library("library2", 2);
		l2.addPhoto(p);

		// expected
		double expected1 = 1.0;
		double expected2 = 0.0;
		double expected3 = 1.0;

		// actual
		double actual1 = l1.similarity(l1, l2);
		l2.deletePhoto(p);
		double actual2 = l2.similarity(l1, l2);
		l2.addPhoto(p);
		l2.addPhoto(p1);
		double actual3 = l2.similarity(l1, l2);

		assertEquals("Simialrity of libraries1: ", expected1, actual1, 0.01);
		assertEquals("Similarity of libraries2: ", expected2, actual2, 0.01);
	}

	@Test
	public void testSimilarity2() {

		// input
		Photo p = new Photo("cat", "cat.png", "1998-01-01", 3);
		Photo p1 = new Photo("dog", "dog.png", "1999-01-01", 3);
		Library l1 = new Library("library1", 1);
		Album a = new Album("animals");
		a.addPhoto(p);
		l1.addPhoto(p);
		Library l2 = new Library("library2", 2);
		l2.addPhoto(p);

		// expected
		double expected1 = 1.0;
		double expected2 = 0.0;
		double expected3 = 1.0;

		// actual
		double actual1 = l1.similarity(l1, l2);
		l2.deletePhoto(p);
		double actual2 = l2.similarity(l1, l2);
		l2.addPhoto(p);
		l2.addPhoto(p1);
		double actual3 = l2.similarity(l1, l2);

		assertEquals("Similarity of libraries3: ", expected3, actual3, 0.01);
	}
}
