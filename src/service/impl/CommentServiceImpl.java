package service.impl;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import domain.Comment;
import service.CommentService;
import utils.UUIDUtil;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao dao = new CommentDaoImpl();

    public void add(Comment comment) throws Exception {
        comment.setId(UUIDUtil.getId());
        dao.add(comment);
    }

    public List<Comment> getByProductId(String productId) throws Exception {
        return dao.findByProductId(productId);
    }

    public List<Comment> getByUserId(String userId) throws Exception {
        return dao.findCommentsByUserId(userId);
    }

    // ✅ 新增：获取最近 N 条评论
    public List<Comment> getByRecent(int limit) throws Exception {
        return dao.getRecentComments(limit);
    }
}
