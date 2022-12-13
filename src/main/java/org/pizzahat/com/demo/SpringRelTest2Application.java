package org.pizzahat.com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.pojo.Borrowing;
import org.pizzahat.com.demo.pojo.Category;
import org.pizzahat.com.demo.serv.BookServ;
import org.pizzahat.com.demo.serv.BorrowingServ;
import org.pizzahat.com.demo.serv.CategoryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRelTest2Application implements CommandLineRunner {

	@Autowired
	private BookServ bookServ;
	
	@Autowired
	private BorrowingServ borrowingServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRelTest2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category("cat1", "desc cat1");
		Category cat2 = new Category("cat2", "desc cat2");
		Category cat3 = new Category("cat3", "desc cat3");
		Category cat4 = new Category("cat4", "desc cat4");
		
		categoryServ.save(cat1);
		categoryServ.save(cat2);
		categoryServ.save(cat3);
		categoryServ.save(cat4);
		
		List<Category> catBook1 = Arrays.asList(new Category[] {
				cat1,
				cat2
		});		
		Book b1 = new Book("libro 1", catBook1);
		
		List<Category> catBook2 = Arrays.asList(new Category[] {
				cat1,
				cat3
		});	
		Book b2 = new Book("libro 2",  catBook2);
		
		Book b3 = new Book("libro 3");
		
//		DANGER: relazione NON valorizzata!!
//		-----------------------------------
//		List<Book> newCatBook = Arrays.asList(new Book[] {
//				b1, b3
//		});
//		Category newCat = new Category("new cat", "new desc cat", newCatBook);
//		categoryServ.save(newCat);
		
		bookServ.save(b1);
		bookServ.save(b2);
		bookServ.save(b3);
		
		Borrowing br1 = new Borrowing("prestito 1", b1);
		Borrowing br2 = new Borrowing("prestito 2", b2);
		Borrowing br3 = new Borrowing("prestito 3", b2);
		
		borrowingServ.save(br1);
		borrowingServ.save(br2);
		borrowingServ.save(br3);
		
//		System.out.println("-----------------------------------------------------------");
//		
//		Borrowing delBorrowing = borrowingServ.findById(1);
//		borrowingServ.delete(delBorrowing);
//		
//		List<Borrowing> borrowings = borrowingServ.findAll();
//		for (Borrowing br : borrowings) {
//			
//			System.err.println(br + "\n\t" + br.getBook());
//		}
//		
//		System.out.println("-----------------------------------------------------------");
//		
////		Book delBook = bookServ.findById(2);
////		bookServ.delete(delBook);
//		
//		List<Book> books = bookServ.findAllWBorrowing();
//		for (Book b : books) {
//			
//			System.err.println(b);
//			
//			for (Borrowing br : b.getBorrowings()) {
//				
//				System.err.println("\t" + br);
//			}
//		}
//		
//		System.out.println("-----------------------------------------------------------");
	}
}











