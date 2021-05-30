import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//监听web应用的状态
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web应用初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("web应用被销毁");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("增加属性 ");
        System.out.println("属性是" + e.getName());
        System.out.println("值是" + e.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent e) {
        System.out.println("移除属性 ");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent e) {
        System.out.println("替换属性");
    }
}
