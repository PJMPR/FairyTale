package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Lend lend = new Lend();
		
		HttpSession session = request.getSession();
		lend.setBook((Book) session.getAttribute("book"));
		lend.setReader((Reader) session.getAttribute("reader"));
		String dateOfLendStr = request.getParameter("dateOfLend");
		String dateOfRegiveStr = request.getParameter("dateOfRegive");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		try {
			Date dateOfLend = sdf.parse(dateOfLendStr);
			Date dateOfRegive = sdf.parse(dateOfRegiveStr);
			lend.setDateOfLend(dateOfLend);
			lend.setDateOfLend(dateOfRegive);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		session.setAttribute("lend", lend);
		response.sendRedirect("finalResult.jsp");
	}

}
