package net.jetensky.inpia.cvic03.testutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    private WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void write(By elementBy, String value) {
        driver.findElements(elementBy).get(0).sendKeys(value);
    }

    public void click(By elementBy) {
        driver.findElements(elementBy).get(0).click();
    }

    public WebElement findElementByXpath() {
        return driver.findElements(By.xpath("//ul[@class='side-nav']")).get(0);
    }

    public void assertTitle(String přihlášení) {
        Assert.assertEquals(driver.getTitle(), přihlášení);
    }

    public static WebDriver getWebDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        return new ChromeDriver();

    }

}
