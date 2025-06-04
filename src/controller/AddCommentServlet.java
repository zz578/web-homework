package controller;

import domain.Comment;
import domain.User;
import service.CommentService;
import service.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/comment/add")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        String productId = req.getParameter("product_id");
        String content = req.getParameter("content");

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser_id(user.getId());
        comment.setProduct_id(productId);

        CommentService service = new CommentServiceImpl();
        try {
            service.add(comment);
            resp.sendRedirect("../product/detail?id=" + productId);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
