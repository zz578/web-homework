package controller;

import domain.Product;
import domain.Comment;
import service.ProductService;
import service.CommentService;
import service.impl.ProductServiceImpl;
import service.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotIndex")
public class HotIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        CommentService commentService = new CommentServiceImpl();

        try {
            List<Product> hotList = productService.getHotProducts(5);      // 前5热度商品
            List<Comment> commentList = commentService.getByRecent(5);     // 前5最新评论（你需要扩展方法）

            req.setAttribute("hotList", hotList);
            req.setAttribute("commentList", commentList);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
