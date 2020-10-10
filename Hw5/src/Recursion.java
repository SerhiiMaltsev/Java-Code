/**
 * Homework 5
 * 
 * Implement the following methods on recursion as defined in the homework 5
 * document.
 * 
 * @author Serhii Maltsev ( sm5zj )
 *
 */
public class Recursion {

	/**
	 * Recursively checks if the string is palindrome
	 * 
	 * @param String s is the item that will be checked
	 * @return true if the element is palindrom and false if the element is not
	 *         palindrome
	 */
	public static boolean palindrome(String s) {
		if (s.length() == 1) {
			return true;
		} else if ((s.length() == 2) && (s.charAt(0) == s.charAt(1))) {
			return true;
		} else if (s.length() > 2) {
			if (s.charAt(0) == s.charAt(s.length() - 1)) {
				return palindrome(s.substring(1, s.length() - 1)); // recursive call of the method
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * returns the reverse of the string
	 * 
	 * @param String s is the string that should be reversed
	 * @return reversed String
	 */
	public static String reverseString(String s) {
		if (s.length() == 1) {
			return s;
		} else if (s.length() == 2) {
			String changedStr = Character.toString(s.charAt(1)) + Character.toString(s.charAt(0));
			return changedStr;
		} else {
			// recursive call of the method
			String changedStr = Character.toString(s.charAt(s.length() - 1))
					+ reverseString(s.substring(1, s.length() - 1)) + Character.toString(s.charAt(0));
			return changedStr;
		}
	}

	/**
	 * this method is used to count the number of hand shakes that must be done when
	 * n people meet
	 * 
	 * @param n is the number of people that met
	 * @return number of hand shakes
	 */
	public static int handshakes(int n) {
		if (n < 2) {
			return 0;
		} else {
			return n - 1 + handshakes(n - 1); // recursive call of the method
		}
	}

	/**
	 * this method is used to model the Ackermann function
	 * 
	 * @param m long first parameter of the Ackermann function
	 * @param n long second parameter of the Ackermann function
	 * @return the result of Ackermann function
	 */
	public static long ackermann(long m, long n) {
		if (m == 0) {
			return n + 1;
		} else if (m > 0 && n == 0) {
			return ackermann(m - 1, 1); // recursive call of the method
		} else {
			return ackermann(m - 1, ackermann(m, n - 1)); // recursive call of the method
		}
	}

	public static void main(String[] args) {
		System.out.println(palindrome("abba")); // expected: true actual: true
		System.out.println(palindrome("racecar")); // expected: true actual: true
		System.out.println(palindrome("smith")); // expected: false actual: false

		System.out.println();

		System.out.println(reverseString("racecar")); // expected: racecar actual: racecar
		System.out.println(reverseString("CS2110")); // expected: 0112SC actual: 0112SC
		System.out.println(reverseString("I love CS!")); // expected: !SC evol I actual: !SC evol I

		System.out.println();

		System.out.println(handshakes(0)); // expected: 0 actual: 0
		System.out.println(handshakes(3)); // expected: 3 actual: 3
		System.out.println(handshakes(6)); // expected: 15 actual: 15

		System.out.println();

		System.out.println(ackermann(0, 0)); // expected: 1 actual: 1
		System.out.println(ackermann(2, 0)); // expected: 3 actual: 3
		System.out.println(ackermann(3, 4));// expected: 125 actual: 125

	}
}