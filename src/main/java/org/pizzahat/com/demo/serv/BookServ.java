package org.pizzahat.com.demo.serv;

import java.util.List;

import org.hibernate.Hibernate;
import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BookServ {

	@Autowired
	private BookRepo bookRepo;
	
	public void save(Book book) {
		
		bookRepo.save(book);
	}
	public void delete(Book book) {
		
		bookRepo.delete(book);
	}
	public Book findById(int id) {
		
		return bookRepo.findById(id).get();
	}
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}
	@Transactional
	public List<Book> findAllWBorrowing() {
		
		List<Book> books = bookRepo.findAll();
		
		for (Book book : books) {
			
			Hibernate.initialize(book.getBorrowings());
		}
		
		return books;
	}
}
