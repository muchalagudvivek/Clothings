package com.clothing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
