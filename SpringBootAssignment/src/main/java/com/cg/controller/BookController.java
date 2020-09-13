package com.cg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.model.Book;
import com.cg.model.Library;
import com.cg.service.BookService;
import com.cg.service.LibraryService;

@Controller
public class BookController {
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String getAllLib(Model model) {
		List<Library> libraries = libraryService.getAllLibrary();
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("libs", libraries);
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@RequestMapping("/addNewLibrary")
	public String getAddLibrary() {
		return "AddLibrary.jsp";
	}
	
	@RequestMapping(value = "/addLib" , method = RequestMethod.POST )
	public String addLibrary(@ModelAttribute Library library) {
		libraryService.addLibrary(library);
		return "redirect:/";
	}
	
	@RequestMapping("/addNewBook")
	public String getAddBook(Model model) {
		 List<String> libNames = libraryService.getAllLibraryName();
		 model.addAttribute("libNames", libNames);
		return "AddBook.jsp";
	}
	
	@RequestMapping(value = "/addBook" ,method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book,@RequestParam("libraryName") String lname) {
		
		Library library = libraryService.getLibraryByName(lname);
		book.setLibrary(library);
		bookService.addBook(book);
		
		return "redirect:/";
	}
	
	@RequestMapping("/getEditBook")
	public String getEditBook(@RequestParam("id") int bid,Model model) {
		Book book = bookService.findByBookId(bid);
		model.addAttribute("b", book);
		return "EditBook.jsp";
		
	}
	
	@RequestMapping(value = "/editBook" ,method = RequestMethod.POST)
	public String editBook(@ModelAttribute Book book) {
		bookService.updateBook(book);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int bid) {
		bookService.deleteBookById(bid);
		return "redirect:/";
	}
	
	
}
