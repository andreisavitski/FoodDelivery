package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.Cart;

import java.util.List;

public interface CartApi {
    void addCart(Cart cart);

    Cart getCartById(Long id);

    List<Cart> getAllCarts();

    void deleteCartById(Long id);
}
