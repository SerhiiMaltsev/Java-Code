/**
 * Homework 4 Serhii Maltsev, sm5zj
 *
 * Sources : lectures of professor Apostolellis Image resizing from 1:00 - 2:00
 * https://www.google.com/search?ei=s91_XoquFvSwytMP4tSvuAU&q=java+image+resize&oq=java+image+resize&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgQIABBHOgUIABCRAjoFCAAQgwE6BAgAEENQ9NghWKPzIWCF9SFoAHAEeACAAdABiAHEFJIBBjAuMTYuMZgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjK04ilqb7oAhV0mHIEHWLqC1cQ4dUDCAs&uact=5#kpvalbx=_399_XvGJMuiyytMPitKb2As18
 * https://docs.oracle.com/javase/tutorial/uiswing/
 */

public class DateLibrary {
	/**
	 * Checks if the date was inputed in the correct format.
	 * 
	 * @param String date that should be examined
	 * @return true if the date is in correct format or false if the date is in
	 *         incorrect format
	 */
	public static boolean isValidDateFormat(String date) {
		if (date.length() == 10) {
			char[] elements = new char[10];
			for (int i = 0; i < elements.length; i++) {
				elements[i] = date.charAt(i);
			}
			if (Character.isDigit(elements[0]) && Character.isDigit(elements[1]) && Character.isDigit(elements[2])
					&& Character.isDigit(elements[3]) && Character.isDigit(elements[5])
					&& Character.isDigit(elements[6]) && Character.isDigit(elements[8])
					&& Character.isDigit(elements[9]) && elements[4] == '-' && elements[7] == '-') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Used to extract value of the year from the string
	 * 
	 * @param String date that should be examined
	 * @return false if the date is in wrong format or int value of year if the
	 *         format if correct
	 */
	public static int getYear(String date) {
		int year = -1;
		if (isValidDateFormat(date) == false) {
			return year;
		} else {
			String strYear = date.substring(0, 4);
			return Integer.parseInt(strYear);
		}
	}

	/**
	 * Used to extract value of the month from the string
	 * 
	 * @param String date that should be examined
	 * @return false if the date is in wrong format or int value of month if the
	 *         format if correct
	 */
	public static int getMonth(String date) {
		int year = -1;
		if (isValidDateFormat(date) == false) {
			return year;
		} else {
			String strMonth = date.substring(5, 7);
			int m = Integer.parseInt(strMonth);
			if (m >= 1 && m <= 12) {
				return m;
			} else {
				return -1;
			}
		}
	}

	/**
	 * Used to extract value of the day from the string
	 * 
	 * @param String date that should be examined
	 * @return false if the date is in wrong format or int value of day if the
	 *         format if correct
	 */
	public static int getDay(String date) {
		int year = -1;
		if (isValidDateFormat(date) == false) {
			return year;
		} else {
			String strDay = date.substring(8, 10);
			int d = Integer.parseInt(strDay);
			if (d >= 1 && d <= 31) {
				return d;
			} else {
				return -1;
			}
		}
	}

	/**
	 * Used to determine if the year is leap or not
	 * 
	 * @param int year that should be examined
	 * @return true if the year is leap and false if the year is not leap
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 100 == 0 && year % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Used to determine if the date is valid
	 * 
	 * @param String date that should be examined
	 * @return true if the date is valid and false if the date is not valid
	 */
	public static boolean isValidDate(String date) {
		if (isValidDateFormat(date) == false) {
			return false;
		} else {
			int year = getYear(date);
			int month = getMonth(date);
			int day = getDay(date);
			if (month >= 1 && month <= 12) {
				boolean valid = false;
				switch (month) {
				case 1:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 2:

					if (isLeapYear(year) == true) {
						if (day <= 29 && day != -1) {
							valid = true;
						}
					}
					if (isLeapYear(year) == false) {
						if (day <= 28 && day != -1) {
							valid = true;
						}
					}
					break;
				case 3:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 4:
					if (day <= 30 && day != -1) {
						valid = true;
					}
					break;
				case 5:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 6:
					if (day <= 30 && day != -1) {
						valid = true;
					}
					break;
				case 7:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 8:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 9:
					if (day <= 30 && day != -1) {
						valid = true;
					}
					break;
				case 10:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				case 11:
					if (day <= 30 && day != -1) {
						valid = true;
					}
					break;
				case 12:
					if (day <= 31 && day != -1) {
						valid = true;
					}
					break;
				}
				if (valid == true) {

					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	/**
	 * Used to compare two strings
	 * 
	 * @param String date1 - first String. String date2 - second String.
	 * @return 0 if the dates are equal, -1 if the first date comes before date2,
	 *         and 1 if the second date comes before date1.
	 */
	public static int compare(String date1, String date2) {
		if (isValidDate(date1) == false) {
			return 0;
		} else if (isValidDate(date2) == false) {
			return 0;
		} else if (date1 == date2) {
			return 0;
		} else {
			return date1.compareTo(date2);
		}
	}

	/**
	 * Main method used to test the code
	 */
	public static void main(String[] args) {
		System.out.println("Test of the isValidDateFormat:");
		System.out.println(isValidDateFormat("1998-12-02"));
		System.out.println(isValidDateFormat("19981202"));
		System.out.println();

		System.out.println("Test of the getYear:");
		System.out.println(getYear("1998-12-02"));
		System.out.println(getYear("19981202"));
		System.out.println();

		System.out.println("Test of the getMonth:");
		System.out.println(getMonth("1998-12-02"));
		System.out.println(getMonth("19981202"));
		System.out.println();

		System.out.println("Test of the getDay:");
		System.out.println(getDay("1998-12-02"));
		System.out.println(getDay("19981202"));
		System.out.println();

		System.out.println("Test of the isLeapYear:");
		System.out.println(isLeapYear(1998));
		System.out.println(isLeapYear(2000));
		System.out.println();

		System.out.println("Test of the isValidDate:");
		System.out.println(isValidDate("1998-12-02"));
		System.out.println(isValidDate("19981202"));
		System.out.println();

		System.out.println("Test of the compare:");
		System.out.println(compare("1998-12-02", "1998-12-03"));
		System.out.println(compare("2000-12-02", "1998-01-02"));
	}
}
