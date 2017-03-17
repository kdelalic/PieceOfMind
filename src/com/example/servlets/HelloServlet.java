package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	// doPost requires a GET to collect the relevant information from the dataset. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
		doGet(request, response);
	}
	
	// doGet handles the GET (finding the data) and POST (displaying the data) for now. 
	// In the future maybe we should put the POST stuff in the post method above ^.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		
		//Our placeholder search. Later "returnArray" will be filled with all data 
		//from the dataset that we want to display.
		String returnArray[] = sampleSearch.search(username);
		try {
			
			// Any code that is reused should be kept in the Template.java file.
			out.println(Template.createHeader(username));
			
			// Information unique to each search (the important stuff, basically).
			out.println("<p>Username: " + username + "</p>");
			out.println("<p>Display Name: " + returnArray[3] + "</p>");
			out.println("<p>Tweet: '" + returnArray[2] + "'</p>");
			out.println("<p>Time: " + returnArray[1] + "</p>");
			out.println("<p>Location: " + returnArray[0] + "</p>");
			out.println("<p>Sentiment Analysis Results: " + returnArray[4] + ", " + 
			  returnArray[5] + ", " + returnArray[6] + ", " + returnArray[7] + "</p>");
			
			// The footer template that is reused on every page.
			out.println(Template.createFooter());
		
		} finally {
			out.close();
		}
	}
}