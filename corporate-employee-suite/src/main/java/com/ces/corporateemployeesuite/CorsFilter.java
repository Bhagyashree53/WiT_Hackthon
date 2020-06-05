package com.ces.corporateemployeesuite;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell on 6/5/2020.
 */
@Component
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse hr = (HttpServletResponse)servletResponse;
        hr.setHeader("Access-Control-Allow-origin", "*");
        hr.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        hr.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Origin, Authorization," +
                "Accept, Client-Security-Token, Accept-Encoding " );
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
