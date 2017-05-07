package ccc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class UserAnalysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserAnalysis() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String CSVFile = "sortedTweets.csv";

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");


		ArrayList<User> sortedCSV = sortCSV.sort(CSVParser.parse(CSVFile));
		ArrayList<Tweet> userTweets = null;

		if (SearchUsername.rank(username, sortedCSV) != -1) {
			userTweets = sortedCSV.get(SearchUsername.rank(username, sortedCSV)).getTweets();
		}
		
	
		try {

			if (SearchUsername.rank(username, sortedCSV) == -1) {
				out.println(Template.createHeader(username, userTweets));
				out.println("<p>ERROR: USERNAME NOT FOUND</p>");
				out.println(Template.createFooter());
			} else {

				// Any code that is reused should be kept in the Template.java
				// file.
				out.println(Template.createHeader(username, userTweets));

				out.println("<div id='tweetCon'>");

				// Information unique to each search (the important stuff,
				// basically).
				out.println("<p>Username: " + username + "</p>");
				for (int i = 0; i < userTweets.size(); i++) {
					out.println("<p>Tweet: '" + userTweets.get(i).getTweet() + "' at " + userTweets.get(i).getMeta()
							+ " in " + userTweets.get(i).getLocation() + "</p>");
					out.println("<p>Sentiment Analysis Results: " + userTweets.get(i).getAnalysis()[0] + ", "
							+ userTweets.get(i).getAnalysis()[1] + ", " + userTweets.get(i).getAnalysis()[2] + ", "
							+ userTweets.get(i).getAnalysis()[3] + "</p>");
				}
				out.println("</div>");
				// The footer template that is reused on every page.
				out.println(Template.createFooter());
			}

		} finally {
			out.close();
		}
	}
}