package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.UserDAO;
import by.pvt.fooddelivery.domain.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class UserDAOHibernate implements UserDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_USERS = "select u from User u";
    private final String DELETE_USER_BY_ID = "delete from User u where u.id =:id";

    public UserDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_USER_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        if (user == null) {
            throw new RuntimeException("User does not exist");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_USERS);
        return (List<User>) query.getResultList();
    }
}
