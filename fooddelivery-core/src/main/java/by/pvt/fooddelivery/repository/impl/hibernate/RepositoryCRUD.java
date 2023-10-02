package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class RepositoryCRUD {
    private final SessionFactory sessionFactory;

    public RepositoryCRUD() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    public void add(Object o) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    public <E> void deleteById(Class<E> type, Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete from " + type.getName() + " o where o.id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public <E> Optional<E> getById(Class<E> type, Long id) {
        Session session = sessionFactory.openSession();
        Optional<E> opt = Optional.ofNullable(session.get(type, id));
        session.close();
        return opt;
    }

    public <E> List<E> getAll(Class<E> type) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select o from " + type.getName() + " o");
        List<E> queryResultList = query.getResultList();
        session.close();
        return queryResultList;
    }

    public void update(Object o) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(o);
        session.getTransaction().commit();
        session.close();
    }
}
