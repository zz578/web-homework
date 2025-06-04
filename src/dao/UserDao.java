package dao;

import domain.User;

public interface UserDao {
    void register(User user) throws Exception;
    User login(String username, String password) throws Exception;
    User findByUsername(String username) throws Exception;
}
