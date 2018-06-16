package servletPackage;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/postDeal")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        String site = filterConfig.getInitParameter("site");
        System.out.println("网站名字" + site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String user = servletRequest.getParameter("user");
        String psw = servletRequest.getParameter("password");
        if (user.equals("gzm") && psw.equals("Gzm20125")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            PrintWriter out = servletResponse.getWriter();
            out.println("login error");
            out.close();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
