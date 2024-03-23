package com.clothing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clothing.entities.User;

import com.clothing.entities.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer> {
   public Cart findByUser(User user);

}
