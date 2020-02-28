package net.jetensky.inpia.cvic02di;

import net.jetensky.inpia.cvic02di.service.ArticleService;
import net.jetensky.inpia.cvic02di.service.EmailService;
import net.jetensky.inpia.cvic02di.service.UserService;

public class Application {

    private UserService userService;
    private ArticleService articleService;

    public static void main(String[] args) {
        new DependencyInjector(null)
                .getApplication()
                .process();
    }

    public Application(UserService userService,
                       ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    public void process() {
        userService.registerUser();
        articleService.publishArticle();
    }
}
