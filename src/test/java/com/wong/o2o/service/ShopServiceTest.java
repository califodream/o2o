package com.wong.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.dto.ImageHolder;
import com.wong.o2o.dto.ShopExecution;
import com.wong.o2o.entity.Area;
import com.wong.o2o.entity.PersonInfo;
import com.wong.o2o.entity.Shop;
import com.wong.o2o.entity.ShopCategory;
import com.wong.o2o.enums.ShopStateEnum;
import com.wong.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(2L);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(3L);
//		shopCondition.setShopCategory(sc);
//		Area area = new Area();
//		area.setAreaId(4);
//		shopCondition.setArea(area);
		shopCondition.setOwner(owner);
		ShopExecution se = shopService.getShopList(shopCondition, 4, 2);
		System.out.println(se.getShopList().size());
		System.out.println(se.getCount());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(2L);
		area.setAreaId(6);
		shopCategory.setShopCategoryId(4L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("Beff Coffee");
		shop.setShopDesc("Chinese Favorite");
		shop.setShopAddr("Huiston");
		shop.setPhone("777-662-420");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("/Users/wong/Desktop/2017060609223853062.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder image = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, image);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws FileNotFoundException, ShopOperationException {
		Shop shop = new Shop();
		shop.setShopId(19L);
		shop.setShopName("Forever Young");
		File shopImg = new File("/Users/wong/Public/hi.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder image = new ImageHolder("new.jpg", is);
		ShopExecution shopExecution = shopService.modifyShop(shop, image);
		assertEquals(ShopStateEnum.SUCCESS.getState(), shopExecution.getState());
		System.out.println(shopExecution.getShop().getShopImg());
	}
}
