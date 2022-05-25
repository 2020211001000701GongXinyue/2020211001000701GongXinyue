package com.gongxinyue.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet1")
public class LifeCycleServlet1 extends HttpServlet {
    private int count = 0;

    public LifeCycleServlet1(){
        System.out.println("i am from default constructor");
    }
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        System.out.println("Since loading,this servlet has been accessed " + ++count+"times");

    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}
