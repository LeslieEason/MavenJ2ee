import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetManyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heroList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Hero h=new Hero();
            h.setName("name"+i);
            h.setHp(500+i);
            heroList.add(h);
        }
        String result = JSONSerializer.toJSON(heroList).toString();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(result);
    }

    public static void main(String[] args) {
        List<Hero> heroList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Hero h=new Hero();
            h.setName("name"+i);
            h.setHp(500+i);
            heroList.add(h);
        }
        System.out.println(JSONSerializer.toJSON(heroList).toString());
    }
}
