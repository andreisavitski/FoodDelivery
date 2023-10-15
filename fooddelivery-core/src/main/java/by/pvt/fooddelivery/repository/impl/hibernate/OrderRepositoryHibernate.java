package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryHibernate extends RepositoryCRUD implements OrderRepository {
    private final SessionFactory sessionFactory;

    public OrderRepositoryHibernate() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addOrder(Order order) {
        add(order);
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return getById(Order.class, orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return getAll(Order.class);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        deleteById(Order.class, orderId);
    }

    @Override
    public void updateOrder(Order order) {
        update(order);
    }

    @Override
    public List<Product> getOrderProducts(Long orderId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select o.products from Order o where o.id =:orderId");
        query.setParameter("orderId", orderId);
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public void updateListProducts(Long orderId, List<Product> products) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class, orderId);
        order.setProducts(products);
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateTotalCost(Long orderId, BigDecimal totalCost) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class, orderId);
        order.setTotalCost(totalCost);
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }
}
