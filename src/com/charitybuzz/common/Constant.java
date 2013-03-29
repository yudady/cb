package com.charitybuzz.common;

/**
 * 常量
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
	public static String UPLOAD_FOLDER_AUCTION = Constant.UPLOAD_FOLDER
			+ "auction/";
	/**
	 * INDEX_RIGHT 圖片的位置
	 */
	public static String UPLOAD_FOLDER_INDEX_RIGHT = Constant.UPLOAD_FOLDER
			+ "indexright/";

	/**
	 * index頁面中tabs裡面items數量
	 */
	public static final int INDEX_TABS_ITEMS_SIZE = 10;

	/**
	 * 日期格式
	 */
	public static final String DATE_STYLE = "yyyy-MM-dd hh:mm";

	/**
	 * 選多少個圖片 10 (SlideshowService)
	 */
	public static int SEARCH_PICTURES = 20;
	/**
	 * index 拍賣會顯示多少筆
	 */
	public static int AUCTIONS_PAGESIZE = 8;
	/**
	 * 選多少個一級目錄 5 (TopItemsCategoryService)
	 */
	public static int CATEGORY_SIZE = 5;
	/**
	 * 選多少個item 3 (TopItemsCategoryService)
	 */
	public static int ITEM_SIZE = 3;
}
