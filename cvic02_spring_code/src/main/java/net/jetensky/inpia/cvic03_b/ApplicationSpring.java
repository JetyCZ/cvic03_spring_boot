package net.jetensky.inpia.cvic03_b;

import net.jetensky.inpia.cvic03.messagesender.EmailSender;
import net.jetensky.inpia.cvic03_b.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class ApplicationSpring {

    @Autowired
    EmailService emailService;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "net.jetensky.inpia.cvic03_b");
        ApplicationSpring app = context.getBean(ApplicationSpring.class);
        System.out.println(app.emailService);
    }


}
