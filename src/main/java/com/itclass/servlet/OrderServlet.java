package com.itclass.servlet;

import com.itclass.service.GoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private static final String USER_GOODS_SESSION = "goods";

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String good = req.getParameter("good");
        List<String> goods = (ArrayList<String>) req.getSession().getAttribute(USER_GOODS_SESSION);
        if (goods == null) {
            List<String> userGoods = new ArrayList<>();
            userGoods.add(good);
            req.getSession().setAttribute(USER_GOODS_SESSION, userGoods);
        } else {
            goods.add(good);
            req.getSession().setAttribute(USER_GOODS_SESSION, goods);
        }
        req.setAttribute("goods", GoodService.GOODS);
        req.getRequestDispatcher("/goodsPage.jsp").forward(req, resp);
    }
}
