package ccc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class Home extends HttpServlet {
	
	/**
	 * Code for the root of the web application ("/"). 
	 * @param request Information containing the request made to the application
	 * @param response Information used to pass a response to the user
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// When the user makes a request for the root of the application, redirect them to
		// Home.jsp.
		request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
	}

}
