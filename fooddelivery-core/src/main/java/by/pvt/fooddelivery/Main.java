package by.pvt.fooddelivery;

import by.pvt.fooddelivery.dao.impl.UserDAOHibernate;
import by.pvt.fooddelivery.domain.Address;
import by.pvt.fooddelivery.domain.user.Admin;
import by.pvt.fooddelivery.domain.user.Client;
import by.pvt.fooddelivery.service.UserApi;
import by.pvt.fooddelivery.service.impl.UserService;


public class Main {
    public static void main(String[] args) {
        UserApi userApi = new UserService(new UserDAOHibernate());
//        userApi.addUser(addClient());
//        userApi.addUser(addAdmin());
//        Admin admin = new Admin();
//        admin.setId(2L);
//        userApi.deleteUserById(admin);
//        System.out.println(userApi.getUserById(15L));
    }

    public static Client addClient() {
        Client client = new Client();
        client.setName("bob");
        client.setSurname("bob");
        client.setEmail("bob");
        client.setLogin("bob");
        client.setPassword("bob");
        client.setAddress(new Address("minsk", "shtrasse", "55b", "453534"));
        client.setPhoneNumber("5432432");
        return client;
    }

    public static Admin addAdmin() {
        Admin admin = new Admin();
        admin.setName("admin1");
        admin.setSurname("admin1");
        admin.setLogin("admin1");
        admin.setPassword("admin1");
        admin.setEmail("myemail1");
        return admin;
    }
}
