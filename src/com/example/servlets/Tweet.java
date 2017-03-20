package com.example.servlets;

public class Tweet {

	private String location;
	private String meta;
	private String tweet;
	private String[] analysis = new String[4];

	public Tweet(String location, String meta, String tweet, String analysis0, String analysis1, String analysis2,
			String analysis3) {
		this.location = location;
		this.meta = meta;
		this.tweet = tweet;
		this.analysis[0] = analysis0;
		this.analysis[1] = analysis1;
		this.analysis[2] = analysis2;
		this.analysis[3] = analysis3;
	}

	public String getLocation() {
		return this.location;
	}

	public String getMeta() {
		return this.meta;
	}

	public String getTweet() {
		return this.tweet;
	}

	public String[] getAnalysis() {
		return this.analysis;
	}

}