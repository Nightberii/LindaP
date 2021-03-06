package jtm.activity04;

import java.util.Locale;

public class Transport {
	// Do not change access modifiers to encapsulate internal properties!
	private String id; // Transport registration number
	private float consumption; // fuel consumption in litres per 100km
	private int tankSize; // tank size in litres
	private float fuelInTank; // fuel in tank
	/*- TODO #1
	 * Select menu Source — Generate Constructor using Fields...
	 * and create constructor which sets id, consumption, tankSize
	 * values of the newly created object
	 * And make fuel tank full.
	 */
	public Transport(String id, float consumption, int tankSize) {
		this.id = id;
		this.consumption = consumption;
		this.tankSize = tankSize;
		this.fuelInTank = tankSize;
	}
	/*- TODO #2
	 * Select menu: Source — Generate getters and Setters...
	 * and generate public getters for consumption, tankSize, id, and
	 * fuelInTank fields
	 */
	public float getConsumption() {
		return consumption;
	}
	public int getTankSize() {
		return tankSize;
	}
	public String getId() {
		return id;
	}
	public float getFuelInTank() {
		return fuelInTank;
	}

	/*- TODO #3
	 * Select menu: Source — Generate toString()...
	 * and implement this method, that t returns String in form:
	 * "Id:ID cons:0.0l/100km, tank:00l, fuel:00.00l"
	 * 	HINT: use String.format(Locale.US, "%.2f", float) to limit shown numbers
	 *  to 2 decimal for fractions, and dot as a decimal delimiter.
	 */
	@Override
	public String toString() {
		return "Id:" + id + " cons:" + consumption + "l/100km, tank:" + tankSize +
				"l, fuel:"
				+ String.format(Locale.US, "%.2f", getFuelInTank()) + "l";
	}
	// Return transport id and type as string e.g. "AAA Transport"
	// HINT: use this.getClass().getSimpleName(); to get type of transport
	protected final String getType() {
		// TODO return required value
		// START
		String type = this.getClass().getSimpleName();
		return id + " " + type;
	}
	// HINT: use getType() to describe transport and road.toString() to describe
	// road
	// HINT: String.format(Locale.US, "%.2f", float) to format float number with
	// fixed mask
	public String move(Road road) {
		// TODO If transport has enough fuel, decrease actual amount of fuel by
		// necessary amount and return String in form:
		// "AAA Type is moving on From–To, 180km"
		// TODO If there is no enough fuel in tank, return string in form:
		// "Cannot move on From–To, 180km. Necessary
		// fuel:0.00l, fuel in tank:0.00l"
		float necessaryFuel = road.getDistance() *consumption/100;
		if (necessaryFuel >= fuelInTank)
			return "Cannot move on " + road + ". Necessary fuel:"
					+ String.format(Locale.US, "%.2f", necessaryFuel)
					+ "l, fuel in tank:" + String.format(Locale.US, "%.2f", fuelInTank)
					+ "l";
		else {
			fuelInTank -= necessaryFuel;
			return getType() + " is moving" + " on " + road;
		}
	}
}
