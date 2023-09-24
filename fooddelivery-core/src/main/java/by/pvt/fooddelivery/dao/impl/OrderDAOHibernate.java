package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.OrderDAO;
import by.pvt.fooddelivery.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class OrderDAOHibernate implements OrderDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_ORDERS = "select u from Order u";
    private final String DELETE_ORDER_BY_ID = "delete from Order u where u.id =:id";

    public OrderDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Order getOrderById(Long id) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        if (order == null) {
            throw new RuntimeException("Order does not exist");
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_ORDERS);
        return (List<Order>) query.getResultList();
    }

    @Override
    public void deleteOrderById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_ORDER_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
