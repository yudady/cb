package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class QueryList<T> extends JdbcObject<T> {

	protected ResultSet rs;
	protected List<T> datas;

	public List<T> getDatas() {
		return datas;
	}
	@Override
	void resultSet(Connection conn, String sql) throws SQLException {
		rs = this.getPreparedStatement().executeQuery();
		datas = this.doResultSet();
		rs.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
