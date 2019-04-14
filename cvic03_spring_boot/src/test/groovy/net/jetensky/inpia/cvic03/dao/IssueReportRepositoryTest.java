package net.jetensky.inpia.cvic03.dao;

import net.jetensky.inpia.cvic03.IssueReportDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({IssueReportDataFactory.class, Creator.class})
@Transactional
public class IssueReportRepositoryTest {

    @Autowired
    IssueReportDataFactory issueReportDataFactory;

    @Autowired
    private IssueReportRepository issueReportRepository;

    @Autowired
    private Creator creator;

    @Test
    public void test() {
        Assert.assertEquals(issueReportRepository.findAll().size(), 0);
        creator.save(new IssueReport());
        Assert.assertEquals(issueReportRepository.findAll().size(), 1);
    }

    @Test
    public void testFindAllByEmail() {

        IssueReport entity = new IssueReport();
        entity.setEmail("e1");
        creator.saveEntity(entity);

        issueReportDataFactory.saveIssueReport("e2");
        issueReportDataFactory.saveIssueReport("e1");

        assertEquals(issueReportRepository.findAllByEmail("e1").size(), 2);
        assertEquals(issueReportRepository.findAllByEmail("e2").size(), 1);

    }


}