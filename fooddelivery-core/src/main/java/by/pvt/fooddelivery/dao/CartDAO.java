package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.Cart;

import java.util.List;

public interface CartDAO {
    void addCart(Cart cart);

    Cart getCartById(Long id);

    List<Cart> getAllCarts();

    void deleteCartById(Long id);
}
