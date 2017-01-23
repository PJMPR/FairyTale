<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat" %>
    <%@ page import="domain.model.Book" %>
    <%@page import="dao.RepositoryCatalog" %>
    <%@page import="domain.App" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form  enctype="text/plain">
                <div>
                    <p>Wybierz książkę</p>
                    </br>
                    <select name="books">
                        <%
                        try {
                           RepositoryCatalog rp = new RepositoryCatalog(App.CONNECTION_STRING);
                           List<Book> books = 
                           for(Book book: books){
                        %><ul>
  							 <li> <%book.getId();%></li>
							  <li><%book.getName();%></li>
 							 <li><%book.getAuthor();%></li>
 							 <li> <%book.getCategory();%></li>
							  <li><%book.getPublisher();%></li>
 							 <li><%book.getPageCount();%></li>
						</ul>
                        <%
                           }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>

                    </select> </br>
                    Podaj wartosc</br>
</body>
</html>