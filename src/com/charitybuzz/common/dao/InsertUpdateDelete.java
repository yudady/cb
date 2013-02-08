package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class InsertUpdateDelete<T> extends JdbcObject<T> {
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		this.setPreparedStatement(conn.prepareStatement(sql));
		this.doPreparedStatement();
		this.getPreparedStatement().execute();
		preparedStatement.close();
	}
}
