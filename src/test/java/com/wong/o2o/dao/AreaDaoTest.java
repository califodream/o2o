package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.Area;

public class AreaDaoTest extends BaseTest {
	
	@Autowired
	private AreaDao areaDao;
	
	@Test
	@Ignore
	public void testQueryArea() {
		
		List<Area> areaList = areaDao.queryArea();
		assertEquals(4, areaList.size());
		Area area1 = areaList.get(0);
		System.out.println(area1.getAreaName());
		System.out.println(area1.getAreaId());
		Area area3 = areaList.get(1);
		System.out.println(area3.getAreaName());
		System.out.println(area3.getAreaId());
		Area area2 = areaList.get(2);
		System.out.println(area2.getAreaName());
		System.out.println(area2.getAreaId());
	}
	
}
