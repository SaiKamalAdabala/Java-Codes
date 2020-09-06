package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.dao.IDaoImpl;
import com.cg.model.Book;
import com.cg.model.Library;

@Controller
public class CrudController{
	
	IDaoImpl dao= new IDaoImpl();
	
	
//	@RequestMapping("/add")
//	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		
//		
//		String libname = request.getParameter("library");
//		Library library = dao.getLibrary(libname);
//		 
//		Book book = new Book();
//		
//		book.setLibrary(library);
//		book.setBookId(Integer.parseInt(request.getParameter("bid")));
//		book.setBookName(request.getParameter("bname"));
//		book.setAuthor(request.getParameter("auth"));
//		book.setPublisher(request.getParameter("publ"));
//		
//		dao.addBook(book);
//		out.println("Book added");
//		
//	}
	
	@RequestMapping("/add")
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
       
       
        String libname = request.getParameter("library");
        Library library = dao.getLibrary(libname);
        
        Book b = new Book();
       
        b.setLibrary(library);
       // b.setBookId(Integer.parseInt(request.getParameter("bid")));
        b.setBookName(request.getParameter("bname"));
        b.setAuthor(request.getParameter("auth"));
        b.setPublisher(request.getParameter("publ"));
       
        dao.addBook(b);
        out.println("added book to db");
       
       
    }
	
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		dao.deleteBook(Integer.parseInt(request.getParameter("delbookid")));
		out.println("Book Deleted");
		
	}
	
	

	@RequestMapping("/find")
	public void find(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Book book = dao.searchBook(Integer.parseInt(request.getParameter("getbid")));
		if(book!=null)
		{
			out.println("Book Id : "+book.getBookId());
			out.println("Book Name : "+book.getBookName());
			out.println("Author of Book : "+book.getAuthor());
			out.println("Publisher of Book : "+book.getPublisher());
		}
		else {
			out.println("enter valid book");
		}
	}
	
	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		IDaoImpl dao = new IDaoImpl();
		
		int bookId = Integer.parseInt(request.getParameter("updatebId"));
		Book book=dao.searchBook(bookId);

		String updatedBookName = request.getParameter("updateBName");
		String updatedAuth = request.getParameter("updateAuth");
		String updatedPub = request.getParameter("updatePub");

		out.println("<html>");
		out.println("<body>");

		out.println("Before Update");
		out.print("<br>");
		out.print("<br>");
		out.println("Book Name : " + book.getBookName());
		out.print("<br>");
		out.println("Book Author : " + book.getAuthor());
		out.print("<br>");
		out.println("Book Publisher Name : " + book.getPublisher());
		out.print("<br>");
		Book updateBook = dao.updateBookDetails(bookId, updatedBookName, updatedAuth, updatedPub);
		out.println("Book Name : " + updateBook.getBookName());
		out.print("<br>");
		out.println("Book Author : " + updateBook.getAuthor());
		out.print("<br>");
		out.println("Book Publisher Name : " + updateBook.getPublisher());
		out.print("<br>");

		out.println("</body>");
		out.println("</html>");
	}
	}
	


