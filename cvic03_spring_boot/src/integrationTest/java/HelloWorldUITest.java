import net.jetensky.inpia.cvic03.testutil.AbstractUITest;
import org.junit.Test;
import org.openqa.selenium.By;

public class HelloWorldUITest extends AbstractUITest {

    @Test()
    public void googleHello() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Univerzita Pardubice");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.xpath("//h3[text()='Univerzita Pardubice - Vysoké školy']"));

    }

}
