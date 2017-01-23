<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Type your name</title>
</head>
<body>
 <form action="ReaderServlet" method="get">
 	<h1>Podaj dane czytelnika </h1>
    <p> Imie </p><br/>
    <input value="firstName" ><br/>
    <p> Nazwisko </p><br/>
    <input value="lastName"> <br/>
    <p> Email </p><br/>
    <input value="email"> <br/>
    <p> Numer Telefonu </p><br/>
    <input value="phoneNumer"> <br/>
    <input type="submit" value="wyślij" >
    
    
 
 </form>
</body>
</html>