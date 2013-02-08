package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.charitybuzz.common.model.Pager;

public abstract class QueryPager<T> extends QueryList<T> {

	protected Pager<T> pager;
	
	public QueryPager() {
		this.pager = new Pager<T>();
	}
	
	public Pager<T> getPager() {
		return pager;
	}
	
	
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		this.setPreparedStatement(conn.prepareStatement(sql));
		this.doPreparedStatement();
		this.resultSet(conn, sql);
		preparedStatement.close();
	}
	
	@Override
	void resultSet(Connection conn, String sql) throws SQLException {
		rs = this.getPreparedStatement().executeQuery();
		datas = this.doResultSet();
		this.pager.setDatas(datas);
		rs.close();
	}

	public abstract List<T> doResultSet() throws SQLException;
	

}
