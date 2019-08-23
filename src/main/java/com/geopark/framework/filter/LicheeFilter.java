package com.geopark.framework.filter;

import com.geopark.framework.wrapper.RequestWrapper;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Lichee 过滤器
 *
 * @author lichee
 */
@Component
@WebFilter(filterName = "licheeFilter", urlPatterns = "/*")
public class LicheeFilter implements Filter {

    @Override
    @SuppressWarnings("EmptyMethod")
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        chain.doFilter(new RequestWrapper(req), res);
    }

    @Override
    @SuppressWarnings("EmptyMethod")
    public void init(FilterConfig config) {
    }

}
