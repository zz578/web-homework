package service;

import domain.Product;
import java.util.List;

public interface ProductService {
    void add(Product p) throws Exception;
    List<Product> getAll() throws Exception;
    Product getById(String id) throws Exception;
    void increaseViews(String id) throws Exception;

    // 🔥 热度排行
    List<Product> getHotProducts(int limit) throws Exception;
}
