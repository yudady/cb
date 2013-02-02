package com.charitybuzz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.ConnectionUtil;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;

public abstract class BaseDao<T> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(BaseDao.class);

	protected List<T> findList(String sql, QueryList<T> queryList) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getReadConnection();
			queryList.init(conn, sql);
		} catch (SQLException e) {
			log.error("query fail", e);
			throw new RuntimeException("query fail", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Connection close fail", e);
			}
		}

		return queryList.getDatas();
	}
	protected T findObject(String sql, QueryObject<T> queryObject) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getReadConnection();
			queryObject.init(conn, sql);
		} catch (SQLException e) {
			log.error("query fail", e);
			throw new RuntimeException("query fail", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Connection close fail", e);
			}
		}
		
		return queryObject.getDatas();
	}

}
