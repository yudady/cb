package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class JdbcObject<T> {

	private Connection connection;
	protected PreparedStatement preparedStatement;
	private String sql;

	
	public JdbcObject() {
		super();
	}

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

	public abstract void init(Connection conn, String sql) throws SQLException ;
	
	public abstract void doPreparedStatement() throws SQLException;

}
