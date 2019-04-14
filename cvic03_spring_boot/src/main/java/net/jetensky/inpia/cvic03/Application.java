package net.jetensky.inpia.cvic03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        System.out.println(46);
        context = SpringApplication.run(Application.class, args);
    }

}
