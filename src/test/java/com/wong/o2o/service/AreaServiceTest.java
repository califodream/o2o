package com.wong.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.Area;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;
	
	@Autowired
	private CacheService cacheService;
	
	@Test
	public void testGetAreaList() {
		//cacheService.removeFromCache(areaService.AREALISTKEY);
		List<Area> areaList = areaService.getAreaList();
		assertEquals(4, areaList.size());
		System.out.println(areaList.get(0).getAreaName());
		System.out.println(areaList.get(1).getAreaName());
	}
	
}
