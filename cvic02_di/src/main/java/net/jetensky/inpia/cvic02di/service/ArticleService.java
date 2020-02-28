package net.jetensky.inpia.cvic02di.service;

public class ArticleService {

    private EmailService emailService;

    public ArticleService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void publishArticle() {
        emailService.sendEmail("pavel.jetensky@seznam.cz");
    }
}
