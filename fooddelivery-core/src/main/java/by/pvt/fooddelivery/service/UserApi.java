package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.user.User;

import java.util.List;

public interface UserApi {
    void addUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
