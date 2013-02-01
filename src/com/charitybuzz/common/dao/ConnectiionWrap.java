package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectiionWrap {

	private boolean isRead;

	private Connection connection;

	public ConnectiionWrap(Connection conn) throws SQLException {
		this.connection = conn;

		// transaction block start
		this.connection.setAutoCommit(false);
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Connection getConnection() {
		return connection;
	}
}
