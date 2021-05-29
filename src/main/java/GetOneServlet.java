import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hero hero = new Hero();
        hero.setName("盖伦");
        hero.setHp(353);
        JSONObject json= new JSONObject();
        //将一个对象变成一条json字符串
        json.put("hero", JSONObject.fromObject(hero));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }
}
