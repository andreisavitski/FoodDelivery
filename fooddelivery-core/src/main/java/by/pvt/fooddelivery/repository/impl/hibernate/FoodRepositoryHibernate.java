package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Food;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.repository.FoodRepository;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class FoodRepositoryHibernate extends RepositoryCRUD implements FoodRepository {
    private final SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
        Root<Food> food = criteriaQuery.from(Food.class);
        criteriaQuery.where(criteriaBuilder.equal(food.get("name"), foodName));
        List<Food> foods = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return foods;
    }

    @Override
    public List<Food> getFoodsByFoodNameAndRestaurantName(String foodName, String restaurantName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
        Root<Food> food = criteriaQuery.from(Food.class);
        Join<Food, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.like(restaurant.get("name"), restaurantName));
        criteriaQuery.select(food).where(criteriaBuilder.like(food.get("name"), "%" + foodName + "%"));
        List<Food> foods = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return foods;
    }

    public List<Food> getFoodsByFoodNameAndRestaurantId(String foodName, Long restaurantId) {
//       метод будет удален
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
        Root<Food> food = criteriaQuery.from(Food.class);
        Join<Food, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.equal(restaurant.get("id"), restaurantId));
        criteriaQuery.select(food).where(criteriaBuilder.like(food.get("name"), "%" + foodName + "%"));
        List<Food> foods = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return foods;
    }

    @Override
    public List<Food> getFoodsByRestaurantName(String restaurantName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
        Root<Food> food = criteriaQuery.from(Food.class);
        Join<Food, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.equal(restaurant.get("name"), restaurantName));
        List<Food> foods = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return foods;
    }

    @Override
    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Food> criteriaQuery = criteriaBuilder.createQuery(Food.class);
        Root<Food> food = criteriaQuery.from(Food.class);
        Join<Food, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.equal(restaurant.get("id"), restaurantId));
        List<Food> foods = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return foods;
    }

    public void deleteFoodUseCriteria(Long foodId) {
//      метод будет удален
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Food> delete = cb.createCriteriaDelete(Food.class);
        Root<Food> food = delete.from(Food.class);
        delete.where(cb.equal(food.get("id"), foodId));
        entityManager.createQuery(delete).executeUpdate();
        entityManager.close();
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
