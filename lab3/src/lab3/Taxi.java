package lab3;

public class Taxi {

	/*
	 * Put global fields here.
	 */
	public double rate;
	public int capacity;
	public int passengers;

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
		/*
		 * Initialize global fields. These values will never be changed because the
		 * constructor has no parameters.
		 */
		this.rate = 0.0;
		this.capacity = 0;
		this.passengers = 0;

	}

	public Taxi(double rate, int capacity) {
		/*
		 * Initialize global fields. These values can be changed via constructor
		 * parameters.
		 */
		this.rate = rate;
		this.capacity = capacity;
		this.passengers = 0;
	}

	public double calculateFare(int passengersLeaving, int durationOfRide) {
		/*
		 * Your method implementation goes here.
		 */
		if (passengersLeaving < 0) {
			passengersLeaving = 0;
		}
		if (durationOfRide < 0) {
			durationOfRide = 0;
		}
		passengers -= passengersLeaving;
		return passengersLeaving * durationOfRide * (rate / 60);
	}

	public boolean pickUp(int passengersLoading) {
		/*
		 * Your method implementation goes here.
		 */
		if ((passengersLoading <= (capacity - passengers)) && (passengersLoading != 0)) {
			passengers += passengersLoading;
			return true;
		}
		return false;
	}

}