package com.example.servlets;

public class Template {

	// Creates the header template to be used on every page.
	public static String createHeader(String username) {

		return "<!DOCTYPE html>" + "\n<meta name='viewport' content='width=device-width'>" + "\n<meta charset='utf-8'>"
				+ "\n<head>"
				+ "\n<link href='https://fonts.googleapis.com/css?family=Raleway:thin|Roboto' rel='stylesheet' type='text/css'/>"
				+ "\n<link href='css/styles.css' rel='stylesheet' type='text/css'>"
				+ "\n <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>"
				+ "\n <title>Piece of Mind</title>" + "\n </head>" + "\n <body>" + "\n <header>"
				+ "\n <h1>Piece of Mind</h1>" + "\n <p>A web app to check the mental state of Twitter users.</p>"
				+ "\n <div class='d5'>" + "\n <form method='get' action='search'>"
				+ "\n <input type='text' name='username' placeholder='Enter a userID...'>"
				+ "\n <button type='submit' action='#' ></button>" + "\n </form>" + "\n </div>" + "\n </header>";
	}

	// Creates a footer template to be used on every page.
	public static String createFooter() {
		return "</body></html>";
	}

}