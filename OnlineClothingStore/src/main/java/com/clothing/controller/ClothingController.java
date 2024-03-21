package com.clothing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clothing.service.UserService;

@Controller
public class ClothingController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/signin")
    public String showSignInForm() {
        return "signin"; // Thymeleaf template for sign-in form
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        // Authenticate user (implementation depends on your UserService)
        if (userService.authenticate(username, password)) {
            // Redirect to home page after successful sign-in
            return "redirect:/";
        } else {
            // Redirect back to sign-in page with error message
            return "redirect:/signin?error";
        }
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Thymeleaf template for sign-up form
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        // Register user (implementation depends on your UserService)
        userService.register(user);
        return "redirect:/signin"; // Redirect to sign-in page after successful sign-up
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // Thymeleaf template for displaying products
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId, @RequestParam Integer quantity) {
        // Add product to cart (implementation depends on your CartService)
        cartService.addToCart(productId, quantity);
        return "redirect:/"; // Redirect back to products page after adding to cart
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart"; // Thymeleaf template for displaying cart
    }

    @PostMapping("/checkout")
    public String checkout() {
        // Perform checkout process (implementation depends on your requirements)
        // Redirect to confirmation page after successful checkout
        return "confirmation"; // Thymeleaf template for order confirmation
    }

    @GetMapping("/signout")
    public String signOut() {
        // Perform sign-out action (e.g., invalidate session)
        return "redirect:/signin"; // Redirect to sign-in page after sign-out
    }
}
