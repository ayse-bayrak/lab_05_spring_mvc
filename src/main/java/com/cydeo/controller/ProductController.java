package com.cydeo.controller;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService productService;
    private final CartService cartService;

    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @RequestMapping("/search-product/{name}")
    public String productSearchNameInfo(@PathVariable String name, Model model) {
        List<Product> productList = productService.searchProduct(name);
        model.addAttribute(productList);
        return "product/product-list";
    }//done

        @RequestMapping("/cart-list")
    public String cartListInfo(Model model){

    List<Cart> CART_LIST = cartService.retrieveCartList();
    model.addAttribute("cartList",CART_LIST);
    return "cart/cart-list";
    } // does not properly
/*
Carts
ID	TotalPrice
03a09bf4-815f-4f5f-8e97-5db4776fc2e8	21 required 108168
c65ffda2-ee28-4758-a348-26815dc997c4	110 required 216168
 */

    @RequestMapping("/cart-list/{id}")
    public String productSearchIDInfo(@PathVariable UUID id, Model model){
        CartServiceImpl cartService = new CartServiceImpl();
        List<Cart> cart = cartService.retrieveCartList();
        cart.get(0).setId(id);
        List<CartItem> cartItems = cartService.retrieveCartDetail(id);
        model.addAttribute("cartItemList", cartItems);
        return "cart/cart-detail";
    } // does not properly
    /*
    Products
Product Name	Product ID	Product Price	Quantity
milk	184a60ba-8d59-4aa0-b976-5031ed7d7cc9	7	3 required 24
xbox	2ac10e09-aecf-4fa8-9899-02da63b93694	4500	4 required 24
     */
}
