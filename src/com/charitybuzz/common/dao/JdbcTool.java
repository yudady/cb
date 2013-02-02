package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class JdbcTool<T> {

	private Connection connection;
	protected PreparedStatement preparedStatement;
	private String sql;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		this.setPreparedStatement(conn.prepareStatement(sql));
		this.doPreparedStatement();
		start(conn, sql);
	}
	
	abstract void start(Connection conn, String sql) throws SQLException;
	public abstract void doPreparedStatement() throws SQLException;

}
