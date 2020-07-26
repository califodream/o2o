package com.wong.o2o.dao;

import com.wong.o2o.entity.WeChatAuth;

public interface WechatAuthDao {

	/**
	 * 
	 * @param openId
	 * @return
	 */
	WeChatAuth queryWechatInfoByOpenId(String openId);
	
	/**
	 * 
	 * @param wechatAuth
	 * @return
	 */
	int insertWechatAuth(WeChatAuth wechatAuth);
}
