package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryObject<T> extends JdbcObject<T> {

	protected ResultSet rs;
	protected T datas;

	public T getDatas() {
		return datas;
	}

	protected String sql;
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		this.setPreparedStatement(conn.prepareStatement(sql));
		this.doPreparedStatement();
		rs = preparedStatement.executeQuery();
		datas = this.doResultSet();
		rs.close();
		preparedStatement.close();
	}

	public abstract T doResultSet() throws SQLException;

}
