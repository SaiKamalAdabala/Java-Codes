package com.cg.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("select b from Book b,Library l where b.library = l.libraryId and b.library.libraryId = :lid")
	List<Book> deleteAllBookByLibraryId(@Param("lid")int lid);
}
