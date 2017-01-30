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


import domain.model.Lend;



@WebServlet("/lendServlet")
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LendServlet() {
   
    }
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Lend lend = new Lend();
		
		HttpSession session = request.getSession();
		
		Date dateOfLend = new Date();
		Date dateOfRegive = new Date();
		try {
			dateOfLend = new SimpleDateFormat("dd-MM-yyyy").parse((String) request.getAttribute("dateOfLend"));
			dateOfRegive = new SimpleDateFormat("dd-MM-yyyy").parse((String) request.getAttribute("dateOfRegive"));	
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		lend.setDateOfLend(dateOfLend);
		lend.setDateOfRegive(dateOfRegive);
		session.setAttribute("lend", lend);
		response.sendRedirect("finalResult.jsp");
	}

}
