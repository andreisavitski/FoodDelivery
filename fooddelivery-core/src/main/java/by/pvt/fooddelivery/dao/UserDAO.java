package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.user.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
