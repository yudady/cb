package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class InsertOrUpdate<T> extends JdbcObject<T> {
	
	boolean seccuss;
	
	public boolean isSeccuss() {
		return seccuss;
	}

	public void setSeccuss(boolean seccuss) {
		this.seccuss = seccuss;
	}

	@Override
	void resultSet(Connection conn, String sql) throws SQLException {
		setSeccuss(this.getPreparedStatement().execute());
	}
}
