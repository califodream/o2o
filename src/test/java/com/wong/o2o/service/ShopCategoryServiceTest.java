package com.wong.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.dto.ImageHolder;
import com.wong.o2o.dto.ShopCategoryExecution;
import com.wong.o2o.entity.ShopCategory;
import com.wong.o2o.enums.ShopCategoryStateEnum;
import com.wong.o2o.exceptions.ShopCategoryOperationException;

public class ShopCategoryServiceTest extends BaseTest {
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Test
	public void testGetShopCategoryList() {
		List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(null);
		assertEquals(6, shopCategoryList.size());
	}
	
	@Test
	@Ignore
	public void testAddShopCategory() throws FileNotFoundException, ShopCategoryOperationException {
		ShopCategory shopCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(13L);
		shopCategory.setShopCategoryName("交通工具");
		shopCategory.setShopCategoryDesc("交通工具");
		shopCategory.setPriority(69);
		shopCategory.setParent(parentCategory);
		File thumbnail = new File("/Users/wong/Desktop/2017060422121144586.png");
		InputStream is = new FileInputStream(thumbnail);
		ImageHolder img = new ImageHolder(thumbnail.getName(), is);
		ShopCategoryExecution se = shopCategoryService.addShopCategory(shopCategory, img);
		assertEquals(ShopCategoryStateEnum.SUCCESS.getState(), se.getState());
	}
}
