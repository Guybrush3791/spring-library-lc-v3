package org.pizzahat.com.demo.controller;

import java.util.List;

import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.pojo.Category;
import org.pizzahat.com.demo.serv.BookServ;
import org.pizzahat.com.demo.serv.CategoryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServ categoryServ;
	
	@Autowired
	private BookServ bookServ;
	
	@GetMapping
	public String getCategories(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories", categories);
		
		return "categories";
	}
	
	@GetMapping("/create")
	public String createCategory(Model model) {
		
		Category category = new Category();
		model.addAttribute("category", category);
		
		List<Book> books = bookServ.findAll();
		model.addAttribute("books", books);
		
		return "category-create";
	}
	
	@PostMapping("/create")
	public String storeCategory(@Valid Category category) {
		
//		System.out.println(category);
//		if (category.getBooks() != null)
//			for (Book b : category.getBooks()) {
//				System.out.println("\t" + b);
//				for (Category c : b.getCategories()) 
//					System.out.println(c);				
//			}
		
		List<Book> books = category.getBooks();
		for (Book b : books) {
			
			b.getCategories().add(category);
		}
		
		categoryServ.save(category);
		
		return "redirect:/category/create";
	}
}
