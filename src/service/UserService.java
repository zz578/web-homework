package service;

import domain.User;

public interface UserService {
    void register(User user) throws Exception;
    User login(String username, String password) throws Exception;
    boolean usernameExists(String username) throws Exception;
}
