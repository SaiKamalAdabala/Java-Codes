package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDao;
import dao.IDaoImpl;
import model.Book;
import model.Library;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDao dao = new IDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String libname = request.getParameter("library");
		Library library = dao.getLibrary(libname);
		 
		Book book = new Book();
		
		book.setLibrary(library);
		book.setBookId(Integer.parseInt(request.getParameter("bid")));
		book.setBookName(request.getParameter("bname"));
		book.setAuthor(request.getParameter("auth"));
		book.setPublisher(request.getParameter("publ"));
		
		dao.addBook(book);
		out.println("Book added");
	}

	}


