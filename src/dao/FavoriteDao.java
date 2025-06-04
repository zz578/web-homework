package dao;

import domain.Favorite;
import domain.Product;

import java.util.List;

public interface FavoriteDao {
    void add(Favorite fav) throws Exception;

    // 返回用户收藏的商品列表
    List<Product> findByUserId(String userId) throws Exception;
}
