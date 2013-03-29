package com.charitybuzz.common.context;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.charitybuzz.common.dao.ConnectiionWrap;

/**
 * db connection in ThreadLocal
 * 
 * @author Administrator
 * 
 */
public class ConnectionContext {

	private static ThreadLocal<ConnectiionWrap> writeConnectiionWrap = new ThreadLocal<ConnectiionWrap>();

	private static DataSource dataSource;

	private ConnectionContext() {
	}

	/**
	 * 注入DataSource
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		ConnectionContext.dataSource = dataSource;
	}

	/**
	 * 可寫的Connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public synchronized static Connection getWriteConnection()
			throws SQLException {
		ConnectiionWrap cw = writeConnectiionWrap.get();
		if (cw == null) {
			cw = new ConnectiionWrap(dataSource.getConnection());
			;
			writeConnectiionWrap.set(cw);
		}
		return writeConnectiionWrap.get().getConnection();
	}

	public static boolean isConnectionInThreadLocal() {

		ConnectiionWrap cw = writeConnectiionWrap.get();
		if (cw == null) {
			return false;
		}
		return true;
	}

	/**
	 * 從 ThreadLocal 移除
	 * 
	 * @throws SQLException
	 */
	public static void removeWriteConnection() throws SQLException {
		if (!writeConnectiionWrap.get().isRead()) {
			writeConnectiionWrap.remove();
		}
	}

	/**
	 * Connection commit
	 * 
	 * @throws SQLException
	 */
	public static void commitWriteConnection() throws SQLException {
		writeConnectiionWrap.get().getConnection().commit();
	}

	/**
	 * 需要自己關閉
	 * 
	 * @return
	 * @throws SQLException
	 */
	public synchronized static Connection getReadConnection()
			throws SQLException {
		return dataSource.getConnection();
	}

}