package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.model.Book;
import com.cg.repo.BookRepository;


@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book findByBookId(int bid) {
		Book book = bookRepo.getOne(bid);
		return book;
	}
	
	public void updateBook(Book b) {
		Book oldbook = bookRepo.getOne(b.getBookId());
		b.setLibrary(oldbook.getLibrary());
		bookRepo.save(b);
	}
	
	public void deleteBookById(int bid) {
		bookRepo.deleteById(bid);
	}
	
	public void deleteBookByLibId(int lid) {
		List<Book> booksList = bookRepo.deleteAllBookByLibraryId(lid);
		
		for(Book b : booksList) {
			bookRepo.delete(b);
		}
	}
}
