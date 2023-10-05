package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Cart;
import by.pvt.fooddelivery.repository.CartRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CartRepositoryHibernate extends RepositoryCRUD implements CartRepository {
    private final SessionFactory sessionFactory;

    public CartRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addCart(Cart cart) {
        add(cart);
    }

    @Override
    public Optional<Cart> getCartById(Long cartId) {
        return getById(Cart.class, cartId);
    }

    @Override
    public List<Cart> getAllCarts() {
        return getAll(Cart.class);
    }

    @Override
    public void deleteCartById(Long cartId) {
        deleteById(Cart.class, cartId);
    }

    @Override
    public List<Cart> getCartsByOrderId(Long orderId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Cart c where c.order.id =:orderId");
        query.setParameter("orderId", orderId);
        List<Cart> carts = query.getResultList();
        session.close();
        return carts;
    }
}
