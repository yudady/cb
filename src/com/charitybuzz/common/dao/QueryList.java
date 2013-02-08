package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryList<T> extends JdbcObject<T> {

	protected ResultSet rs;
	protected List<T> datas;
	protected boolean limit;
	protected int firstRowNumber;
	protected int lastRowNumber;

	public QueryList() {
		limit = false;
	}

	public QueryList(int firstRowNumber, int lastRowNumber) {
		limit = true;
		this.firstRowNumber = firstRowNumber;
		this.lastRowNumber = lastRowNumber;
	}

	public List<T> getDatas() {
		return datas;
	}
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		this.setPreparedStatement(conn.prepareStatement(sql));
		this.doPreparedStatement();
		if (limit) {
			this.setSql(OracleUtils.getNamedPageSQL(sql, firstRowNumber,
					lastRowNumber));
			rs = conn.prepareStatement(this.getSql()).executeQuery();
		} else {
			rs = this.getPreparedStatement().executeQuery();
		}

		datas = this.doResultSet();
		rs.close();
		preparedStatement.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
