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
    DriverHelper driverHelper;

    @Before
    public void before() {
        driverHelper = new DriverHelper(driver);
    }

    @BeforeClass
    public static void openBrowser(){
        driver = getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }




    protected void loginTestUser(boolean forceLogin) {
        driver.get("http://system.stormont.digitalcz.cz/login");

        if (forceLogin) driver.get("https://system.stormont.digitalcz.cz/logout");
        if (driver.getTitle().equals("Přihlášení")) {
            driverHelper.assertTitle("Přihlášení");
            driverHelper.write(By.id("username"), "digitalmanazer");
            driverHelper.write(By.id("password"), "testy123");
            driverHelper.click(By.id("_submit"));
        }
        driverHelper.assertTitle("Nástěnka");

    }
}
