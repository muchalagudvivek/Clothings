package com.clothing.repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clothing.entities.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer> {
   public Cart findByUser(User user);

}
