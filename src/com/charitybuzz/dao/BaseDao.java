package com.charitybuzz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.ConnectionUtil;
import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;

public abstract class BaseDao<T> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(BaseDao.class);

	protected List<T> queryList(String sql, QueryList<T> queryList) {
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
	/**
	 * 
	 * @param sql
	 * @param queryObject
	 * @return
	 */
	protected T queryObject(String sql, QueryObject<T> queryObject) {
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
	
	
	protected boolean insertOrUpdate(String sql, InsertOrUpdate<T> insertOrUpdate) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getWriteConnection();
			insertOrUpdate.init(conn, sql);
		} catch (SQLException e) {
			log.error("write fail", e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				log.error("rollback fail", e1);
			}
		}
		return insertOrUpdate.isSeccuss();
	}

}
