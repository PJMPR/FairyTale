package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Book;
import domain.model.Lend;
import domain.model.Reader;


@WebServlet("/lendServlet")
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LendServlet() {
   
    }
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Lend lend = new Lend();
		lend.setDateOfLend((Date) request.getAttribute("dateOfLend"));
		lend.setDateOfRegive((Date) request.getAttribute("dateOfRegive"));
		lend.setReader((Reader) request.getAttribute("reader"));
		lend.setBook((Book) request.getAttribute("book"));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("lend", lend);
		doGet(request, response);
	}

}
