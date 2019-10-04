package graph;

/**
 * Flight for an airline has an origin and a destination This is a direct flight
 * 
 * @author Kyle Kaminski
 * @version 2019
 */
public class Flight {
	Airport origin, destination;

	public Flight(Airport o, Airport d) {
		origin = o;
		destination = d;
	}

	public String toString() {
		return " (" + origin + "->" + destination + ") ";
	}
}