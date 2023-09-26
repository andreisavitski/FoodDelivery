package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.RestaurantWorkerDAO;
import by.pvt.fooddelivery.domain.user.RestaurantWorker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RestaurantWorkerDAOHibernate implements RestaurantWorkerDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_FOOD_ESTABLISHMENT_WORKER = "select u from FoodEstablishmentWorker u";
    private final String DELETE_FOOD_ESTABLISHMENT_WORKERS_BY_ID = "delete from FoodEstablishmentWorker u where u.id =:id";

    public RestaurantWorkerDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addRestaurantWorker(RestaurantWorker restaurantWorker) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(restaurantWorker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public RestaurantWorker getRestaurantWorkerById(Long id) {
        Session session = sessionFactory.openSession();
        RestaurantWorker restaurantWorker = session.get(RestaurantWorker.class, id);
        if (restaurantWorker == null) {
            throw new RuntimeException("Food Establishment Worker does not exist");
        }
        return restaurantWorker;
    }

    @Override
    public List<RestaurantWorker> getAllRestaurantWorkers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_FOOD_ESTABLISHMENT_WORKER);
        return (List<RestaurantWorker>) query.getResultList();
    }

    @Override
    public void deleteRestaurantWorkerById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_FOOD_ESTABLISHMENT_WORKERS_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
