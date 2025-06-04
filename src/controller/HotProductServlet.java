package controller;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/hot")
public class HotProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        try {
            List<Product> hotList = service.getHotProducts(10);
            req.setAttribute("hotList", hotList);
            req.getRequestDispatcher("/client/hot_products.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
