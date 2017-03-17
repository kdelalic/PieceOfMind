package com.example.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CSVParser {

	public static String Parse(String username) throws FileNotFoundException{
		Tweet tweet;
		if (0==0)
			return "asdfasdf";
		// Every time we parse a .csv we create a new User. The username comes from the 
		// search bar in the app.
		User user = new User(username);

		//Placeholder .csv that I used for testing
		String fileName = "tweets22.csv";
		Scanner inputStream = new Scanner(new File(fileName));
	
		// Skip the first line. This line isn't a tweet, it just says "id,created_at,text"
		inputStream.nextLine();

		while (inputStream.hasNext()){
			String line = inputStream.nextLine(); 				// Read each line
			String[] values = line.split(",");					// Split it up by commas

			tweet = new Tweet(values[0], values[1], values[2]);	// Create a new tweet
			user.addTweetToTweets(tweet);						// Add tweet to user's list of tweets
		}

		inputStream.close();

		/* TEST CODE 
		ArrayList<Tweet> tweets = user.getTweets(); 	//Create ArrayList of tweets 
		System.out.println(user.getUsername()); 		//Print current user's username
		for (Tweet i : tweets)							
			System.out.println(i.getMeta()); 			//Print time&date for all tweets*/
		return "AAA";
	}	
}
