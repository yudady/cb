package com.charitybuzz.dao;

import java.sql.SQLException;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.QueryObject;

public class DualDao extends BaseDao<Long> {

	public Long getNextPk(String column) {
		String sql = "select " + column + " as id from dual";
		return this.queryObject(sql, new QueryObject<Long>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public Long doResultSet() throws SQLException {
				Long value = null;
				if (rs.next()) {
					value = rs.getLong("id");
				}
				return value;
			}
		});

	}
}
