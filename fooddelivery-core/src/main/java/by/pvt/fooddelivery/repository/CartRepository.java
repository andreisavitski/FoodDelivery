package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Cart;

import java.util.List;

public interface CartRepository {
    void addCart(Cart cart);

    Cart getCartById(Long cartId);

    List<Cart> getAllCarts();

    void deleteCartById(Long cartId);
}
