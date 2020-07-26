package com.wong.o2o.dao;

import com.wong.o2o.entity.PersonInfo;

public interface PersonInfoDao {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);
	
	/**
	 * 
	 * @param personInfo
	 * @return
	 */
	int insertPersonInfo(PersonInfo personInfo);
}
