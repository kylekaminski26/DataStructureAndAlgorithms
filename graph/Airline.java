package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import list.ArrayList;
import list.Iterator;
import list.LinkedList;
import list.List;
import queue.PriorityQueue;

/**
 * Manage a network of airline flights Find a path, not nexessarily shortest
 * from an Airport to another Airport Input is a text file of Direct Flights
 * 
 * @author Kyle Kaminski
 * @version 2019
 */
public class Airline {

	List<Flight> flights; // all the direct flights are in this list
	Map<String, Airport> map; // Keys: airport names. Values: airports

	public static void main(String[] args) {
		Airline airline = new Airline();
		airline.getFlights();
		System.out.println("Flights: " + airline.flights);
		System.out.println("Path from CVG to Paris");
		System.out.println(airline.path("CVG", "Paris"));
		airline.map.get("PHL").setHub(true);
		System.out.println(airline.path("CVG", "Paris"));
	}

	// Read in the direct flights from the text file "flights.txt"
	// Each line is an origin and a destination Airport separated by one spce
	private void getFlights() {
		try {
			map = new HashMap<String, Airport>();
			flights = new ArrayList<Flight>();
			File inFile = new File("flights.txt");
			Scanner scanner = new Scanner(inFile);
			String flight, origin, dest;
			Airport o, d;
			while (scanner.hasNextLine()) {
				flight = scanner.nextLine();
				// split returns an array of Strings
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
				if (map.containsKey(origin))
					o = map.get(origin);
				else {
					o = new Airport(origin);
					map.put(origin, o);
				}

				if (map.containsKey(dest))
					d = map.get(dest);
				else {
					d = new Airport(dest);
					map.put(dest, d);
				}

				flights.add(new Flight(o, d));
			}

			scanner.close();
		}

		catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		}
	}

	/**
	 * @return a List of Airports from given origin to given dest, or empty List if
	 *         there is no path
	 */
	private List<Airport> path(String origin, String dest) {
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		List<Airport> result = path(o, d);
		clearAirports();
		return result;
	}

	/**
	 * @return a List of Airports from given origin to given dest, or empty List if
	 *         there is no path
	 */
	private List<Airport> path(Airport origin, Airport dest) {
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		// base case
		if (origin.equals(dest)) {
			result.add(origin);
			return result;
		}

		Airport port;
		// Iterate thru Airports which can be reached directly from the origin
		// Iterator<Airport> itty = getDirect(origin).iterator();
		PriorityQueue<Airport> pq = getDirect(origin);
		while (!pq.isEmpty()) {
			port = pq.remove();
			port.visited = true;
			result = path(port, dest); // recursive call
			if (result.size() > 0) {
				result.add(0, origin);
				return result;
			}
		}
		return result;
	}

	/**
	 * @return a List of all Airports which can be reached directly form the given
	 *         Airport, from, and which have not already been visited
	 */
	private PriorityQueue<Airport> getDirect(Airport from) {
		PriorityQueue<Airport> result = new PriorityQueue<Airport>();
		Iterator<Flight> it = flights.iterator();
		Flight flight;
		while (it.hasNext()) {
			flight = it.next();
			if (flight.origin.equals(from) && !flight.destination.visited)
				result.add(flight.destination);
		}
		return result;
	}

	/**
	 * Clear the visited flags in all airports
	 */
	private void clearAirports() {
		Flight flight;
		Iterator<Flight> itty = flights.iterator();
		while (itty.hasNext()) {
			flight = itty.next();
			flight.origin.visited = false;
			flight.destination.visited = false;
		}
	}
}
