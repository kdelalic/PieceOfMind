package ccc;

public class Tweet {
	
	private String name;
	private String meta;
	private String location;
	private String tweet;
	private int score;
	private String[] analysis = new String[4];

	public Tweet(String name, String meta, String location, String tweet) {
		this.name = name;
		this.meta = meta;
		this.location = location;
		this.tweet = tweet;
	}

	public Tweet(String name, String meta, String location, String tweet, int score) {
		this.name = name;
		this.meta = meta;
		this.location = location;
		this.tweet = tweet;
		this.score = score;
	}
	
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

	public String getName(){
		return this.name;
	}

	public String getMeta() {
		return this.meta;
	}

	public String getLocation() {
		return this.location;
	}

	public String getTweet() {
		return this.tweet;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String[] getAnalysis() {
		return this.analysis;
	}

}