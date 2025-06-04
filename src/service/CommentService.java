package service;

import domain.Comment;
import java.util.List;

public interface CommentService {
    void add(Comment comment) throws Exception;

    List<Comment> getByProductId(String productId) throws Exception;
    List<Comment> getByUserId(String userId) throws Exception;

    // ✅ 新增：获取最新评论
    List<Comment> getByRecent(int limit) throws Exception;
}
