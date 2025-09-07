package iuh.fit.se.lab03jsp_multilanguage;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter dùng để thiết lập UTF-8 cho toàn bộ request/response
 */
@WebFilter("/*")  // áp dụng cho tất cả request
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        // Không cần cấu hình thêm
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Không cần cleanup
    }
}