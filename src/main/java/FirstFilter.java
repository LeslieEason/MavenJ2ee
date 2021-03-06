import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FirstFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("First Filter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        String ip=request.getRemoteAddr();
        String url=request.getRequestURI().toString();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=new Date();
        String date=dateFormat.format(d);
        System.out.printf("%s %s 访问了 %s%n", date, ip, url);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
