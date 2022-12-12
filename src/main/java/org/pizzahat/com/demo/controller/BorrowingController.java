package org.pizzahat.com.demo.controller;

import java.util.List;

import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.pojo.Borrowing;
import org.pizzahat.com.demo.serv.BookServ;
import org.pizzahat.com.demo.serv.BorrowingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/borrowing")
public class BorrowingController {

	@Autowired
	private BorrowingServ borrowingServ;
	
	@Autowired
	private BookServ bookServ;
	
	@GetMapping
	public String getBorrowings(Model model) {
		
		List<Borrowing> borrowings = borrowingServ.findAll();
		model.addAttribute("borrowings", borrowings);
		
		return "borrowings";
	}
	@GetMapping("/create")
	public String createBorrowing(Model model) {
		
		Borrowing borrowing = new Borrowing();
		model.addAttribute("borrowing", borrowing);
		
		List<Book> books = bookServ.findAll();
		model.addAttribute("books", books);
		
		return "borrowing-create";
	}
	@PostMapping("/store")
	public String storeBorrowing(@Valid Borrowing borrowing) {
		
		System.err.println(borrowing + "\n\t" + borrowing.getBook());
		
		borrowingServ.save(borrowing);
		
		return "redirect:/borrowing";
	}
}
