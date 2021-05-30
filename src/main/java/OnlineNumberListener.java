import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener  implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        ServletContext application=e.getSession().getServletContext();
        Integer online_number=(Integer) application.getAttribute("online_number");
        if(online_number==null)
        {
            online_number=0;
        }
        else
        online_number++;
        application.setAttribute("online_number",online_number);
        System.out.println("新增一位用户在线");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        ServletContext application=e.getSession().getServletContext();
        Integer online_number=(Integer) application.getAttribute("online_number");
        if(online_number==null)
            online_number=0;
        else
        online_number--;
        application.setAttribute("online_number",online_number);
        System.out.println("有个人走了");
    }
}
