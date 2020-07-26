package com.wong.o2o.service;

import com.wong.o2o.dto.WechatAuthExecution;
import com.wong.o2o.entity.WeChatAuth;
import com.wong.o2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {

	/**
	 * 
	 * @param openId
	 * @return
	 */
	WeChatAuth getWechatAuthByOpenId(String openId);
	
	/**
	 * 
	 * @param wechatAuth
	 * @return
	 * @throws WechatAuthOperationException
	 */
	WechatAuthExecution register(WeChatAuth wechatAuth) throws WechatAuthOperationException;
}
