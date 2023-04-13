package animals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan
public class Animals {
    private static ApplicationContext applicationContext;

    private class Bean {
    }

    @org.springframework.context.annotation.Bean
    public Bean getBean() {
        return new Bean();
    }


    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(Animals.class);
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        System.out.println(SpringVersion.getVersion());
        System.out.println(org.hibernate.Version.getVersionString());
        System.out.println(System.getProperty("java.version"));
    }

    @RequestMapping("/")
    String home() {
        return "<h1>Hello, world!</h1>";
    }
}
