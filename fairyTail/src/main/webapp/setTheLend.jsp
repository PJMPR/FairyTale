<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="lendServlet"method="get">

<h1>Ustaw date wypożyczenia</h1>
<p>Data Wypożyczenia</p>
<input type="date" name="dateOfLend" value="dateOfLend">
<p>Data oddania</p>
<input type="date" name="dateOfRegive" value="dateOfRegive">
<input type="submit" value="Wypożycz">
</form>
</body>
</html>