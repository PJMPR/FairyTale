package web;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

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
	List<Book> listOfBook = new ArrayList<Book>();
	Book book = new Book();
		book = (Book) session.getAttribute("book");
	
	
	session.setAttribute("books", listOfBook);
	
	
	resp.sendRedirect("setTheLend.jsp");
	
	}

	

}
