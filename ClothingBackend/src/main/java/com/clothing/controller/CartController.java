package com.clothing.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothing.Payload.ApiResponse;
import com.clothing.Payload.CartDto;
import com.clothing.Payload.CartHelp;
import com.clothing.services.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/addproduct")
    public ResponseEntity<CartDto> addProduct(@RequestBody CartHelp cartHelp,Principal principal){
        String userEmail = principal.getName();
        cartHelp.setUserEmail(userEmail);
        CartDto cartDto = this.cartService.addProductToCart(cartHelp);
        return new ResponseEntity<>(cartDto, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<CartDto> GetCart(Principal principal){
        String userEmail = principal.getName();
        CartDto cartDto = this.cartService.GetCart(userEmail);

        return new ResponseEntity<>(cartDto, HttpStatusCode.valueOf(200));
    }


    @DeleteMapping("/product/{productid}")
    public ResponseEntity<ApiResponse> DeleteItem(Principal principal, @PathVariable Integer productid){
        String userEmail = principal.getName();
        this.cartService.RemoveById(productid,userEmail);

        return new ResponseEntity<>(new ApiResponse("remove"),HttpStatusCode.valueOf(200));
    }
}