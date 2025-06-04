package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import utils.UUIDUtil;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public void register(User user) throws Exception {
        user.setId(UUIDUtil.getId());
        userDao.register(user);
    }

    public User login(String username, String password) throws Exception {
        return userDao.login(username, password);
    }

    public boolean usernameExists(String username) throws Exception {
        return userDao.findByUsername(username) != null;
    }
}
