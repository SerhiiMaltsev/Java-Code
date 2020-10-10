package lab3;

import static org.junit.Assert.*;

import org.junit.*;

public class TaxiTest {

	Taxi t;

	@Before
	public void setup() {
		t = new Taxi(12.00, 5);
	}

	// Sample Unit Test
	@Test(timeout = 100)
	public void testPickUpSuccess() {
		assertTrue(t.pickUp(5));
	}

	// calculateFare() test #1
	@Test(timeout = 100)
	public void testCalculateFare() {
		/*
		 * Your test implementation goes here.
		 */

		// input
		t.pickUp(5); // taxi is filled with five passengers
		int passengersLeaving = 2; // two passengers are leaving
		int durationOfRide = 15; // the ride duration was 15 minutes

		// output
		double expected = 6.0;

		// actual
		double actual = t.calculateFare(passengersLeaving, durationOfRide);

		// assertion statement
		assertEquals(expected, actual, 0.01);
	}

	// pickUp() test #1
	@Test(timeout = 100)
	public void testPickUpEnoughRoom() {
		/*
		 * Make sure pickUp() returns true when you try to pick up some number of
		 * passengers within capacity.
		 */

		// input
		t.pickUp(4);
		int passengersLoading = 1; // picking up one more passenger when there are already four (max = five)

		// output
		boolean expected = true;

		// actual
		boolean actual = t.pickUp(passengersLoading); 

		// assertion statement
		assertTrue(actual);
	}

	// pickUp() test #2
	@Test
	public void testPickUpNotEnoughRoom() {
		/*
		 * Make sure pickUp() returns false when you try to pick up more passengers than
		 * the capacity.
		 */

		// input
		t.pickUp(4);
		int passengersLoading = 2; // picking up two more passengers when there are already four (max = five)

		// output
		boolean expected = false;

		// actual
		boolean actual = t.pickUp(passengersLoading);

		// assertion statement
		assertFalse(actual);
	}

	// pickUp() test #3
	@Test
	public void testPickUpNobody() {
		/*
		 * Make sure pickUp() returns false when you try to pick up more passengers than
		 * the capacity.
		 */

		// input
		int passengersLoading = 0; // no passenger is picked up

		// output
		boolean expected = false; 

		// actual
		boolean actual = t.pickUp(passengersLoading);

		// assertion statement
		assertFalse(actual);
	}

	// calculateFare() test #2
	@Test
	public void testCalculateFareNoneLeaving() {
		// input
		t.pickUp(5);
		int passengersLeaving = 0;
		int durationOfRide = 15;

		// output
		double expected = 0.0;

		// actual
		double actual = t.calculateFare(passengersLeaving, durationOfRide);

		// assertion statement
		assertEquals(expected, actual, 0.01);
	}

	// calculateFare() test #3
	@Test
	public void testCalculateFareNegativeLeaving() {
		// input
		t.pickUp(5);
		int passengersLeaving = -10;
		int durationOfRide = 15;

		// output
		double expected = 0.0;

		// actual
		double actual = t.calculateFare(passengersLeaving, durationOfRide);

		// assertion statement
		assertEquals(expected, actual, 0.01);
	}

	// calculateFare() test #4
	@Test
	public void testCalculateFareNegativeDuration() {
		// input
		t.pickUp(5);
		int passengersLeaving = 2;
		int durationOfRide = -15;

		// output
		double expected = 0.0;

		// actual
		double actual = t.calculateFare(passengersLeaving, durationOfRide);

		// assertion statement
		assertEquals(expected, actual, 0.01);
	}

}