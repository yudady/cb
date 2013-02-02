package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryObject<T> {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected T datas;

	public T getDatas() {
		return datas;
	}

	protected String sql;

	public void init(Connection conn, String sql) throws SQLException {
		this.conn = conn;
		this.sql = sql;
		ps = conn.prepareStatement(sql);
		this.doPreparedStatement();
		rs = ps.executeQuery();
		datas = this.doResultSet();
		rs.close();
		ps.close();
	}

	public abstract void doPreparedStatement() throws SQLException;
	public abstract T doResultSet() throws SQLException;

}
