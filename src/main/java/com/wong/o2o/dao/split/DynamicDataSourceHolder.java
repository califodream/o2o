package com.wong.o2o.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {
	
	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
	
	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static final String DB_MASTER = "master";
	
	public static final String DB_SLAVE = "slave";
	
	public static String getDbType() {
		String db = contextHolder.get();
		if(db == null) {
			db = DB_MASTER;
		}
		return db;
	}
	
	public static void setDbType(String str) {
		logger.debug("Using Data Source: " + str);
		contextHolder.set(str);
	}
	
	public static void cleanDbType() {
		contextHolder.remove();
	}
}
