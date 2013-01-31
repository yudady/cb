package com.charitybuzz.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.charitybuzz.common.dao.ConnectionUtil;

public class BaseDao {

	private static DataSource dataSource;

	@SuppressWarnings("static-access")
	protected void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getReadConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public Connection getWriteConnection() throws SQLException {
		return ConnectionUtil.getWriteConnection();
	}

}
