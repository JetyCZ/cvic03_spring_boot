package net.jetensky.inpia.cvic03


import net.jetensky.inpia.cvic03.dao.Creator;
import net.jetensky.inpia.cvic03.dao.IssueReport;
import net.jetensky.inpia.cvic03.testutil.AbstractUITest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddIssueGroovyTest extends AbstractUITest {

    @LocalServerPort
    @Autowired private Integer localServerPort

    @Autowired Creator creator

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
        assertExistingIssue("Blabla", "http://jetensky.net/blog");

    }

    private assertExistingIssue(String description, url) {
        Assert.assertTrue(
                driver.findElements(By.xpath("//tr[" +
                        "td[text()='" +
                        description +
                        "'] and td[a[text()='" +
                        url +
                        "']]" +
                        "]")).size() > 0
        )

    }


    @Test
    void testIssueList() {
        IssueReport issueReport = (IssueReport) creator.saveEntity(
                new IssueReport(), true
        )
        driver.get("http://localhost:8080/issues")
        assertExistingIssue(issueReport.description, issueReport.url)
    }
}
