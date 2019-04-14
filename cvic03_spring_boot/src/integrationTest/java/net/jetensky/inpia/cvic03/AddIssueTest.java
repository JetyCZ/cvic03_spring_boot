package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.cvic03.Application;
import net.jetensky.inpia.cvic03.dao.Creator;
import net.jetensky.inpia.cvic03.dao.IssueReport;
import net.jetensky.inpia.cvic03.testutil.AbstractUITest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddIssueTest extends AbstractUITest {


    @LocalServerPort
    @Autowired private Integer localServerPort;

    @Autowired Creator creator;

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


    @Test
    public void testIssueList() {
        IssueReport issueReport = new IssueReport();
        IssueReport savedIssue = (IssueReport) creator.saveEntity(
                issueReport, true
        );
        driver.get("http://localhost:8080/issues");

    }
}
