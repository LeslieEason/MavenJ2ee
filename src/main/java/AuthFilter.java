import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//使用Filter来进行登录验证，无需在每个Servlet中再验证Session
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri=request.getRequestURI();

        //如果文件就是登录文件，则不用再判断Session
        if(uri.endsWith("login.html")||uri.endsWith("login"))
        {
            filterChain.doFilter(request,response);
            return;
        }

        //如果是js或者css文件，则不需要判断是否登录，就可以加载
        if(uri.endsWith(".css")||uri.endsWith(".js"))
        {
            filterChain.doFilter(request,response);
            return;
        }
        String userName=(String) request.getSession().getAttribute("userName");
        if(userName==null)
        {
            response.sendRedirect("login.html");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
