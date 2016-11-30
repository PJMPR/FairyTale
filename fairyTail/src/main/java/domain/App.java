package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Book;
import domain.model.Lend;
import domain.model.Location;
import domain.model.Reader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Location location = new Location();
    	location.setCity("Strzebielino");
    	location.setStreet("Dworcowa");
        
        Reader reader = new Reader();
    	reader.setFirstName("Pawel");
    	reader.setLastName("Dering");
    	reader.setEmail("pawel.dee@gmail.com");
    	reader.setPhoneNumber("667685791");
    	reader.setAddress(location);
    	
    	Book book = new Book();
    	book.setAuthor("Tadeusz");
    	book.setDateOfReleased(null);
    	book.setName("Pan Tadeusz");
    	book.setPageCount(234);
    	book.setPublisher("PWN");
    	
    	Lend lend = new Lend();
    	lend.setBook(book);
    	lend.setDateOfLend(null);
    	lend.setDateOfRegive(null);
    	lend.setReader(reader);
    	try{
    
    
     	
    	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		IUnitOfWork uow = new UnitOfWork(connection);
		IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
		//catalog.Location().add(location);
		catalog.Reader().add(reader);
		catalog.Book().add(book);
	
		
		catalog.Lend().add(lend);
		catalog.save();
    	}catch(SQLException e){
    		
    		e.printStackTrace();
    	}
    	
    	}
}
