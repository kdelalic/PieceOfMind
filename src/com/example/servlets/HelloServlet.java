package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/search")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");

		try {
			out.println("<!DOCTYPE html>");
			out.println("<meta name='viewport' content='width=device-width'>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>" + username + "</title></head>");
			out.println(
					"<link href='https://fonts.googleapis.com/css?family=Raleway:thin|Roboto' rel='stylesheet' type='text/css'/>");
			out.println("<link href='css/style.css' rel='stylesheet' type='text/css'>");
			out.println(
					"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>");
			out.println("<title>Piece of Mind</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<header>");
			out.println("<h1>Piece of Mind</h1>");
			out.println("<small>A web app to check the mental state of Twitter users.</small>");
			out.println("<div class='d5'>");
			out.println("<form method='get' action='search'>");
			out.println("<input type='text' name='username' placeholder='Enter a userID...'>");
			out.println("<button type='submit' action='#' ></button>");
			out.println("</form>");
			out.println("</div>");
			out.println("</header>");

			out.println("<p>Name: " + username + "</p>");

			out.println("</body></html>");
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
