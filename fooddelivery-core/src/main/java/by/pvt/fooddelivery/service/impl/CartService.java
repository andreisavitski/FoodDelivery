package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.repository.CartRepository;
import by.pvt.fooddelivery.domain.Cart;
import by.pvt.fooddelivery.service.CartApi;

import java.util.List;

public class CartService implements CartApi {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addCart(Cart cart) {
        cartRepository.addCart(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.getCartById(cartId);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    @Override
    public void deleteCartById(Long cartId) {
        cartRepository.deleteCartById(cartId);
    }
}
