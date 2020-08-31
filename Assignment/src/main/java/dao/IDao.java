package dao;

import java.util.List;

import model.Book;
import model.Library;

public interface IDao {
	
	public void addBook(Book book);
	public Library getLibrary(String libraryName);
	public Book searchBook(int bookId);
	public Book updateBookDetails(int bookId,String bookName,String author,String publisher);
	public void deleteBook(int bookId);
	public List<Book> getAllBooks();

}
