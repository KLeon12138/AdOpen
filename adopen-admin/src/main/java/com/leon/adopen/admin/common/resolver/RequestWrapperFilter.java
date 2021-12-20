package com.leon.adopen.admin.common.resolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author leon
 * @date 2021-12-15 19:02
 */
@WebFilter(urlPatterns = "/*", filterName = "RequestWrapperFilter")
public class RequestWrapperFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            if (servletRequest.getContentType() != null
                    && (servletRequest.getContentType().toLowerCase().contains("json"))) {
                RequestBodyWrapper myRequestWrapper = new RequestBodyWrapper((HttpServletRequest) servletRequest);
                filterChain.doFilter(myRequestWrapper, servletResponse);
            } else {
                System.out.println("JsonFilter ContentType: " + servletRequest.getContentType());
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }
}
