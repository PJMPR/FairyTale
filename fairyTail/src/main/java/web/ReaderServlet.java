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

import domain.model.Location;
import domain.model.Reader;


@WebServlet("/readerServlet")
public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Location location= new Location();
		
		
		location.setCity(request.getParameter("city"));
		location.setStreet(request.getParameter("street"));
		List<Location> locations = (List<Location>) session.getAttribute("location");
	    	if(locations == null)
	    	{
	    		locations = new ArrayList<Location>();
	    		locations.add(location);
	            session.setAttribute("locations",locations);
	    	}
	    	else 
	    	{
	    		locations.add(location);
	    	}

	
		session.setAttribute("location", location);
		
		Reader reader = new Reader();
		reader.setFirstName(request.getParameter("firstName"));
		reader.setLastName(request.getParameter("lastName"));
		reader.setEmail(request.getParameter("email"));
		reader.setPhoneNumber(request.getParameter("phoneNumer"));
		reader.setLocation((Location) request.getAttribute("location"));
		
		
		session.setAttribute("reader", reader);
		
		response.sendRedirect("chooseBookFromLibrary.jsp");
	}

	

}
