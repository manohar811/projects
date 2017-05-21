package com.retail.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.controller.response.ResponseBuilder;
import com.retail.store.dto.CartDto;
import com.retail.store.dto.CartUpdateDto;
import com.retail.store.dto.ResponseDto;
import com.retail.store.model.Cart;
import com.retail.store.service.CartService;

@RestController
public class CartController {

    @Autowired
    private ResponseBuilder response;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/users/{userId}/cart", method = RequestMethod.GET)
    public ResponseEntity<CartDto> getCart(@PathVariable Long userId) {
        CartDto cart = cartService.getCartByUserId(userId);
        return response.ok(cart);
    }

    @RequestMapping(value = "/users/{userId}/cart", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> addToCart(@RequestBody @Validated CartUpdateDto cartUpdateDto) {
        cartService.updateCart(cartUpdateDto);
        return response.ok("Success.cart.updated");
    }
}
