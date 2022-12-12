package org.pizzahat.com.demo.serv;

import java.util.List;

import org.pizzahat.com.demo.pojo.Borrowing;
import org.pizzahat.com.demo.repo.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingServ {

	@Autowired
	private BorrowingRepo borrowingRepo;
	
	public void save(Borrowing borrowing) {
		
		borrowingRepo.save(borrowing);
	}
	public void delete(Borrowing borrowing) {
		
		borrowingRepo.delete(borrowing);
	}
	public Borrowing findById(int id) {
		
		return borrowingRepo.findById(id).get();
	}
	public List<Borrowing> findAll() {
		
		return borrowingRepo.findAll();
	}
}
