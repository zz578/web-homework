package controller;

import domain.Product;
import domain.User;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/product/add")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Product p = new Product();
        p.setName(req.getParameter("name"));
        p.setDescription(req.getParameter("description"));
        p.setPrice(Double.parseDouble(req.getParameter("price")));
        p.setImage("static/images/default.png");
        p.setUser_id(user.getId());

        ProductService service = new ProductServiceImpl();
        try {
            service.add(p);
            resp.sendRedirect("../product/list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

