package dao.impl;

import dao.CommentDao;
import domain.Comment;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    public void add(Comment comment) throws Exception {
        String sql = "INSERT INTO comment(id, content, create_time, user_id, product_id) VALUES (?, ?, GETDATE(), ?, ?)";
        runner.update(sql, comment.getId(), comment.getContent(), comment.getUser_id(), comment.getProduct_id());
    }

    public List<Comment> findByProductId(String productId) throws Exception {
        String sql = "SELECT * FROM comment WHERE product_id = ? ORDER BY create_time DESC";
        return runner.query(sql, new BeanListHandler<>(Comment.class), productId);
    }

    public List<Comment> findCommentsByUserId(String userId) throws Exception {
        String sql = "SELECT * FROM comment WHERE user_id = ? ORDER BY create_time DESC";
        return runner.query(sql, new BeanListHandler<>(Comment.class), userId);
    }

    // ✅ 新增：获取最近 N 条评论
    public List<Comment> getRecentComments(int limit) throws Exception {
        String sql = "SELECT TOP " + limit + " * FROM comment ORDER BY create_time DESC";
        return runner.query(sql, new BeanListHandler<>(Comment.class));
    }
}
