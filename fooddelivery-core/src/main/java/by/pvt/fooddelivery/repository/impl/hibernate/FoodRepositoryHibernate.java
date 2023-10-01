package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Food;
import by.pvt.fooddelivery.repository.FoodRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class FoodRepositoryHibernate extends RepositoryCRUD implements FoodRepository {
    private final SessionFactory sessionFactory;

    public FoodRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addFood(Food food) {
        add(food);
    }

    @Override
    public void deleteFoodById(Long foodId) {
        deleteById(Food.class, foodId);
    }

    @Override
    public List<Food> getFoodsByName(String foodName) {
        Session session = sessionFactory.openSession();
        String foodsByFoodName = "select f from Food f where f.name =:foodName";
        Query query = session.createQuery(foodsByFoodName);
        query.setParameter("foodName", foodName);
        List<Food> foods = query.getResultList();
        session.close();
        return foods;
    }

    @Override
    public List<Food> getFoodsByRestaurantName(String restaurantName) {
        Session session = sessionFactory.openSession();
        String foodsByRestaurantName = "select f from Food f where f.restaurant.name =:restaurantName";
        Query query = session.createQuery(foodsByRestaurantName);
        query.setParameter("restaurantName", restaurantName);
        List<Food> foods = query.getResultList();
        session.close();
        return foods;
    }

    @Override
    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        Session session = sessionFactory.openSession();
        String foodsByRestaurantId = "select f from Food f where f.restaurant.id =:restaurantId";
        Query query = session.createQuery(foodsByRestaurantId);
        query.setParameter("restaurantId", restaurantId);
        List<Food> foods = query.getResultList();
        session.close();
        return foods;
    }

    @Override
    public void updateFood(Food food) {
        update(food);
    }

    @Override
    public Optional<Food> getFoodById(Long foodId) {
        return getById(Food.class, foodId);
    }

    @Override
    public List<Food> gelAllFoods() {
        return getAll(Food.class);
    }
}
