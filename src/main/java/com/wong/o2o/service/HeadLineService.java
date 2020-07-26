package com.wong.o2o.service;

import java.util.List;

import com.wong.o2o.dto.HeadLineExecution;
import com.wong.o2o.dto.ImageHolder;
import com.wong.o2o.entity.HeadLine;

public interface HeadLineService {
	
	public static final String HEADLINELISTKEY = "headlinelist";
	
	/**
	 * 
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition);
	
	/**
	 * 
	 * @param headLine
	 * @param thumbnail
	 * @return
	 */
	HeadLineExecution addHeadLine(HeadLine headLine, ImageHolder thumbnail);
}

