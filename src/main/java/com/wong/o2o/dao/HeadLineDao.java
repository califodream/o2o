package com.wong.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wong.o2o.entity.HeadLine;

public interface HeadLineDao {

	/**
	 * 
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
	
	/**
	 * 
	 * @param headLine
	 * @return
	 */
	int insertHeadLine(HeadLine headLine);
}
