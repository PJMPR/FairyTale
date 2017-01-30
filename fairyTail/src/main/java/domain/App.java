package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Book;
import domain.model.Category;
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
        
      /*  Reader reader = new Reader();
    	reader.setFirstName("Pawel");
    	reader.setLastName("Dering");
    	reader.setEmail("pawel.dee@gmail.com");
    	reader.setPhoneNumber("667685791");
    	reader.setAddress(location);

    	
    	Book book = new Book();
    	book.setAuthor("Tadeusz");
    	book.setDateOfReleased(null);
    	book.setCategory(Category.fantasy);
    	book.setName("Pan Tadeusz");
    	book.setPageCount(234);
    	book.setPublisher("PWN");
    	
    	Book book2 = new Book();
    	book2.setAuthor("Jo Nesbo");
    	book2.setDateOfReleased(null);
    	book2.setCategory(Category.fantasy);
    	book2.setName("Łowcy Głów");
    	book2.setPageCount(234);
    	book2.setPublisher("PWN");
    	
    	Book book3 = new Book();
    	book3.setAuthor("Simon Beckett");
    	book3.setDateOfReleased(null);
    	book3.setCategory(Category.fantasy);
    	book3.setName("Chemia Śmierci");
    	book3.setPageCount(234);
    	book3.setPublisher("PWN");
    	
    	Book book4 = new Book();
    	book4.setAuthor("Trudi Cavani");
    	book4.setDateOfReleased(null);
    	book4.setCategory(Category.fantasy);
    	book4.setName("Nowicjuszka");
    	book4.setPageCount(234);
    	book4.setPublisher("PWN");
    	
    	Book book5 = new Book();
    	book5.setAuthor("Kentarou Miura");
    	book5.setDateOfReleased(null);
    	book5.setCategory(Category.fantasy);
    	book5.setName("Berserker");
    	book5.setPageCount(234);
    	book5.setPublisher("JPF");
    	
    	Book book6 = new Book();
    	book6.setAuthor("CJ Sansom");
    	book6.setDateOfReleased(null);
    	book6.setCategory(Category.fantasy);
    	book6.setName("Rebelia");
    	book6.setPageCount(234);
    	book6.setPublisher("PWN");
    	
    	Lend lend = new Lend();
    	lend.setBook(book);
    	lend.setDateOfLend(null);
    	lend.setDateOfRegive(null);
    	lend.setReader(reader);*/
    	try{
    
    
     	
    	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		IUnitOfWork uow = new UnitOfWork(connection);
		IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
		catalog.Location().add(location);
		/*catalog.Reader().add(reader);
		catalog.Book().add(book);
		catalog.Book().add(book2);
		catalog.Book().add(book3);
		catalog.Book().add(book4);
		catalog.Book().add(book5);
		catalog.Book().add(book6);
		
	
		
		catalog.Lend().add(lend);*/
		catalog.save();
    	}catch(SQLException e){
    		
    		e.printStackTrace();
    	}
    	
    	}
}
