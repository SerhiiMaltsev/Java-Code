import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
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

		System.out.println(actual1);
	}

}
