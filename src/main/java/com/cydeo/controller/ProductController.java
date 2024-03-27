package com.cydeo.controller;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.impl.CartServiceImpl;
import com.cydeo.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @RequestMapping("/search-product/{name}")
    public String productSearchNameInfo(@PathVariable String name, Model model){

        List<Product> productList = new ArrayList<>();
        ProductServiceImpl productService = new ProductServiceImpl();
        productList = productService.searchProduct(name);
        model.addAttribute(productList);
        return "product/product-list";
    }

    /*
    Products
    id	                                    Name     Price	 RemainingQuantity
    5e64ab9e-1a35-44d5-bbbd-74aca10713f9	milk	    7	 24
    1610111c-771b-4c71-b2da-2295769603d0	milkshake	22	 24
     */

    // I am here 2 requirements left
        @RequestMapping("/cart-list")
    public String productSearchIDInfo(Model model){

CartServiceImpl cartService = new CartServiceImpl();
            List<CartItem> cartItemList = cartService.retrieveCartList().get(0).getCartItemList();
        model.addAttribute("cartItemList", cartItemList);
        return "cart/cart-detail";
    }


//    @RequestMapping("/cart-list/{id}")
//    public String productSearchIDInfo(@PathVariable UUID id, Model model){
//
//        CartItem cartItem = new CartItem();
//        CartServiceImpl cartService = new CartServiceImpl();
//        cartItem = cartService.;
//        model.addAttribute(cartItem);
//        return "cart/cart-detail";
//    }
}
