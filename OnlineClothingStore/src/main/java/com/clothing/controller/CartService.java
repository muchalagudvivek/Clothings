package com.clothing.controller;

import java.util.List;

public interface CartService {

	public void addToCart(Long productId, Integer quantity);

	public List<CartItem> getCartItems();

}
