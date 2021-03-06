package com.leanengine.server;

import com.leanengine.server.auth.AuthService;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (AuthService.isUserLoggedIn()) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            httpResponse.sendError(401, "Error 401 Unauthorized: no user logged in.");
        }
    }

    @Override
    public void destroy() {
    }
}
