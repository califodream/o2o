package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonInfoDaoTest extends BaseTest {

	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void testAInsertPersonInfo() {
		PersonInfo person = new PersonInfo();
		person.setName("Elon Mask");
		person.setGender("W");
		person.setUserType(1);
		person.setEnableStatus(1);
		int effectedNum = personInfoDao.insertPersonInfo(person);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testBQueryPersonInfoById() {
		long userId = 2;
		PersonInfo person = personInfoDao.queryPersonInfoById(userId);
		System.out.println(person.getName());
	}
}
