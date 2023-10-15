package by.pvt.fooddelivery.config;

import by.pvt.fooddelivery.domain.Comment;
import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.domain.user.Courier;
import by.pvt.fooddelivery.domain.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateJavaConfig {
    private final static StandardServiceRegistryBuilder serviceRegistryBuilder;
    private final static Configuration configuration;

    static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/fooddeliverydb");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "sa");
        properties.setProperty("hibernate.default_schema", "fooddeliverysch");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhCacheRegionFactory");
        properties.setProperty("net.sf.ehcache.configurationResourceName", "META-INF/config/ehcache.xml");
        configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Courier.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(Restaurant.class);
        configuration.addAnnotatedClass(Comment.class);
        serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(properties);
    }

    public static SessionFactory getSessionFactory() {
        return configuration.buildSessionFactory(serviceRegistryBuilder.build());
    }
}
