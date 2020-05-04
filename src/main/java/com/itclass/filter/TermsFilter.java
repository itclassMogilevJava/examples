package com.itclass.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class TermsFilter implements Filter {

    private List<String> ignoreList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ignoreList = new ArrayList<>();
        ignoreList.add("/error.jsp");
        ignoreList.add("/login");
        ignoreList.add("/");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if (isURINotContainsInIgnoreList(((HttpServletRequest) request).getRequestURI())) {
            String terms = (String) req.getSession().getAttribute("isReadTerms");
            if (terms != null && terms.equals("y")) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.sendRedirect("/error.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean isURINotContainsInIgnoreList(String uri) {
        return !ignoreList.contains(uri);
    }
    @Override
    public void destroy() {

    }
}
