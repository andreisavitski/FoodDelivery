package by.pvt.fooddelivery.dao.impl;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.dao.FoodDAO;
import by.pvt.fooddelivery.domain.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class FoodDAOHibernate implements FoodDAO {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_FOODS = "select u from Food u";
    private final String DELETE_FOOD_BY_ID = "delete from Food u where u.id =:id";

    public FoodDAOHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addFood(Food food) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(food);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Food getFoodById(Long id) {
        Session session = sessionFactory.openSession();
        Food food = session.get(Food.class, id);
        if (food == null) {
            throw new RuntimeException("Food does not exist");
        }
        return food;
    }

    @Override
    public List<Food> gelAllFoods() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_FOODS);
        return (List<Food>) query.getResultList();
    }

    @Override
    public void deleteFoodById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_FOOD_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
