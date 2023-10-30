package by.pvt.fooddelivery;

import by.pvt.fooddelivery.config.HibernateSpringConfiguration;
import by.pvt.fooddelivery.dto.*;
import by.pvt.fooddelivery.enums.OrderStatus;
import by.pvt.fooddelivery.enums.ProductType;
import by.pvt.fooddelivery.service.*;
import by.pvt.fooddelivery.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("by.pvt.fooddelivery")
public class Main {
    public static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(HibernateSpringConfiguration.class);

    public static void main(String[] args) {
//        addRestaurants();
//        addProducts();
//        addClients();
//        addAdmins();

        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.addProductToOrder(1L, 2L);
//        List<ProductDTO> products = new ArrayList<>();
//        products.add(productDTO);
//        products.add(productDTO);
//        OrderDTO order = new OrderDTO();
//        order.setProducts(products);
//        orderService.addOrder(order);
    }

    public static ClientRequestDTO addClient1() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setFirstName("bob");
        clientRequestDTO.setLastName("bob");
        clientRequestDTO.setEmail("bob@mail.com");
        clientRequestDTO.setLogin("bob");
        clientRequestDTO.setPassword("bob");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("minsk");
        addressDTO.setIndex("453534");
        addressDTO.setStreet("shtrasse");
        addressDTO.setNumberOfHouse("55b");
        clientRequestDTO.setAddressDTO(addressDTO);
        clientRequestDTO.setPhoneNumber("+5455432432");
        return clientRequestDTO;
    }

    public static ClientRequestDTO addClient2() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setFirstName("cat");
        clientRequestDTO.setLastName("cat");
        clientRequestDTO.setEmail("cat@mail.com");
        clientRequestDTO.setLogin("cat");
        clientRequestDTO.setPassword("cat");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("grodno");
        addressDTO.setIndex("3243342");
        addressDTO.setStreet("koshachaya");
        addressDTO.setNumberOfHouse("43");
        clientRequestDTO.setAddressDTO(addressDTO);
        clientRequestDTO.setPhoneNumber("+32343242332");
        return clientRequestDTO;
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

    public static ProductDTO addProduct3() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("basket M");
        productDTO.setType(ProductType.CHICKEN);
        productDTO.setDescription("18 wings");
        productDTO.setPrice(new BigDecimal(30));
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1L);
        productDTO.setRestaurantDTO(restaurantDTO);
        return productDTO;
    }

    public static void addProducts() {
        applicationContext.getBean(ProductService.class).addProduct(addProduct1());
        applicationContext.getBean(ProductService.class).addProduct(addProduct2());
        applicationContext.getBean(ProductService.class).addProduct(addProduct3());
    }

    public static void addOrder1() {
        OrderDTO orderDTO = new OrderDTO();
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setId(1L);
        orderDTO.setClient(clientRequestDTO);
        orderDTO.setOrderStatus(OrderStatus.NOT_FORMED);
        orderDTO.setOrdered(LocalDateTime.now());
        applicationContext.getBean(OrderServiceImpl.class).addOrder(orderDTO);
    }

    public static void addOrder2() {
        OrderDTO orderDTO = new OrderDTO();
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        List<ProductDTO> products = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO();
        ProductDTO productDTO1 = new ProductDTO();
        productDTO.setId(1L);
        productDTO1.setId(1L);
        products.add(productDTO);
        products.add(productDTO1);
        orderDTO.setProducts(products);
        clientRequestDTO.setId(1L);
        orderDTO.setClient(clientRequestDTO);
        orderDTO.setOrderStatus(OrderStatus.NOT_FORMED);
        orderDTO.setOrdered(LocalDateTime.now());
        applicationContext.getBean(OrderServiceImpl.class).addOrder(orderDTO);
    }
}
