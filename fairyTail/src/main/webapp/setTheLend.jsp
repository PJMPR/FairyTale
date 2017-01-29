<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="post">

<p>Data Wypożyczenia</p>
<input type="date" value="dateOfLend">
<p>Data oddania</p>
<input type="date" value="dateOfRegive">
<input type="submit" formaction="LendServlet" value="Wypożycz">
<input type="submit" value="dalej">
</form>
</body>
</html>