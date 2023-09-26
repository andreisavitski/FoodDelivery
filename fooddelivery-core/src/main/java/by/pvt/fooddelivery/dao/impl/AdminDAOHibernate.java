package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.AdminDAO;
import by.pvt.fooddelivery.domain.user.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class AdminDAOHibernate implements AdminDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_ADMINS = "select a from Admin a";
    private final String DELETE_ADMIN_BY_ID = "delete from Admin a where a.id =:id";

    public AdminDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addAdmin(Admin admin) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(admin);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAdminById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_ADMIN_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Admin getAdminById(Long id) {
        Session session = sessionFactory.openSession();
        Admin admin = session.get(Admin.class, id);
        if (admin == null) {
            throw new RuntimeException("Admin does not exist");
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmins() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_ADMINS);
        return (List<Admin>) query.getResultList();
    }
}
