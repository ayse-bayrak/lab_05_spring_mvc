package com.cydeo.controller;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.CartService;
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
    public String productSearchNameInfo(@PathVariable String name, Model model) {
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

        @RequestMapping("/cart-list")
    public String cartListInfo(Model model){

    List<Cart> CART_LIST= CartServiceImpl.CART_LIST;

    model.addAttribute("cartList",CART_LIST);
    return "cart/cart-list";
    }
/*
Carts
ID	TotalPrice
03a09bf4-815f-4f5f-8e97-5db4776fc2e8	21
c65ffda2-ee28-4758-a348-26815dc997c4	110
 */

    @RequestMapping("/cart-list/{id}")
    public String productSearchIDInfo(@PathVariable UUID id, Model model){
//        List<Product> PRODUCT_LIST = ProductServiceImpl.PRODUCT_LIST;
//        List<Cart> CART_LIST= CartServiceImpl.CART_LIST;
        CartServiceImpl cartService = new CartServiceImpl();
        //cartService.initialiseCartList();
        List<CartItem> cartItems = cartService.retrieveCartDetail(id);
       // cartList = cartList.stream().filter(s->s.getCartItemList().equals(cartItems)).toList();
        model.addAttribute("cartItemList", cartItems);
        return "cart/cart-detail";
    }

        /*
    Products
Product Name	Product ID	Product Price	Quantity
milk	72a668fb-10b7-454b-bb8f-ba5304f4b354	7	3
xbox	179ae235-5234-49d1-9e97-e7c51557ae11	4500	4
     */
}
