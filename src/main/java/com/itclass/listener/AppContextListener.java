package com.itclass.listener;

import com.itclass.dao.impl.GoodsDao;
import com.itclass.model.Good;
import com.itclass.utils.ConnectionManager;
import com.itclass.utils.DbManager;
import com.itclass.utils.DbServerManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class AppContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {

        ServletContext context = contextEvent.getServletContext();
        ConnectionManager manager = new ConnectionManager();
        DbServerManager.start();
        DbManager.initDb(manager);
        GoodsDao goodsDao = new GoodsDao();
        List<Good> goods = goodsDao.getAll();
        context.setAttribute("goods", goods);
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        DbServerManager.stop();
    }
}
