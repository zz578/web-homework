package dao;

import domain.Product;
import java.util.List;

public interface ProductDao {
    void add(Product product) throws Exception;
    List<Product> findAll() throws Exception;
    Product findById(String id) throws Exception;
    void increaseViewCount(String id) throws Exception;
    List<Product> findProductsByUserId(String userId) throws Exception;

    // 🔥 热度排行
    List<Product> findHotProducts(int limit) throws Exception;
}
