//package by.pvt.fooddelivery.repository.product.jpql;
//
//import by.pvt.fooddelivery.domain.Product;
//import by.pvt.fooddelivery.domain.Restaurant;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Properties;
//
//public class HibernateJavaConfig {
//    private final static StandardServiceRegistryBuilder serviceRegistryBuilder;
//    private final static Configuration configuration;
//
//    static {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
//        properties.setProperty("hibernate.use_sql_comments", "true");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/fooddeliverydb");
//        properties.setProperty("hibernate.connection.username", "postgres");
//        properties.setProperty("hibernate.connection.password", "sa");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.format_sql", "true");
//        configuration = new Configuration();
//        configuration.setProperties(properties);
//        configuration.addAnnotatedClass(Product.class);
//        configuration.addAnnotatedClass(Restaurant.class);
//        serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//        serviceRegistryBuilder.applySettings(properties);
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return configuration.buildSessionFactory(serviceRegistryBuilder.build());
//    }
//}
