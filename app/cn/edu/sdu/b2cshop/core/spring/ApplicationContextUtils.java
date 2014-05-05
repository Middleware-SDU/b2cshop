package cn.edu.sdu.b2cshop.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        ApplicationContextUtils.context = context;
    }

    public static void createContext() {
        context = new ClassPathXmlApplicationContext("spring/context.xml");
    }

}
