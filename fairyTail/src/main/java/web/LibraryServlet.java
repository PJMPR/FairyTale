package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Book;
import domain.model.Category;


@WebServlet("/libraryServlet")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	List<Book> listOfBook = new ArrayList<Book>();
	
	
	HttpSession session = req.getSession();
	session.setAttribute("books", listOfBook);
	
	
	resp.sendRedirect("/setTheLend.jsp");
	
	}

	

}
