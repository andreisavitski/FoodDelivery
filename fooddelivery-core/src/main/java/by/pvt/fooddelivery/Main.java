package by.pvt.fooddelivery;

import by.pvt.fooddelivery.dto.*;
import by.pvt.fooddelivery.enums.OrderStatus;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.service.impl.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext("by.pvt.fooddelivery");

    public static void main(String[] args) {
//        addRestaurants();
//        addProducts();
//        addClients();
//        addAdmins();
//        addOrder();
//        addOrder2();
    }

    public static ClientDTO addClient1() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("bob");
        clientDTO.setLastName("bob");
        clientDTO.setEmail("bob@mail.com");
        clientDTO.setLogin("bob");
        clientDTO.setPassword("bob");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("minsk");
        addressDTO.setIndex("453534");
        addressDTO.setStreet("shtrasse");
        addressDTO.setNumberOfHouse("55b");
        clientDTO.setAddressDTO(addressDTO);
        clientDTO.setPhoneNumber("+5455432432");
        return clientDTO;
    }

    public static ClientDTO addClient2() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("cat");
        clientDTO.setLastName("cat");
        clientDTO.setEmail("cat@mail.com");
        clientDTO.setLogin("cat");
        clientDTO.setPassword("cat");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("grodno");
        addressDTO.setIndex("3243342");
        addressDTO.setStreet("koshachaya");
        addressDTO.setNumberOfHouse("43");
        clientDTO.setAddressDTO(addressDTO);
        clientDTO.setPhoneNumber("+32343242332");
        return clientDTO;
    }

    public static void addClients() {
        applicationContext.getBean(ClientService.class).registration(addClient1());
        applicationContext.getBean(ClientService.class).registration(addClient2());
    }

    public static AdminDTO addAdmin1() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setFirstName("admin1");
        adminDTO.setLastName("admin1");
        adminDTO.setLogin("admin1");
        adminDTO.setPassword("admin1");
        adminDTO.setEmail("admin1@mail.com");
        adminDTO.setPhoneNumber("+54354544353454");
        return adminDTO;
    }

    public static AdminDTO addAdmin2() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setFirstName("admin2");
        adminDTO.setLastName("admin2");
        adminDTO.setLogin("admin2");
        adminDTO.setPassword("admin2");
        adminDTO.setEmail("admin2@mail.com");
        adminDTO.setPhoneNumber("+4546565353");
        return adminDTO;
    }

    public static void addAdmins() {
        applicationContext.getBean(AdminService.class).registration(addAdmin1());
        applicationContext.getBean(AdminService.class).registration(addAdmin2());
    }

    public static CommentDTO addComment1() {
        CommentDTO commentDTO = new CommentDTO();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(2L);
        commentDTO.setText("good food");
        commentDTO.setClient(clientDTO);
        return commentDTO;
    }

    public static RestaurantDTO addRestaurant1() {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName("KFC");
        restaurantDTO.setPhoneNumber("+3234323522345");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("LA");
        addressDTO.setIndex("43243");
        addressDTO.setStreet("Kalinina");
        addressDTO.setNumberOfHouse("34");
        restaurantDTO.setAddressDTO(addressDTO);
        return restaurantDTO;
    }

    public static RestaurantDTO addRestaurant2() {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName("BK");
        restaurantDTO.setPhoneNumber("+54646444645654");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("LA");
        addressDTO.setIndex("544454");
        addressDTO.setStreet("Street");
        addressDTO.setNumberOfHouse("1");
        restaurantDTO.setAddressDTO(addressDTO);
        return restaurantDTO;
    }

    public static void addRestaurants() {
        applicationContext.getBean(RestaurantService.class).addRestaurant(addRestaurant1());
        applicationContext.getBean(RestaurantService.class).addRestaurant(addRestaurant2());
    }

    public static ProductDTO addProduct1() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("basket S");
        productDTO.setType(ProductType.CHICKEN);
        productDTO.setDescription("12 wings");
        productDTO.setPrice(new BigDecimal(20));
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1L);
        productDTO.setRestaurantDTO(restaurantDTO);
        return productDTO;
    }

    public static ProductDTO addProduct2() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("basket L");
        productDTO.setType(ProductType.CHICKEN);
        productDTO.setDescription("28 wings");
        productDTO.setPrice(new BigDecimal(40));
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1L);
        productDTO.setRestaurantDTO(restaurantDTO);
        return productDTO;
    }

    public static void addProducts() {
        applicationContext.getBean(ProductService.class).addProduct(addProduct1());
        applicationContext.getBean(ProductService.class).addProduct(addProduct2());
    }

    public static void addOrder1() {
        OrderDTO orderDTO = new OrderDTO();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(1L);
        orderDTO.setClient(clientDTO);
        orderDTO.setOrderStatus(OrderStatus.NOT_FORMED);
        orderDTO.setOrdered(LocalDateTime.now());
        applicationContext.getBean(OrderService.class).addOrder(orderDTO);
    }

    public static void addOrder2() {
        OrderDTO orderDTO = new OrderDTO();
        ClientDTO clientDTO = new ClientDTO();
        List<ProductDTO> products = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO();
        ProductDTO productDTO1 = new ProductDTO();
        productDTO.setId(1L);
        productDTO1.setId(1L);
        products.add(productDTO);
        products.add(productDTO1);
        orderDTO.setProducts(products);
        clientDTO.setId(1L);
        orderDTO.setClient(clientDTO);
        orderDTO.setOrderStatus(OrderStatus.NOT_FORMED);
        orderDTO.setOrdered(LocalDateTime.now());
        applicationContext.getBean(OrderService.class).addOrder(orderDTO);
    }
}
