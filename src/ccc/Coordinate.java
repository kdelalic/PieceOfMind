package ccc;

/**
 * Class for Coordinate objects used to bundle the 
 * latitude and longitude information of a city in
 * one easily accessible object.
 * 
 */
public class Coordinate {

	private double lat;
	private double lon;

	/**
	 * Constructs the Coordinate object using the city's
	 * location information.
	 * @param lat
	 * @param lon
	 */
	public Coordinate(double lat, double lon){		
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * Returns the latitude dimension of the coordinate.
	 * @return lat
	 */
	public double getLat() {
		return this.lat;
	}

	/**
	 * Returns the longitude dimension of the coordinate.
	 * @return lon
	 */
	public double getLon() {
		return this.lon;
	}
	
}
