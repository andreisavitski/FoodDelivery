package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.repository.ProductRepository;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryHibernate extends RepositoryCRUD implements ProductRepository {
    private final EntityManager entityManager;

    public ProductRepositoryHibernate() {
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    @Override
    public void addFood(Product product) {
        add(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        deleteById(Product.class, productId);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> food = criteriaQuery.from(Product.class);
        criteriaQuery.where(criteriaBuilder.equal(food.get("name"), productName));
        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return products;
    }

    @Override
    public List<Product> getProductsByProductNameAndRestaurantName(String productName, String restaurantName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> food = criteriaQuery.from(Product.class);
        Join<Product, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.like(restaurant.get("name"), restaurantName));
        criteriaQuery.select(food).where(criteriaBuilder.like(food.get("name"), "%" + productName + "%"));
        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return products;
    }

    @Override
    public List<Product> getProductsByRestaurantName(String restaurantName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> food = criteriaQuery.from(Product.class);
        Join<Product, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.equal(restaurant.get("name"), restaurantName));
        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return products;
    }

    @Override
    public List<Product> getProductsByRestaurantId(Long restaurantId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> food = criteriaQuery.from(Product.class);
        Join<Product, Restaurant> restaurant = food.join("restaurant");
        criteriaQuery.select(food).where(criteriaBuilder.equal(restaurant.get("id"), restaurantId));
        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        update(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return getById(Product.class, productId);
    }

    @Override
    public List<Product> gelAllProducts() {
        return getAll(Product.class);
    }
}
