package controller;

import domain.Favorite;
import domain.User;
import service.FavoriteService;
import service.impl.FavoriteServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/favorite/add")
public class AddFavoriteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        String productId = req.getParameter("id");
        Favorite fav = new Favorite();
        fav.setUser_id(user.getId());
        fav.setProduct_id(productId);

        FavoriteService service = new FavoriteServiceImpl();
        try {
            service.add(fav);
            resp.sendRedirect("../product/detail?id=" + productId);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

