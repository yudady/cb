package com.charitybuzz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResultSetImpl<T> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(ResultSetImpl.class);

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected List<T> datas;

	public List<T> getDatas() {
		return datas;
	}

	protected String sql;

	public void init(Connection conn, String sql) throws SQLException {
		log.debug("[LOG][init]");
		this.conn = conn;
		this.sql = sql;
		this.ps = conn.prepareStatement(sql);
		this.rs = ps.executeQuery();
		this.datas = this.doResultSet();
		rs.close();
		ps.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
