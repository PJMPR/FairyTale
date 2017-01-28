<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Type your name</title>
</head>
<body>
 <form action="ReaderServlet" method="get">
 	<h1>Podaj dane czytelnika </h1>
    <p> Imie </p><br/>
    <input name="firstName" ><br/>
    <p> Nazwisko </p><br/>
    <input name="lastName"> <br/>
    <p> Email </p><br/>
    <input name="email"> <br/>
    <p> Numer Telefonu </p><br/>
    <input type="number" name="phoneNumer"> <br/>
    <input type="submit" value="wyślij" >
    
    
 
 </form>
</body>
</html>