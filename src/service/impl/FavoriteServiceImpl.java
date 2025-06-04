package service.impl;

import dao.FavoriteDao;
import dao.impl.FavoriteDaoImpl;
import domain.Favorite;
import domain.Product;
import service.FavoriteService;
import utils.UUIDUtil;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao dao = new FavoriteDaoImpl();

    public void add(Favorite fav) throws Exception {
        fav.setId(UUIDUtil.getId());
        dao.add(fav);
    }

    public List<Product> getUserFavorites(String userId) throws Exception {
        return dao.findByUserId(userId);
    }
}

