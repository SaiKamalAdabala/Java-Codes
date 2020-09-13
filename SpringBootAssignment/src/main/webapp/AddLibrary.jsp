<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>ADD Library</title>
</head>
<body   bgcolor="CFC3C1">
<div align="center">

	<h2>Add New Library</h2>	
		
	<form action = "addLib" method="post" >
  <div>
    <label>Enter Library Name : </label>
    <input type="text"id="libName" name= "libraryName" placeholder="Enter Library name">
  </div>
  	<br>
  <div>
  	<button type = "submit">ADD</button>
  </div>
  </form>
  
</div>
</body>
</html>