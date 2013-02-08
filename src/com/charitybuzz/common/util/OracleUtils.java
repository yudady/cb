package com.charitybuzz.common.util;

/**
 * Oracle 資料庫相關工具類
 * 
 * @author SYSTEM
 * 
 */
public class OracleUtils {

	private OracleUtils() {
		throw new AssertionError();
	}

	public static String getTotalRecord(String sql) {
		return "SELECT count(*) aCountVal FROM ( " + sql + " ) ";
	}

	public static String getNamedPageSQL(String sql, int firstRowNumber,
			int lastRowNumber) {
		return "SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM ( " + sql
				+ " ) row_ WHERE rownum <= " + lastRowNumber
				+ " ) WHERE rownum_ > " + firstRowNumber + " ";
	}

}
