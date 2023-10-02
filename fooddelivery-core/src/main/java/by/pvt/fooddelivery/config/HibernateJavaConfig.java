package by.pvt.fooddelivery.config;

import by.pvt.fooddelivery.domain.*;
import by.pvt.fooddelivery.domain.payment.Cash;
import by.pvt.fooddelivery.domain.payment.CreditCard;
import by.pvt.fooddelivery.domain.payment.Payment;
import by.pvt.fooddelivery.domain.user.*;
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
        properties.setProperty("hibernate.show_sql", "true");
        configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Courier.class);
        configuration.addAnnotatedClass(RestaurantEmployee.class);
        configuration.addAnnotatedClass(Cash.class);
        configuration.addAnnotatedClass(CreditCard.class);
        configuration.addAnnotatedClass(Payment.class);
        configuration.addAnnotatedClass(Cart.class);
        configuration.addAnnotatedClass(Food.class);
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
