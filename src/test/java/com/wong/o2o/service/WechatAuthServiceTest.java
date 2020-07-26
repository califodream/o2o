package com.wong.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.dto.WechatAuthExecution;
import com.wong.o2o.entity.PersonInfo;
import com.wong.o2o.entity.WeChatAuth;
import com.wong.o2o.enums.WechatAuthStateEnum;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthServiceTest extends BaseTest {

	@Autowired
	private WechatAuthService wechatAuthService;
	
	@Test
	public void testARegisterAndQuery() {
		WeChatAuth wechat = new WeChatAuth();
		PersonInfo person = new PersonInfo();
		String openId = "helloworld";
		person.setGender("M");
		person.setName("Bill Gates");
		person.setUserType(1);
		wechat.setPersonInfo(person);
		wechat.setOpenId(openId);
		WechatAuthExecution wae = wechatAuthService.register(wechat);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(),wae.getState());
		wechat = wechatAuthService.getWechatAuthByOpenId(openId);
		System.out.println(wechat.getOpenId());
		System.out.println(wechat.getPersonInfo().getName());
	}
}
