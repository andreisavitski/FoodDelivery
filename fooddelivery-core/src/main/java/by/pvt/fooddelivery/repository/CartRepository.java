package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    void addCart(Cart cart);

    Optional<Cart> getCartById(Long cartId);

    List<Cart> getAllCarts();

    void deleteCartById(Long cartId);

    List<Cart> getCartsByOrderId(Long orderId);
}
