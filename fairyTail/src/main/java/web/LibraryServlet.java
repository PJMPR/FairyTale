package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domain.model.Book;



@WebServlet("/libraryServlet")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();	

		Book book = new Book();
	
		//book = (Book)req.getParameter("book");
	
	
	session.setAttribute("book", book);
	
	
	resp.sendRedirect("setTheLend.jsp");
	
	}

	

}
