package com.example.servlets;


// Placeholder that simulates a search result from our dataset.
public class sampleSearch {
	public static String[] search(String username) {
		String[] john = { "Bangalore,India", "2012-07-01 14:44:33",
				"Lazy rule: As soon as I get under the blankes covers. All of my today's responsibilites, becomes tomorrow problems.",
				"john123", "-0.25", "0", "0", "0" };
		if (username.equals("john")) {
			return john;
		}
		return null;
	}
}
