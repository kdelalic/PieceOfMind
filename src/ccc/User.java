package ccc;

import java.util.ArrayList;

public class User {

	private String username;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void addTweetToTweets(Tweet tweet) {
		this.tweets.add(tweet);
	}

	public ArrayList<Tweet> getTweets() {
		return this.tweets;
	}

}