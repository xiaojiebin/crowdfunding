package top.xiao.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.listener
 * @data 2019/10/16 16:19
 */

@WebListener
public class StartSystemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("APP_PATH", contextPath);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 容器初始化完成.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 容器初销毁完成.");
    }
}
