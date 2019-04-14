package net.jetensky.inpia.cvic03.testutil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static net.jetensky.inpia.cvic03.testutil.DriverHelper.getWebDriver;

public class AbstractUITest {
    protected static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        driver = getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }

}
