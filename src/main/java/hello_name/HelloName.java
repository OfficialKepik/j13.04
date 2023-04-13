package hello_name;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@PropertySource("classpath:hello_name_ru_RU.properties")
public class HelloName {
    public static void main(String[] args) {
        SpringApplication.run(HelloName.class, args);
    }

    @Value("${app.hello}")
    private String hello;

    @Value("${app.name}")
    private String name;

    @RequestMapping("/")
    String home(){
        return String.format("<h3>%s, %s</h3>", hello, name);
    }
}
