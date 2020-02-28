package net.jetensky.inpia.cvic03_b.service;

public class UserService {
    EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void createAccount(String userEmail) {
        emailService.sendEmail(null, null);
    }
}
