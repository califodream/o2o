package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.LocalAuth;
import com.wong.o2o.entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest extends BaseTest {

	@Autowired
	private LocalAuthDao localAuthDao;

	@Test
	public void testAInsertLocalAuthAndQuery() {
		LocalAuth auth = new LocalAuth();
		PersonInfo person = new PersonInfo();
		person.setUserId(2L);
		auth.setPersonInfo(person);
		auth.setUsername("HelloTest");
		auth.setPassword("world");
		int effectedNum = localAuthDao.insertLocalAuth(auth);
		assertEquals(1, effectedNum);
		auth = localAuthDao.queryLocalByUserId(2L);
		System.out.println(auth.getPersonInfo().getName());
		System.out.println(auth.getUsername());
	}

	@Test
	public void testBQueryLocalByNameAndPass() {
		LocalAuth auth = localAuthDao.queryLocalByNameAndPass("HelloTest", "world");
		System.out.println(auth.getPersonInfo().getName());
		System.out.println(auth.getUsername());
	}

	@Test
	public void testCUpdateLocalAuthAndQuery() {
		int effectedNum = localAuthDao.updateLocalAuth(2L, "HelloTest", "world", "next", new Date());
		assertEquals(1,effectedNum);
	}
}
