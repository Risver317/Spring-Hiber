package project.service;

import project.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> readAllUser();

    User readUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);
}