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

@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id"); // 获取商品ID
        ProductService service = new ProductServiceImpl();
        try {
            service.increaseViews(id); // 浏览量 +1
            Product product = service.getById(id); // 查询商品信息
            CommentService commentService = new CommentServiceImpl();
            List<Comment> comments = commentService.getByProductId(id);
            req.setAttribute("comments", comments);

            req.setAttribute("product", product);  // 存入 request 域
            req.getRequestDispatcher("/client/product_detail.jsp").forward(req, resp); // 转发页面
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 兼容 POST
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
