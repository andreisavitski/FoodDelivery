//package by.pvt.fooddelivery.repository.product.criteria;
//
//import by.pvt.fooddelivery.domain.Product;
//import by.pvt.fooddelivery.enums.ProductType;
//import by.pvt.fooddelivery.repository.product.jpql.HibernateJavaConfig;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//import java.util.Optional;
//
//public class ProductRepositoryCriteriaImpl implements ProductRepositoryCriteria {
//    private final SessionFactory sessionFactory;
//
//    public ProductRepositoryCriteriaImpl() {
//        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
//    }
//
//    @Override
//    public List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name) {
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
//        Root<Product> productRoot = criteriaQuery.from(Product.class);
////        Join<Product, Restaurant> restaurantJoin = productRoot.join("products");
//        criteriaQuery.select(productRoot).where(criteriaBuilder.like(productRoot.get("name"), "%" + name + "%"));
//        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
//        entityManager.close();
//        return products;
//    }
//
//    @Override
//    public Product save(Product product) {
//        return null;
//    }
//
//    @Override
//    public Product delete(Product product) {
//        return null;
//    }
//
//    @Override
//    public Optional<Product> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Product> findByNameContains(String productName) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findByRestaurantId(Long restaurantId) {
//        return null;
//    }
//
//    @Override
//    public List<Product> findByType(ProductType type) {
//        return null;
//    }
//}
