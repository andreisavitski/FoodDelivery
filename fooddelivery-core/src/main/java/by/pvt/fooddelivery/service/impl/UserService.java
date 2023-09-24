package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.UserDAO;
import by.pvt.fooddelivery.domain.user.User;
import by.pvt.fooddelivery.service.UserApi;

import java.util.List;

public class UserService implements UserApi {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
