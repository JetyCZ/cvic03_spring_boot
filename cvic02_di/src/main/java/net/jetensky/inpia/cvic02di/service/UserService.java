package net.jetensky.inpia.cvic02di.service;

public class UserService {

    private EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser() {
        emailService.sendEmail("pavel.jetensky@seznam.cz");
    }
}