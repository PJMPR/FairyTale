<%@page import="dao.repositories.IRepositoryCatalog"%>
<%@page import="dao.repositories.IRepository"%>
<%@page import="dao.uow.IUnitOfWork"%>
<%@page import="dao.uow.UnitOfWork"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat" %>
    <%@ page import="domain.model.Book" %>
    <%@page import="dao.RepositoryCatalog" %>
    <%@page import="domain.App" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form  action="libraryServlet" method="get">
                
                    <p>Choose Book</p>
                          <%
                          try {
                         
                         	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
                     		IUnitOfWork uow = new UnitOfWork(connection);
                     		IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
                            List<Book> books = catalog.Book().getAll(); 
                             for(Book book: books)
                             {
                         %>
                  
                         <input type="checkbox" name="book" value="<%book.getClass();%>"><%book.getName();%>
                         
                          <%
                             }
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                          %>
                          <input type="submit" value="Wypożycz">
                    </form>
</body>
</html>