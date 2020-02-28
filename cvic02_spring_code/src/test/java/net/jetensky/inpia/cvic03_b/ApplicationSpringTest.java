package net.jetensky.inpia.cvic03_b;

import net.jetensky.inpia.cvic03_b.ApplicationSpring;
import net.jetensky.inpia.cvic03_b.service.EmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationSpring.class })
public class ApplicationSpringTest {

    @Autowired
    EmailService emailService;
    @Test
    public void processMessages() {
        Assert.assertNotNull(emailService);
    }

}
