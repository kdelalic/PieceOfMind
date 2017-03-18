package com.example.servlets;

public class Tweet {

	private String id;
	private String meta;
	private String tweet;
	
	public Tweet(String id, String meta, String tweet){
		this.id = id;
		this.meta = meta;
		this.tweet = tweet;
	}

	public String getID(){
		return this.id;
	}

	public String getMeta(){
		return this.meta;
	}

	public String getTweet(){
		return this.tweet;
	}

/*	public int sentiment(){
		return analyzeSentiment();
	}
*/

}