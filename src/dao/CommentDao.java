package dao;

import domain.Comment;
import java.util.List;

public interface CommentDao {
    void add(Comment comment) throws Exception;

    List<Comment> findByProductId(String productId) throws Exception;
    List<Comment> findCommentsByUserId(String userId) throws Exception;

    // ✅ 新增：获取最近评论
    List<Comment> getRecentComments(int limit) throws Exception;
}
