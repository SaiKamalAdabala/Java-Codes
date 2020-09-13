package com.cg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.model.Library;
import com.cg.repo.LibraryRepository;


@Service
@Transactional
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepo;
	
	@Autowired
	BookService bookService;
	
	public void addLibrary(Library library) {
		libraryRepo.save(library);
	}
	
	public List<Library> getAllLibrary(){
		return libraryRepo.findAll();
	}
	
	public List<String> getAllLibraryName(){
		return libraryRepo.getAllLibraryname();
	}
	
	public Library getLibraryByName(String name) {
		return libraryRepo.findByLibraryname(name);
	}
	
	public Library findById(int lid) {
		Library lib = libraryRepo.getOne(lid);
		return lib;
	}
}
