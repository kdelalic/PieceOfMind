package ccc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * Main control code for the second page of the Piece of Mind application. 
 * 
 * Organizes small dataset of cities in the USA into a LinearProbingHashST, sets up 
 * twitter4j library and prepares to listen to the Twitter stream API. Listens for new tweets 
 * to be made about a given topic, filters, and stores them for later analysis and graphing.
 */

@WebServlet(urlPatterns = "/Page2")
public class Page2 extends HttpServlet {
	
	/**
	 * All code that happens when the user makes a GET request to the second page of Piece of Mind.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Store the user's search query into a variable for future use.
		String query = request.getParameter("query");
		request.setAttribute("query", query);
		
		// Parse American cities into an ArrayList.
		ArrayList<City> cities = CSVParser2.parse("convertcsv.csv");
		
		// Create hash table.
		LinearProbingHashST<String, Coordinate> hashTable = new LinearProbingHashST<String, Coordinate>(1100);
		
		// Store cities and their location information into the hash table.
		for (City c : cities){
			hashTable.put(c.getName(), c.getCoordinate());
		}
		
		// Set up configuration for accessing the Twitter streaming API.
		ConfigurationBuilder cf = new ConfigurationBuilder();	
		cf.setDebugEnabled(true)
			.setOAuthConsumerKey("SaMDPKB1DCU5IeRlJKYiE9cqR")
			.setOAuthConsumerSecret("0aYuYEdKOxFsLK9pOh1qKwz9xq7pu9Nx3nQcocz3TbKtDUVEaO")
			.setOAuthAccessToken("822497455132577792-4dSnEvOC0rwngLbNASFAZFWl86EE0aX")
			.setOAuthAccessTokenSecret("RD8vp9P7An4bTjKxYVYN0FH6kxUv0FemYbo435PKJM9R9");
		
		// Listen for new tweets to be made
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	        	
	        	// If the tweet comes from the USA
	        	if (status.getPlace()!=null && status.getPlace().getCountryCode().equals("US")){
	        		
	        		// Create a new tweet object
	        		Tweet tweet = new Tweet(status.getUser().getName().toString(), 
	        				status.getCreatedAt().toString().substring(4,19),
	        				status.getPlace().getName().toString(), 
	        				status.getText());
	        		
	        		// If information about the city of the new tweet is contained in the hash table
	        		// set up previously
		        	if (hashTable.contains(tweet.getLocation())){}
		        		
		        		/*
		        		 * Issues with Javascript prevented the code from this section from working. 
		        		 * See the Final Project report for a detailed overview.
		        		 * 
		        		 * From here each tweet should be graphed and added live onto the javascript map 
		        		 * of the united states. The goal was to visualize incoming tweets live by mapping
		        		 * their location data onto a map of the united states.
		        		 * 
		        		 */
		        	
	        	} 	
	        }
	        
	        // Handles potential errors and exceptions with the Twitter API.
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) { ex.printStackTrace(); }
			public void onScrubGeo(long arg0, long arg1) {}
			public void onStallWarning(StallWarning arg0) {}
	    };
	    
	    // Set up the stream API listener.
	    TwitterStream twitterStream = new TwitterStreamFactory(cf.build()).getInstance();
	    twitterStream.addListener(listener);
	
	    // Begin listening for new tweets containing the user's query in their body.
	    twitterStream.filter(query);
	    
	    
	    /*
	     * Placeholder code for the javascript map mentioned above. Adding the tweet and location data
	     * onto the map in real time was too much of a challenge for our level of experience. As a placeholder, 
	     * random location information is generated to provide a demo. 
	     * 
	     * See Final Project report for more information.
	     */
	    
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head><meta charset='utf-8' /><title></title><meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' /><script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.js'></script>    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,600,700,800,900\" rel=\"stylesheet\"><link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.css' rel='stylesheet' /><style>body { margin:0; padding:0; }#map { position:absolute; top:0; bottom:0; width:100%; }</style></head><body><div style=\"background: #fff;position: absolute; z-index: 1;top: 10px;right: 10px;border-radius: 5px; width: 300px;text-align:center;height: 700px;color:#647578;font-family: 'Montserrat', sans-serif;font-size:2rem;\"><p>Piece of Mind</p><p style=\"font-size:1.35rem;\">Live Tweet Map</p></div><div id='map'></div><script>mapboxgl.accessToken = 'pk.eyJ1IjoiYmVubmV0YXciLCJhIjoiY2oxM28yZWdhMDFkMTMycDhxOXh1MWM5bSJ9.0pToIXWPpQnmlqZVjQwSgQ';var map = new mapboxgl.Map({    container: 'map',   style: 'mapbox://styles/mapbox/light-v9', center: [-99.11,39.2], });map.on('load', function () {map.addLayer({\"id\": \"points\",\"type\": \"symbol\",\"source\": {\"type\": \"geojson\",\"data\": {\"type\": \"FeatureCollection\",\"features\": [");
		
		Random rand = new Random();
		
		for (int i=0;i<75;i++){	

				double lat = rand.nextDouble() * (-78 + 124) - 124; 
				double lon = rand.nextDouble() * (48 - 30) + 30; 
				
				if (lat < -116 && lon < 38){
					lat = -77.0323;
					lon = 38.91318;
				}
				
				if (lat > -81 && lon < 35){
					lat = -77.0323;
					lon = 38.91318;
				}
				
				out.println("{"+
	                    "\"type\": \"Feature\","+
	                    "\"geometry\": {"+
	                        "\"type\": \"Point\","+
	                        "\"coordinates\": ["+ lat +","+ lon +"]"+
	                    "},"+
	                    "\"properties\": {"+
	                        
	                        "\"icon\": \"circle\""+
	                    "}"+
	                "}, ");	
		}
		
		out.println("{\"type\": \"Feature\",\"geometry\": {\"type\": \"Point\",\"coordinates\": [-122.414, 37.776]},\"properties\": {\"icon\": \"circle\"}}]}},\"layout\": {\"icon-image\": \"{icon}-15\",\"text-field\": \"{title}\",\"text-font\": [\"Open Sans Semibold\", \"Arial Unicode MS Bold\"],\"text-offset\": [0, 0.6],\"text-anchor\": \"top\"}});});</script></body></html>");
	}
	
}