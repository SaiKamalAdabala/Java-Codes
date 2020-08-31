package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDaoImpl;
import model.Book;

/**
 * Servlet implementation class Add
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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


