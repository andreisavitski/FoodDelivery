//package by.pvt.fooddelivery.repository.product.jpql;
//
//import by.pvt.fooddelivery.domain.Product;
//import by.pvt.fooddelivery.enums.ProductType;
//import jakarta.persistence.EntityManager;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//import java.util.Optional;
//
//public class ProductRepositoryJPQLImpl implements ProductRepositoryJPQL {
//    private final SessionFactory sessionFactory;
//
//    public ProductRepositoryJPQLImpl() {
//        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
//    }
//
//    @Override
//    public List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name) {
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        List<Product> resultList = entityManager.createQuery("select p from Product p where p.id = 2", Product.class).getResultList();
//        entityManager.close();
//        return resultList;
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
