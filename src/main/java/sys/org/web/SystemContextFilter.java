package sys.org.web;


import sys.org.util.model.SystemContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 27267
 */
public class SystemContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String startStr = req.getParameter("start");
        if (startStr != null && startStr.matches("\\d+")) {
            SystemContext.setPageOffset(Integer.parseInt(startStr));
        }
        String limitStr = req.getParameter("limit");
        if (limitStr != null && limitStr.matches("\\d+")) {
            SystemContext.setPageSize(Integer.parseInt(limitStr));
        }
        try {
            filterChain.doFilter(req, resp);
        } finally {
            SystemContext.removePageSize();
            SystemContext.removePageOffset();
        }

    }

    @Override
    public void destroy() {

    }
}
