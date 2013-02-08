package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryList<T> extends JdbcObject<T> {

	protected ResultSet rs;
	protected List<T> datas;
	boolean limit;
	int firstRowNumber;
	int lastRowNumber;

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
	void resultSet(Connection conn, String sql) throws SQLException {
		if (limit) {
			this.setSql(OracleUtils.getNamedPageSQL(sql, firstRowNumber,
					lastRowNumber));
			rs = conn.prepareStatement(this.getSql()).executeQuery();
		} else {
			rs = this.getPreparedStatement().executeQuery();
		}

		datas = this.doResultSet();
		rs.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
