package controller;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            UserService service = new UserServiceImpl();
            if (service.usernameExists(username)) {
                req.setAttribute("msg", "用户名已存在！");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }

            service.register(user);
            resp.sendRedirect("login.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
