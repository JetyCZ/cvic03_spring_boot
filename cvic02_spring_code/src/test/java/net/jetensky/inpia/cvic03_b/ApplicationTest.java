package net.jetensky.inpia.cvic03_b;

import net.jetensky.inpia.cvic03_b.Application;
import net.jetensky.inpia.cvic03_b.ArticleApp;
import net.jetensky.inpia.cvic03_b.DependencyInjector;
import net.jetensky.inpia.cvic03_b.service.ArticleService;
import net.jetensky.inpia.cvic03_b.service.EmailService;
import net.jetensky.inpia.cvic03_b.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void processMessages() {
        MockEmailService emailService = new MockEmailService();
        ArticleService articleService = new ArticleService(emailService);
        UserService userService = new UserService(emailService);
        Application app = new Application(articleService, userService);
        app.process("pavel.jetensky@seznam.cz");
        assertEquals(2, emailService.sentCount);
    }

    @Test
    public void dependencyInjector() {
        DependencyInjector dependencyInjector = new DependencyInjector();
        MockEmailService emailService = new MockEmailService();
        dependencyInjector.setEmailService(emailService);
        ArticleApp app = dependencyInjector.getArticleApp();
        app.process("pavel.jetensky@seznam.cz");
        assertEquals(2, emailService.sentCount);
    }

    private class MockEmailService extends EmailService {
        private int sentCount = 0;
        @Override
        public void sendEmail(String message, String recipient) {
            sentCount++;
        }
    }
}
