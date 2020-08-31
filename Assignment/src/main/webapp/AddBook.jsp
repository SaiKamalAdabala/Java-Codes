<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="CFC3C1">
<h1 align="center">AddBook</h1>
<form action="add" method="post">

		Select Library : <select name="library" id="library">
			<option value="Mathematics">Mathematics</option>
			<option value="Physics">Physics</option>
			<option value="Chemistry">Chemistry</option>
			<option value="Literature">Literature</option>
		</select> 
		Book Id : <input type="text" name="bookId"> <br>
		<br> Book Name : <input type="text" name="bookName"> <br>
		<br> Author : <input type="text" name="author"> <br>
		<br> Publisher : <input type="text" name="publisher"> <br>
		<br> <input type="submit" value="ADD">
</form>

</body>
</html>