package com.gongxinyue.controller;

import com.gongxinyue.dao.ProductDao;
import com.gongxinyue.model.Category;
import com.gongxinyue.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        try {

            List<Category> categoryList = category.findAllCategory(con);
            request.setAttribute("categoryList", categoryList);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        ProductDao productDao = new ProductDao();
        try {
            if (request.getParameter("categoryId") == null) {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList", productList);
        }else{
            int catId = Integer.parseInt(request.getParameter("categoryId"));
            List<Product> productList = productDao.findByCategoryId(catId, con);
            request.setAttribute("productList", productList);
        }
    } catch(SQLException e){
        e.printStackTrace();
    }

    String path = "WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request, response);

     }
}


