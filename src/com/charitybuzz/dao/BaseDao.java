package com.charitybuzz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.ConnectionUtil;
import com.charitybuzz.common.dao.QueryList;

public abstract class BaseDao<T> {

	/** logger. */
	private Logger log = LoggerFactory.getLogger(BaseDao.class);

	protected List<T> findAll(String sql, QueryList<T> rs) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getReadConnection();
			rs.init(conn, sql);
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

		return rs.getDatas();
	}

}
