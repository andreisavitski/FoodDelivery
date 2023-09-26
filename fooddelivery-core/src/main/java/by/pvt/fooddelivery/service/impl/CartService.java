package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.CartDAO;
import by.pvt.fooddelivery.domain.Cart;
import by.pvt.fooddelivery.service.CartApi;

import java.util.List;

public class CartService implements CartApi {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    public void addCart(Cart cart) {
        cartDAO.addCart(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartDAO.getCartById(id);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartDAO.getAllCarts();
    }

    @Override
    public void deleteCartById(Long id) {
        cartDAO.deleteCartById(id);
    }
}
