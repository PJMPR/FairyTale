package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Reader;


@WebServlet("/ReaderServlet")
public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Reader reader = new Reader();
		reader.setFirstName(request.getParameter("firstName"));
		reader.setLastName(request.getParameter("lastName"));
		reader.setEmail(request.getParameter("email"));
		reader.setPhoneNumber(request.getParameter("phoneNumer"));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("reader", reader);
		
		response.sendRedirect("/chooseBookFromLibrary.jsp");
	}

	

}
