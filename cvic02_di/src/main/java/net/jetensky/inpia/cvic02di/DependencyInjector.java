package net.jetensky.inpia.cvic02di;

import net.jetensky.inpia.cvic02di.service.ArticleService;
import net.jetensky.inpia.cvic02di.service.EmailService;
import net.jetensky.inpia.cvic02di.service.UserService;

public class DependencyInjector {


    private EmailService emailService;
    private UserService userService;
    private ArticleService articleService;
    private Application application;

    public DependencyInjector(EmailService emailService) {
        if (emailService==null) {
            this.emailService = new EmailService();
        } else {
            this.emailService = emailService;
        }

        userService = new UserService(emailService);
        articleService = new ArticleService(emailService);
        application = new Application(userService, articleService);
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public Application getApplication() {
        return application;
    }
}
