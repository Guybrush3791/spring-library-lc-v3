package org.pizzahat.com.demo.controller;

import java.util.List;

import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.pojo.Borrowing;
import org.pizzahat.com.demo.pojo.Category;
import org.pizzahat.com.demo.serv.BookServ;
import org.pizzahat.com.demo.serv.BorrowingServ;
import org.pizzahat.com.demo.serv.CategoryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookServ bookServ;
	
	@Autowired
	private BorrowingServ borrowingServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	@GetMapping
	public String getBooks(Model model) {
		
		List<Book> books = bookServ.findAll();
		model.addAttribute("books", books);
		
		return "books";
	}
	@GetMapping("/create")
	public String createBook(Model model) {
		
		Book book = new Book(); 
		model.addAttribute("book", book);
		
		List<Borrowing> borrowings = borrowingServ.findAll();
		model.addAttribute("borrowings", borrowings);

		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories", categories);
		
		return "book-create";
	}
	@PostMapping("/store")
	public String storeBook(
				@Valid Book book
			) {
		
//		System.err.println(book);
//		if (book.getBorrowings() != null)
//			for (Borrowing borrowing : book.getBorrowings()) {
//				
//				System.err.println("\t" + borrowing);
//			}
//		else 
//			System.err.println("- no borrowing -");
		
		List<Borrowing> bookBorrowing = book.getBorrowings();
		for(Borrowing borrowing : bookBorrowing) {
			
			borrowing.setBook(book);
		}
		
		bookServ.save(book);
		
		return "redirect:/book";
	}
}
