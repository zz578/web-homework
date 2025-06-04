package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.Product;
import service.ProductService;
import utils.UUIDUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao dao = new ProductDaoImpl();

    public void add(Product p) throws Exception {
        p.setId(UUIDUtil.getId());
        dao.add(p);
    }

    public List<Product> getAll() throws Exception {
        return dao.findAll();
    }

    public Product getById(String id) throws Exception {
        return dao.findById(id);
    }

    public void increaseViews(String id) throws Exception {
        dao.increaseViewCount(id);
    }

    public List<Product> getHotProducts(int limit) throws Exception {
        return dao.findHotProducts(limit);
    }
}
