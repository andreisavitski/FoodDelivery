package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.CourierDAO;
import by.pvt.fooddelivery.domain.user.Courier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CourierDAOHibernate implements CourierDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_COURIERS = "select u from Courier u";
    private final String DELETE_COURIER_BY_ID = "delete from Courier u where u.id =:id";

    public CourierDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addCourier(Courier courier) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(courier);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Courier getCourierById(Long id) {
        Session session = sessionFactory.openSession();
        Courier courier = session.get(Courier.class, id);
        if (courier == null) {
            throw new RuntimeException("Courier does not exist");
        }
        return courier;
    }

    @Override
    public List<Courier> getAllCouriers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_COURIERS);
        return (List<Courier>) query.getResultList();
    }

    @Override
    public void deleteCourierById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_COURIER_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
