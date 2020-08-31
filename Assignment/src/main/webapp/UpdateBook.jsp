<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="CFC3C1">
<h1 align="center">UpdateBook</h1>
<form action="update" method="post">
		Enter Book Id : <input type="text" name="bookId"> 
		<br> <br> 
		Enter Book Name : <input type="text" name="bookName">
		<br> <br> 
		Enter Author Name : <input type="text" name="author"> 
		<br> <br> 
		Enter Publisher Name : <input type="text" name="publisher"> 
		<br> <br> 
		<input type="submit" value="UPDATE">
</form>
</body>
</html>