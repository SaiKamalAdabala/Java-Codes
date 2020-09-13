 <!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <title>BookManagement</title>
    
  </head>
  <body  bgcolor="CFC3C1">
  <div align="center">
    <h1 >Book Management </h1>

		<a href= "addNewLibrary">Add New Library</a>&nbsp;
		<a href= "addNewBook">Add New Book</a><br><br><br>
		
   </div>
<div>	
<div>
	<table align="center">
  <thead>
    <tr>
      <th> Book Id </th>
      <th> Library Name </th>
      <th> Book Name </th>
      <th> Book Author Name </th>
      <th> Book Publisher Name </th>
      <th> Action </th>
    </tr>
  </thead>
  
  <tbody>
  	<c:forEach var="book" items="${books}">
  	
  		<tr>
  			<td>${book.bookId}</td>
  			<td>${book.library.libraryName }</td>
  			<td>${book.bookName}</td>
  			<td>${book.author}</td>   
  			<td>${book.publisher}</td>
  			<td><a href="getEditBook?id=${book.bookId}">Update</a> &nbsp;
				<a href="deleteBook?id=${book.bookId}">Delete</a>
  			</td>
  		</tr>
  	</c:forEach>
  </tbody>
  </table>
</div>

</div>
  </body>
</html>