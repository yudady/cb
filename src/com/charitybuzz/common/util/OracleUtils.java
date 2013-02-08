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

	public static String getCalculatedPageQL(String sql) {
		return "SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM ( " + sql
				+ " ) row_ WHERE rownum <= ? ) WHERE rownum_ > ? ";
	}

	public static String getNamedPageSQL(String sql) {
		return "SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM ( "
				+ sql
				+ " ) row_ WHERE rownum <= :lastRowNumber ) WHERE rownum_ > :firstRowNumber ";
	}

}
