package net.jetensky.inpia.cvic03_demo.demo;

import junit.framework.TestCase;
import net.jetensky.inpia.cvic03_demo.controller.IssuesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	IssuesController controller;

	@Test
	public void contextLoads() {
		TestCase.assertNotNull(controller);
	}

}
