package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class QueryList<T> extends JdbcTool<T> {

	protected ResultSet rs;
	protected List<T> datas;

	public List<T> getDatas() {
		return datas;
	}
	@Override
	void start(Connection conn, String sql) throws SQLException {
		rs = this.getPreparedStatement().executeQuery();
		datas = this.doResultSet();
		rs.close();
		preparedStatement.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
