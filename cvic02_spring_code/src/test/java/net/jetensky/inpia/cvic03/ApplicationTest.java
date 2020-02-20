package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.cvic03.messagesender.EmailSender;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test(expected = IllegalArgumentException.class)
    public void processMessagesMsgEmptyTest() {
        Application app = new Application();
        app.sender = new EmailSender();
        app.processMessages(null, "Pavel");
    }

    @Test
    public void processMessagesMsgNonEmptyTest() {
        Application app = new Application();
        EmailSenderMock emailSenderMock = new EmailSenderMock();
        app.sender = emailSenderMock;
        app.processMessages("Pavel", "Pavel");
        assertEquals("Expect 1 call to emailSender.sendMessage",
                1, emailSenderMock.callCount);
    }

    private class EmailSenderMock extends EmailSender {
        int callCount = 0;
        @Override
        public void sendMessage(String msg, String name) {
            callCount++;
        }
    }
}