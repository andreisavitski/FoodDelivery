package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.repository.CartRepository;
import by.pvt.fooddelivery.domain.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CartRepositoryHibernate implements CartRepository {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_CARTS = "select u from Cart u";
    private final String DELETE_CART_BY_ID = "delete from Cart u where u.id =:id";

    public CartRepositoryHibernate() {
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
    public Cart getCartById(Long cartId) {
        Session session = sessionFactory.openSession();
        Cart cart = session.get(Cart.class, cartId);
        if (cart == null) {
            throw new RuntimeException("Cart does not exist");
        }
        session.close();
        return cart;
    }

    @Override
    public List<Cart> getAllCarts() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_CARTS);
        List<Cart> carts = query.getResultList();
        session.close();
        return carts;
    }

    @Override
    public void deleteCartById(Long cartId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_CART_BY_ID);
        query.setParameter("id", cartId);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
