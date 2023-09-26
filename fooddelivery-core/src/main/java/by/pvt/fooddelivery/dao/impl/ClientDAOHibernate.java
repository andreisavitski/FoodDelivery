package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.ClientDAO;
import by.pvt.fooddelivery.domain.user.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ClientDAOHibernate implements ClientDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_CLIENTS = "select c from Client c";
    private final String DELETE_CLIENT_BY_ID = "delete from Client c where c.id =:id";

    public ClientDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteClientById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_CLIENT_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client getClientById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        if (client == null) {
            throw new RuntimeException("Client does not exist");
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_CLIENTS);
        return (List<Client>) query.getResultList();
    }
}
