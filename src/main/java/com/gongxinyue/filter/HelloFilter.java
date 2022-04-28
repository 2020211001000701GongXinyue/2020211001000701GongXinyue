package com.gongxinyue.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/home","/login","/register.jsp"}
)
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter-->doFilter()-before servlet-(req come here)");
        chain.doFilter(req, resp);
        System.out.println("i am in HelloFilter-->doFilter()-AFTER servlet-(resp come here)");
    }

    public void init(FilterConfig config) throws ServletException {
    System.out.println("i am in HelloFilter-->init()");
    }

}
