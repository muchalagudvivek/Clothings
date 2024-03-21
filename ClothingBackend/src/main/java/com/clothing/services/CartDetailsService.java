package com.clothing.services;

import com.clothing.Payload.CartDetailDto;
import com.clothing.Payload.CartHelp;
import org.springframework.stereotype.Service;

@Service
public interface CartDetailsService {

    //add product
    public CartDetailDto addProduct(CartHelp cartHelp);
}