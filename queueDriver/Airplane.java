package queueDriver;

/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 * 
 * @author Kyle Kaminski
 * @version (Apr 2019)
 */
public class Airplane implements Comparable {
	int flight;
	int arrivalTime;
	int fuelLevel; // gallons of jet fuel remaining

	final int LOW_FUEL_LEVEL = 4;

	public Airplane(int arrival, int fuel, int flight) {
		arrivalTime = arrival;
		fuelLevel = fuel;
		this.flight = flight;
		System.out.println(this + " has arrived at time " + arrival);
	}

	public String toString() {
		return "flight " + flight + ": fuel=" + fuelLevel + " gallon(s)";
	}

	public int compareTo(Object obj) {
		if (!(obj instanceof Airplane))
			return 0;
		Airplane temp = (Airplane) obj;
		if (this.fuelLevel < LOW_FUEL_LEVEL && temp.fuelLevel >= LOW_FUEL_LEVEL)
			return 1;
		if (this.fuelLevel >= LOW_FUEL_LEVEL && temp.fuelLevel < LOW_FUEL_LEVEL)
			return -1;
		if (this.fuelLevel < LOW_FUEL_LEVEL && temp.fuelLevel < LOW_FUEL_LEVEL) {
			if (this.arrivalTime < temp.arrivalTime)
				return 1;
			return temp.fuelLevel - this.fuelLevel;
		}
		return temp.arrivalTime - this.arrivalTime;
	}
}