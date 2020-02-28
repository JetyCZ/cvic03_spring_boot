package net.jetensky.inpia.cvic03_b.service;

public class ArticleService {
    private EmailService emailService;

    public ArticleService(EmailService emailService) {

        this.emailService = emailService;
    }

    public void publishArticle(String userEmail) {
        emailService.sendEmail(null, userEmail);
    }
}
