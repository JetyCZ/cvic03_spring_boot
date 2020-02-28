package net.jetensky.inpia.cvic03_b.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public void sendEmail(String message, String recipient) {
        System.out.println("Saying " + message + " to " + recipient);
    }
}
