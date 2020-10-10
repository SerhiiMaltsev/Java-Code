
/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis
 * 			 Image resizing from 1:00 - 2:00 https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * 			 https://docs.oracle.com/javase/tutorial/uiswing/
 */

import java.util.Comparator;

public class PhotoCaptionComparator implements Comparator<Photo> {

	/**
	 * Comparator method that compares by caption first and then by rating
	 *
	 * @param Photo o1 the first photo to compare
	 * @param Photo o2 the second photo to compare
	 */
	@Override
	public int compare(Photo o1, Photo o2) {
		int captionComp = o1.getCaption().compareTo(o2.getCaption());
		Integer ratingO1 = o1.getRating();
		Integer ratingO2 = o2.getRating();
		int ratingComp = ratingO1.compareTo(ratingO2);
		if (captionComp != 0) {
			return captionComp;
		} else {
			return ratingComp * (-1); // times -1 because teams with the lowest rating go first
		}
	}

}
