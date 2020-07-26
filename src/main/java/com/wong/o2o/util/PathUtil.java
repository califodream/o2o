package com.wong.o2o.util;

public class PathUtil {
	
	private static String seperator = System.getProperty("file.separator");

	/**
	 * 
	 * @return
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/";
		} else {
			basePath = "/home/work";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	/**
	 * 
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/o2oi/images/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
	
	public static String getProductImagePath(long shopId) {
		String imagePath = "/o2oi/images/shop/" + shopId + "/product/";
		return imagePath.replace("/", seperator);
	}
	
	public static String getHeadLineImagePath() {
		String imagePath = "/o2oi/images/headline/";
		return imagePath.replace("/", seperator);
	}
	
	public static String getShopCategoryPath() {
		String imagePath = "/o2oi/images/shopcategory/";
		return imagePath.replace("/", seperator);
	}
}
