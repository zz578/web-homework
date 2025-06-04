package service.impl;

import dao.CommentDao;
import dao.FavoriteDao;
import dao.ProductDao;
import dao.impl.CommentDaoImpl;
import dao.impl.FavoriteDaoImpl;
import dao.impl.ProductDaoImpl;
import domain.Comment;
import domain.Product;
import service.MyCenterService;

import java.util.List;

public class MyCenterServiceImpl implements MyCenterService {
    ProductDao productDao = new ProductDaoImpl();
    FavoriteDao favoriteDao = new FavoriteDaoImpl();
    CommentDao commentDao = new CommentDaoImpl();

    public List<Product> getMyProducts(String userId) throws Exception {
        return productDao.findProductsByUserId(userId); // ✅ 改了名字
    }

    public List<Product> getMyFavorites(String userId) throws Exception {
        return favoriteDao.findByUserId(userId); // 这个名字没变 ✅
    }

    public List<Comment> getMyComments(String userId) throws Exception {
        return commentDao.findCommentsByUserId(userId); // ✅ 改了名字
    }
}
