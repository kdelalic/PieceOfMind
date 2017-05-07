package ccc;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser2 {

	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';

	static City city;
	static ArrayList<City> cities;
	
	public static ArrayList<City> parse(String filename) throws FileNotFoundException {
		
		cities = new ArrayList<City>();
		Scanner inputStream = new Scanner(new File(filename));
		inputStream.nextLine();
		
		while (inputStream.hasNext()){
			String line = inputStream.nextLine(); 			
			String[] values = line.split(",");	
			
			city = new City(values[0], Double.parseDouble(values[2]), Double.parseDouble(values[3]));
			cities.add(city);
		}
		
		return cities;
	}
}