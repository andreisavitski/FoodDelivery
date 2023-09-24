package by.pvt.fooddelivery.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConfiguration {
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodDelivery");
        return emf.createEntityManager();
    }
}
