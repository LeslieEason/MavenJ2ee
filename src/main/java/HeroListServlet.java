import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HeroListServlet extends HttpServlet
{
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NumberFormatException {
        //加上Session判断，若用户登录超过20分钟，则无法直接查询，跳转到登录
        String uerName=(String)request.getSession().getAttribute("userName");
        if(uerName==null)
        {
            response.sendRedirect("login.html");
            return;
        }
        int start=0;
        int count=5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
            // 当浏览器没有传参数start时
        }
        response.setContentType("text/html; charset=UTF-8");
        int next=start+count;
        int pre=start-count;
        pre=pre<0?0:pre;
        List<Hero> heroes = null;
        try {
            int total=new HeroDAO().getTotal();
            int last;
            if(total%count==0)
                last=total-count;
            else
                last=total-total%count;
            next=next>last?last:next;
            request.setAttribute("next",next);
            request.setAttribute("pre",pre);
            request.setAttribute("last",last);
            heroes = new HeroDAO().list(start,count);
            request.setAttribute("heroes",heroes);
            request.getRequestDispatcher("listHero.jsp").forward(request,response);
//            使用MVC的设计思路改写，在java类中不要去书写html代码
//            StringBuffer sb = new StringBuffer();
//            sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
//            sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>delete</td></tr>\r\n");
//
//            String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
//
//
//            for (Hero hero : heros) {
//                String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
//
//                sb.append(tr);
//            }
//            sb.append("</table>");
//            response.getWriter().write(sb.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
