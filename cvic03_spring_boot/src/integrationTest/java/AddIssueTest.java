import net.jetensky.inpia.cvic03.testutil.AbstractUITest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

@Ignore
public class AddIssueTest extends AbstractUITest {

    @Test()
    public void addIssue() {
        driver.get("http://localhost:8080/issuereport");
        driver.findElement(By.name("email")).sendKeys("pavel.jetensky@seznam.cz");
        driver.findElement(By.name("url")).sendKeys("http://jetensky.net/blog");
        driver.findElement(By.name("description")).sendKeys("Blabla");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(
                driver.findElements(By.xpath("//*[text()='Your report has been submitted.']")).size() == 1
        );

        driver.findElement(By.linkText("here")).click();
        Assert.assertTrue(
                driver.findElements(By.xpath("//tr[" +
                        "td[text()='Blabla'] and td[a[text()='http://jetensky.net/blog']]" +
                        "]")).size() > 0
        );

    }

}
