package net.jetensky.inpia.cvic02di;

import net.jetensky.inpia.cvic02di.service.ArticleService;
import net.jetensky.inpia.cvic02di.service.EmailService;
import net.jetensky.inpia.cvic02di.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void processMessages() {
        MockEmailService emailServiceMock = new MockEmailService();
        Application app = new DependencyInjector(emailServiceMock).getApplication();
        app.process();
        assertEquals(2, emailServiceMock.sentCount);
    }
    private class MockEmailService extends EmailService {
        private int sentCount = 0;
        @Override
        public void sendEmail(String to) {
            sentCount++;
        }
    }
}
