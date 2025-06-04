package controller;

import domain.User;
import domain.Product;
import service.FavoriteService;
import service.impl.FavoriteServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/client/favorites")
public class MyFavoritesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        FavoriteService service = new FavoriteServiceImpl();
        try {
            List<Product> list = service.getUserFavorites(user.getId());
            req.setAttribute("products", list);
            req.getRequestDispatcher("/client/my_favorites.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

