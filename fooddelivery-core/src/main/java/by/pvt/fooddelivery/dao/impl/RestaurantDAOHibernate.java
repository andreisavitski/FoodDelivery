package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.RestaurantDAO;
import by.pvt.fooddelivery.domain.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RestaurantDAOHibernate implements RestaurantDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_RESTAURANTS = "select r from Restaurant r";
    private final String DELETE_RESTAURANT = "delete from Restaurant r where r.id =:id";

    public RestaurantDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(restaurant);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        Session session = sessionFactory.openSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant does not exist");
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_RESTAURANTS);
        return (List<Restaurant>) query.getResultList();
    }

    @Override
    public void deleteRestaurantById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_RESTAURANT);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
