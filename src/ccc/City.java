package ccc;

/**
 * Class for City objects that contain information about the names
 * and locations of cities in the USA. 
 */
public class City {

	private double lat;
	private double lon;
	private String name;
	private Coordinate coordinate;
	
	/**
	 * Constructs City object and bundles location information into 
	 * a Coordinate class variable.
	 * @param name
	 * @param lat
	 * @param lon
	 */
	public City(String name, double lat, double lon){
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.coordinate = new Coordinate(lat,lon);
	}

	/**
	 * Returns the name of the city.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the latitude of the city.
	 * @return lat
	 */
	public double getLat() {
		return this.lat;
	}
	
	/**
	 * Returns the longitude of the city.
	 * @return lon
	 */
	public double getLon() {
		return this.lon;
	}
	
	/**
	 * 
	 * @return Coordinate object containing the latitude and 
	 * longitude of the city.
	 */
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
}

