package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.CartDAO;
import by.pvt.fooddelivery.domain.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CartDAOHibernate implements CartDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_CARTS = "select u from Cart u";
    private final String DELETE_CART_BY_ID = "delete from Cart u where u.id =:id";

    public CartDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addCart(Cart cart) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(cart);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cart getCartById(Long id) {
        Session session = sessionFactory.openSession();
        Cart cart = session.get(Cart.class, id);
        if (cart == null) {
            throw new RuntimeException("Cart does not exist");
        }
        return cart;
    }

    @Override
    public List<Cart> getAllCarts() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_CARTS);
        return (List<Cart>) query.getResultList();
    }

    @Override
    public void deleteCartById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_CART_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
