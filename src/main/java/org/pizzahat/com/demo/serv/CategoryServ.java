package org.pizzahat.com.demo.serv;

import java.util.List;

import org.pizzahat.com.demo.pojo.Category;
import org.pizzahat.com.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public void save(Category category) {
		
		categoryRepo.save(category);
	}
	public void delete(Category category) {
		
		categoryRepo.delete(category);
	}
	public Category findById(int id) {
		
		return categoryRepo.findById(id).get();
	}
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
}
