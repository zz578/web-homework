package controller;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        try {
            List<Product> list = service.getAll(); // 获取所有商品
            req.setAttribute("products", list);   // 存入 request 域
            req.getRequestDispatcher("/client/product_list.jsp").forward(req, resp); // 转发到列表页面
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 兼容 POST
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
