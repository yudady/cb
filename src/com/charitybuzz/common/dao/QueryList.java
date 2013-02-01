package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class QueryList<T> {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected List<T> datas;

	public List<T> getDatas() {
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
	public abstract List<T> doResultSet() throws SQLException;

}
