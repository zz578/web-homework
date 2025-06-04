package dao.impl;

import dao.FavoriteDao;
import domain.Favorite;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    public void add(Favorite fav) throws Exception {
        String sql = "INSERT INTO favorite(id, user_id, product_id) VALUES (?, ?, ?)";
        runner.update(sql, fav.getId(), fav.getUser_id(), fav.getProduct_id());
    }

    public List<Product> findByUserId(String userId) throws Exception {
        String sql = "SELECT p.* FROM favorite f JOIN product p ON f.product_id = p.id WHERE f.user_id = ?";
        return runner.query(sql, new BeanListHandler<>(Product.class), userId); // ✅ 返回 List<Product>
    }
}
