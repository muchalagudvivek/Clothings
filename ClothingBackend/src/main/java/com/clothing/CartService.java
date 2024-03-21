
package com.clothing.services;

import com.clothing.entities.Cart;
import com.clothing.Payload.CartDto;
import com.clothing.Payload.CartHelp;
import com.clothing.Payload.UserDto;

@SuppressWarnings("unused")
public interface CartService {

    //Create
    CartDto CreateCart(CartHelp cartHelp);

    //add Product To Cart
    CartDto addProductToCart(CartHelp cartHelp);

    //Get
    CartDto GetCart(String userEmail);

    //delete product

    void RemoveById(Integer ProductId,String userEmail);

    //delete


}
