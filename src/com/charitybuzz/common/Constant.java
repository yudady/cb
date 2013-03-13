package com.charitybuzz.common;

/**
 * 
 * @author Administrator
 * 
 */
public class Constant {
	/**
	 * 上傳圖片的位置
	 */
	public static String UPLOAD_FOLDER;
	/**
	 * item上傳圖片的位置
	 */
	public static String UPLOAD_FOLDER_ITEM = Constant.UPLOAD_FOLDER + "item/";
	/**
	 * auction上傳圖片的位置
	 */
	public static String UPLOAD_FOLDER_AUCTION = Constant.UPLOAD_FOLDER + "auction/";

	/**
	 * index頁面中tabs裡面items數量
	 */
	public static final int INDEX_TABS_ITEMS_SIZE = 10;

	/**
	 * 日期格式
	 */
	public static final String DATE_STYLE = "yyyy-MM-dd";
	
	/**
	 * 選多少個圖片 10 (SlideshowService)
	 */
	public static  int SEARCH_PICTURES = 20; 
	/**
	 * 選多少個一級目錄 5 (TopItemsCategoryService)
	 */
	public static  int CATEGORY_SIZE = 5; 
	/**
	 * 選多少個item	3 (TopItemsCategoryService)
	 */
	public static  int ITEM_SIZE = 3;
}
