package dao.impl;

import dao.ProductDao;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    public void add(Product p) throws Exception {
        String sql = "INSERT INTO product(id, name, description, price, image, publish_time, user_id, view_count) VALUES (?, ?, ?, ?, ?, GETDATE(), ?, 0)";
        runner.update(sql, p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getImage(), p.getUser_id());
    }

    public List<Product> findAll() throws Exception {
        String sql = "SELECT * FROM product ORDER BY publish_time DESC";
        return runner.query(sql, new BeanListHandler<>(Product.class));
    }

    public Product findById(String id) throws Exception {
        String sql = "SELECT * FROM product WHERE id=?";
        return runner.query(sql, new BeanHandler<>(Product.class), id);
    }

    public void increaseViewCount(String id) throws Exception {
        String sql = "UPDATE product SET view_count = view_count + 1 WHERE id=?";
        runner.update(sql, id);
    }

    public List<Product> findProductsByUserId(String userId) throws Exception {
        String sql = "SELECT * FROM product WHERE user_id = ? ORDER BY publish_time DESC";
        return runner.query(sql, new BeanListHandler<>(Product.class), userId);
    }

    public List<Product> findHotProducts(int limit) throws Exception {
        String sql = "SELECT p.* FROM product p " +
                "LEFT JOIN favorite f ON p.id = f.product_id " +
                "GROUP BY p.id, p.name, p.description, p.price, p.image, p.publish_time, p.user_id, p.view_count " +
                "ORDER BY COUNT(f.id) DESC";
        if (limit > 0) {
            sql += " OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
            return runner.query(sql, new BeanListHandler<>(Product.class), limit);
        } else {
            return runner.query(sql, new BeanListHandler<>(Product.class));
        }
    }
}
