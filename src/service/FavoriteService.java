package service;

import domain.Favorite;
import domain.Product;

import java.util.List;

public interface FavoriteService {
    void add(Favorite fav) throws Exception;
    List<Product> getUserFavorites(String userId) throws Exception;
}
