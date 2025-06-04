package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");

        if ("login".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if ("register".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            response.sendError(404, "页面不存在");
        }
    }
}
