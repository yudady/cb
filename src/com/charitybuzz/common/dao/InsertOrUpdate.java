package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class InsertOrUpdate<T> extends JdbcObject<T> {
	
	@Override
	void resultSet(Connection conn, String sql) throws SQLException {
		this.getPreparedStatement().execute();
	}
}
