package com.charitybuzz.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.charitybuzz.dao.BidderDao;
import com.charitybuzz.dao.ItemDao;
import com.charitybuzz.dto.Bidder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/com/charitybuzz/test/applicationContext.xml",
		"classpath:/dispatcherBeans.xml" })
public class JdbcTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	ItemDao itemDao;
	@Resource
	private BidderDao bidderDao;

	@Test
	public void item01() {
		log.debug("[LOG]itemDao" + itemDao);
	}

	@Test
	public void item02() {
		itemDao.updateClosingBidding(10L);
	}

	@Test
	public void item03() {
		Bidder b = bidderDao.findById(1L);
		log.debug("[LOG]" + b);
	}

}
