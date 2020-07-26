package com.wong.o2o.service;

import com.wong.o2o.entity.PersonInfo;

public interface PersonInfoService {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfo(long userId);
}
