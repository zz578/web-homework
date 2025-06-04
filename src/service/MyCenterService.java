package service;

import domain.Product;
import domain.Comment;

import java.util.List;

public interface MyCenterService {
    List<Product> getMyProducts(String userId) throws Exception;
    List<Product> getMyFavorites(String userId) throws Exception;
    List<Comment> getMyComments(String userId) throws Exception;
}
