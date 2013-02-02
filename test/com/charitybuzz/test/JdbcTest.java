package com.charitybuzz.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.charitybuzz.dao.ItemDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/com/charitybuzz/test/applicationContext.xml",
		"classpath:/dispatcherBeans.xml" })
public class JdbcTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	ItemDao itemDao;

	@Test
	public void item01() {
		log.debug("[LOG]itemDao" + itemDao);

	}

}
