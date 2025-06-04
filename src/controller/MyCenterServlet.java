package controller;

import domain.User;
import domain.Product;
import domain.Comment;
import service.MyCenterService;
import service.impl.MyCenterServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/client/center")
public class MyCenterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        MyCenterService service = new MyCenterServiceImpl();
        try {
            List<Product> myProducts = service.getMyProducts(user.getId());
            List<Product> myFavorites = service.getMyFavorites(user.getId());
            List<Comment> myComments = service.getMyComments(user.getId());

            req.setAttribute("myProducts", myProducts);
            req.setAttribute("myFavorites", myFavorites);
            req.setAttribute("myComments", myComments);

            req.getRequestDispatcher("/client/my_center.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
