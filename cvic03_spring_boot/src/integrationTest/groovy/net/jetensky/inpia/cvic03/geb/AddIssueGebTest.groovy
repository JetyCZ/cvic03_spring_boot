package net.jetensky.inpia.cvic03.geb

import geb.Browser
import net.jetensky.inpia.cvic03.Application
import net.jetensky.inpia.cvic03.dao.Creator
import net.jetensky.inpia.cvic03.dao.IssueReport
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

import static net.jetensky.inpia.cvic03.testutil.DriverHelper.getWebDriver

class AddIssueGebTest extends Specification{
    def browser
    Application app

    void setup() {
        app = new Application()
        app.main()
        browser = new Browser()
    }

    void testAdd() {

        given:
        Application.context.getBean(Creator.class).saveEntity(new IssueReport())

        when:

        browser.driver = getWebDriver()
        browser.go("http://localhost:8080/issues")

        then:
            browser.title == "Vogella Issuereport"
    }

    void cleanup() {
        Application.context.close()
        browser.quit()
    }
}
