package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

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
import domain.model.Lend;
import domain.model.Reader;


@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DbServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IUnitOfWork uow = new UnitOfWork(connection);
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			HttpSession session = request.getSession();
			Reader reader = (Reader) session.getAttribute("reader");
			Book book = (Book) session.getAttribute("book");
			catalog.Reader().add(reader);
			catalog.Book().add(book);
			catalog.save();
			Lend lend = new Lend();
			lend.setBook(book);
			lend.setDateOfLend((Date) session.getAttribute("dateOfLend"));
			lend.setDateOfRegive((Date) session.getAttribute("dateOfRegive"));
			lend.setReader(reader);
			catalog.Lend().add(lend);
			catalog.save();
			session.removeAttribute("location");
			session.removeAttribute("book");
			session.removeAttribute("reader");
			session.removeAttribute("dateOfLend");
			session.removeAttribute("dateOfRegive");
			response.sendRedirect("index.html");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	

	

}
