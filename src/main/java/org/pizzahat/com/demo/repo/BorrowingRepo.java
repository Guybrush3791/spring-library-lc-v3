package org.pizzahat.com.demo.repo;

import org.pizzahat.com.demo.pojo.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepo extends JpaRepository<Borrowing, Integer> {

}
