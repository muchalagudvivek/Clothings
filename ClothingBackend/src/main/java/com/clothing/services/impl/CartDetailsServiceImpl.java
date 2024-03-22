package com.clothing.services.impl;

import com.clothing.Payload.CartDetailDto;
import com.clothing.Payload.CartHelp;
import com.clothing.repo.CartDetailsRepo;
import com.clothing.repo.CartRepo;
import com.clothing.repo.UserRepo;
import com.clothing.services.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartDetailsServiceImpl implements CartDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;




    @Override
    public CartDetailDto addProduct(CartHelp cartHelp) {
    	String userEmail=  cartHelp.getUserEmail();
        int productId=cartHelp.getProductId();
        int quantity= cartHelp.getQuantity();





        //get user





        return null;
    }
}