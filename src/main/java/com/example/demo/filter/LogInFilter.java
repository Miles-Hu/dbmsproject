package com.example.demo.filter;

import com.example.demo.controllers.UsersController;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Miles
 * @create 2022-08-01 10:05 PM
 * @email miles.j.hoo@gmail.com
 **/

@Component
public class LogInFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String token = req.getHeader("token");
        if (req.getRequestURI().equals("/users/register") || req.getRequestURI().equals("/users/login") ||
                (token != null && UsersController.tokens.contains(Long.parseLong(token)))) {
            chain.doFilter(request, response);
            return;
        }
        res.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
