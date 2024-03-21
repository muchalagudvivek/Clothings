package com.clothing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothing.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
