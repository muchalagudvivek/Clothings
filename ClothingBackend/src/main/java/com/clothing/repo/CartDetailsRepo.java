package com.clothing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothing.entities.Cart;
import com.clothing.entities.CartDetalis;
import com.clothing.entities.Product;

public interface CartDetailsRepo extends JpaRepository<CartDetalis,Integer> {
    public void deleteByProductsAndCart(Product product, Cart cart);
    public CartDetalis findByProductsAndCart(Product product, Cart cart);
}
