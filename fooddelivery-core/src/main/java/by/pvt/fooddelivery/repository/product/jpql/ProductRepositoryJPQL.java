//package by.pvt.fooddelivery.repository.product.jpql;
//
//import by.pvt.fooddelivery.domain.Product;
//import by.pvt.fooddelivery.enums.ProductType;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface ProductRepositoryJPQL {
//    public Product save(Product product);
//
//    public Product delete(Product product);
//
//    public Optional<Product> findById(Long id);
//
//    public List<Product> findAll();
//
//    List<Product> findByNameContains(String productName);
//
//    List<Product> findByTypeAndRestaurantId(ProductType type, Long restaurantId);
//
//    List<Product> findByTypeAndRestaurantIdAndNameContains(ProductType type, Long restaurantId, String name);
//
//    List<Product> findByRestaurantId(Long restaurantId);
//
//    List<Product> findByType(ProductType type);
//}
