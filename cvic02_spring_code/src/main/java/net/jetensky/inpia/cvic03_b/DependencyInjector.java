package net.jetensky.inpia.cvic03_b;

import net.jetensky.inpia.cvic03_b.service.ArticleService;
import net.jetensky.inpia.cvic03_b.service.EmailService;
import net.jetensky.inpia.cvic03_b.service.UserService;

public class DependencyInjector {
    EmailService emailService = new EmailService();
    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public ArticleService getArticleService() {
        return new ArticleService(getEmailService());
    }
    public UserService getUserService() {
        return new UserService(getEmailService());
    }
    public ArticleApp getArticleApp() {
        return new Application(getArticleService(), getUserService());
    }
}
