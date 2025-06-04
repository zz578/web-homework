package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
    QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    public void register(User user) throws Exception {
        String sql = "INSERT INTO [user](id, username, password, email) VALUES (?, ?, ?, ?)";
        runner.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public User login(String username, String password) throws Exception {
        String sql = "SELECT * FROM [user] WHERE username=? AND password=?";
        return runner.query(sql, new BeanHandler<>(User.class), username, password);
    }

    public User findByUsername(String username) throws Exception {
        String sql = "SELECT * FROM [user] WHERE username=?";
        return runner.query(sql, new BeanHandler<>(User.class), username);
    }
}
