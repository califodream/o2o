package com.wong.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wong.o2o.entity.ShopCategory;

public interface ShopCategoryDao {
	
	/**
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
	
	/**
	 * 
	 * @param shopCategory
	 * @return
	 */
	int insertShopCategory(ShopCategory shopCategory);
}
