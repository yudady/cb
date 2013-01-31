package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtil {

	private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>();

	private static DataSource dataSource;

	private ConnectionUtil() {
	}

	@SuppressWarnings("static-access")
	protected void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public synchronized static Connection getWriteConnection()
			throws SQLException {
		Connection conn = connections.get();
		if (conn == null) {
			conn = dataSource.getConnection() ;
			conn.setAutoCommit(false); //transaction block start
			connections.set(conn);
		}
		return connections.get();
	}

	public static boolean isConnectionInThreadLocal() {
		Connection conn = connections.get();
		if (conn == null) {
			return false;
		}
		return true;
	}

	public static void removeWriteConnection() throws SQLException {
		connections.remove();
	}
	public static void commitWriteConnection() throws SQLException {
		connections.get().commit();
	}

}