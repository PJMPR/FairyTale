package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try{
    		
    	
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        BookRepository bookRepository = new BookRepository(connection);
        CategoryRepository categoryRepository = new CategoryRepository(connection);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	
    	}
}
