package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.PersonInfo;
import com.wong.o2o.entity.WeChatAuth;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest {

	@Autowired
	private WechatAuthDao wechatAuthDao;
	
	@Test
	public void testAInsertWechatAuth() {
		WeChatAuth wechat = new WeChatAuth();
		PersonInfo person = new PersonInfo();
		person.setUserId(3L);
		wechat.setPersonInfo(person);
		wechat.setOpenId("3l4y");
		int effectedNum = wechatAuthDao.insertWechatAuth(wechat);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testBQueryWechatInfoByOpenId() {
		WeChatAuth wechat = wechatAuthDao.queryWechatInfoByOpenId("3l4y");
		System.out.println(wechat.getOpenId());
		System.out.println(wechat.getPersonInfo().getUserId());
	}
	
}
