package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Library {
	@Id
	private int libraryId;
	private String libraryName;
	@OneToMany
	private List<Book> books;

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Library(int libraryId, String libraryName, List<Book> books) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.books = books;
	}

	public Library() {
		super();
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", books=" + books + "]";
	}
	
	
	
}
