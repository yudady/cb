package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryObject<T> extends JdbcTool<T> {

	protected ResultSet rs;
	protected T datas;

	public T getDatas() {
		return datas;
	}

	protected String sql;

	@Override
	void start(Connection conn, String sql) throws SQLException {
		rs = preparedStatement.executeQuery();
		datas = this.doResultSet();
		rs.close();
		preparedStatement.close();
	}

	public abstract T doResultSet() throws SQLException;

}
