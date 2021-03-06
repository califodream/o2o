package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
		
		List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(12, shopCategoryList1.size());
		System.out.println(shopCategoryList1.get(0).getShopCategoryName());
		
		/*
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(8L);
		ShopCategory childShopCategory = new ShopCategory();
		childShopCategory.setParent(parentShopCategory);
		List<ShopCategory> shopCategoryList2 = shopCategoryDao.queryShopCategory(childShopCategory);
		assertEquals(2, shopCategoryList2.size());
		System.out.println(shopCategoryList2.get(0).getShopCategoryName());	
		*/
		/*
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		assertEquals(6, shopCategoryList.size());
		System.out.println(shopCategoryList.get(0).getShopCategoryName());
		*/
	}
	
	@Test
	@Ignore
	public void testInsertShopCategory() {
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryName("二手市场");
		shopCategory.setShopCategoryDesc("二手商品交易");
		shopCategory.setPriority(100);
		int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
		assertEquals(1, effectedNum);
	}
}
