package com.itclass.servlet;

import com.itclass.service.GoodService;
import com.itclass.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("terms") != null) {
            req.setAttribute("goods", GoodService.GOODS);
            String login = req.getParameter("name");
            req.getSession().setAttribute("name", login);
            req.getSession().setAttribute("isReadTerms", "y");
            if (userService.isUserExists(login)) {
                req.getSession().setAttribute("isLoggedIn", "y");
                req.getRequestDispatcher("/goodsPage.jsp").forward(req, resp);
            } else {
                req.setAttribute("loginFailed", true);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect("/error.jsp");
        }
    }
}
