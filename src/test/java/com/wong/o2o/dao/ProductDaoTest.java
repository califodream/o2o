package com.wong.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.o2o.BaseTest;
import com.wong.o2o.entity.Product;
import com.wong.o2o.entity.ProductCategory;
import com.wong.o2o.entity.Shop;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;
	
	@Test
	@Ignore
	public void testAInsertProduct() {
		Product product = new Product();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(34L);
		Shop shop = new Shop();
		shop.setShopId(31L);
		product.setProductName("WhatTF");
		product.setProductDesc("That's it");
		product.setCreateTime(new Date());
		product.setImgAddr("Califonia");
		product.setProductCategory(productCategory);
		product.setShop(shop);
		product.setPriority(2);
		product.setEnableStatus(1);
		product.setPoint(5);
		int effectedNum = productDao.insertProduct(product);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testBQueryProductById() {
		Product product  = productDao.queryProductById(5L);
		System.out.println(product.getImgAddr());
		System.out.println(product.getProductDesc());
		System.out.println(product.getProductName());
		System.out.println(product.getPoint());
		assertEquals(1, product.getProductImgList().size());
	}
	
	@Test
	public void testCUpdateProduct() {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(31L);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(34L);
		product.setProductId(7L);
		product.setShop(shop);
		product.setProductCategory(productCategory);
		product.setProductDesc("what's wrong");
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testDQueryProductListAndCount() {
		Product productCondition = new Product();
		productCondition.setProductName("酱");
		List<Product> productList = productDao.queryProductList(productCondition, 0, 2);
		int count = productDao.queryProductCount(productCondition);
		System.out.println(productList.size());
		System.out.println(productList.get(0).getProductName());
		System.out.println(count);
	}
	
}
