<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>

    <title>Add Book</title>
  </head>
  <body   bgcolor="CFC3C1">
  <div align="center">
    <h2>Add New Book</h2>
    
  <form action = "addBook" method="post">
  
  Select Library : 
  <select name = "libraryName">
  <c:forEach var = "libNames" items="${libNames}">
  	<option>${libNames}</option>
  </c:forEach>
  </select>
  
  
  <div>
    <label>Book Name :</label>
    <input type="text" name = "bookName">
  </div>
     <br>
     
  <div>
    <label>Book Author :</label>
    <input type="text" name = "Author">
  </div>  
   <br>
   <div>
    <label>Publisher Name :</label>
    <input type="text" name = "publisher">
  </div>
   <br>
  <div>
  	<button type = "submit">ADD Book</button>
  </div>
  </form>
    
 </div>   
  </body>
</html>