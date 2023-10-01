package by.pvt.fooddelivery;

import by.pvt.fooddelivery.domain.Address;
import by.pvt.fooddelivery.domain.Comment;
import by.pvt.fooddelivery.domain.Food;
import by.pvt.fooddelivery.domain.Restaurant;
import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.repository.*;
import by.pvt.fooddelivery.repository.impl.hibernate.*;
import by.pvt.fooddelivery.service.*;
import by.pvt.fooddelivery.service.impl.*;

import java.math.BigDecimal;


public class Main {
    public static FoodRepository foodRepository = new FoodRepositoryHibernate();
    public static RestaurantRepository restaurantRepository = new RestaurantRepositoryHibernate();
    public static AdminRepository adminRepository = new AdminRepositoryHibernate();
    public static CartRepository cartRepository = new CartRepositoryHibernate();
    public static CommentRepository commentRepository = new CommentRepositoryHibernate();
    public static ClientRepository clientRepository = new ClientRepositoryHibernate();
    public static RestaurantApi restaurantApi = new RestaurantService(restaurantRepository);
    public static AdminApi adminApi = new AdminService(adminRepository);
    public static CartApi cartApi = new CartService(cartRepository);
    public static CommentApi commentApi = new CommentService(commentRepository);
    public static ClientApi clientApi = new ClientService(clientRepository);
    public static FoodApi foodApi = new FoodService(foodRepository);

    public static void main(String[] args) {
//        addClients();
//        addAdmins();
//        addRestaurants();
//        addFoods();
    }

    public static Client addClient1() {
        Client client = new Client();
        client.setName("bob");
        client.setSurname("bob");
        client.setEmail("bob");
        client.setLogin("bob");
        client.setPassword("bob");
        client.setAddress(new Address("minsk", "shtrasse", "55b", "453534"));
        client.setPhoneNumber("+5455432432");
        return client;
    }

    public static Client addClient2() {
        Client client = new Client();
        client.setName("cat");
        client.setSurname("cat");
        client.setEmail("cat");
        client.setLogin("cat");
        client.setPassword("cat");
        client.setAddress(new Address("grodno", "koshachaya", "43", "3243342"));
        client.setPhoneNumber("+32343242332");
        return client;
    }

    public static void addClients() {
        clientApi.addClient(addClient1());
        clientApi.addClient(addClient2());
    }

    public static Admin addAdmin1() {
        Admin admin = new Admin();
        admin.setName("admin1");
        admin.setSurname("admin1");
        admin.setLogin("admin1");
        admin.setPassword("admin1");
        admin.setEmail("myemail1");
        return admin;
    }

    public static Admin addAdmin2() {
        Admin admin = new Admin();
        admin.setName("admin2");
        admin.setSurname("admin2");
        admin.setLogin("admin2");
        admin.setPassword("admin2");
        admin.setEmail("myemail2");
        return admin;
    }

    public static void addAdmins() {
        adminApi.addAdmin(addAdmin1());
        adminApi.addAdmin(addAdmin2());
    }

    public static Comment addComment1() {
        Comment comment = new Comment();
        Client client = new Client();
        client.setId(2L);
        comment.setText("good food");
        comment.setUser(client);
        return comment;
    }

    public static Restaurant addRestaurant1() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("KFC");
        restaurant.setPhoneNumber("+3234323522345");
        Address address = new Address();
        address.setCity("LA");
        address.setIndex("43243");
        address.setStreet("Kalinina");
        address.setNumberOfHouse("34");
        restaurant.setAddress(address);
        return restaurant;
    }

    public static Restaurant addRestaurant2() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("BK");
        restaurant.setPhoneNumber("+54646444645654");
        Address address = new Address();
        address.setCity("LA");
        address.setIndex("544454");
        address.setStreet("Street");
        address.setNumberOfHouse("1");
        restaurant.setAddress(address);
        return restaurant;
    }

    public static void addRestaurants() {
        restaurantApi.addRestaurant(addRestaurant1());
        restaurantApi.addRestaurant(addRestaurant2());
    }

    public static Food addFood1() {
        Food food = new Food();
        food.setName("basket S");
        food.setTypeOfFood("chicken");
        food.setDescription("12 wings");
        food.setPrice(new BigDecimal(20));
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        food.setRestaurant(restaurant);
        return food;
    }

    public static Food addFood2() {
        Food food = new Food();
        food.setName("basket L");
        food.setTypeOfFood("chicken");
        food.setDescription("28 wings");
        food.setPrice(new BigDecimal(40));
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        food.setRestaurant(restaurant);
        return food;
    }

    public static void addFoods() {
        foodApi.addFood(addFood1());
        foodApi.addFood(addFood2());
    }
}
