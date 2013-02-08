package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryPager<T> extends QueryList<T> {

	protected Pager<T> pager = new Pager<T>();
	protected boolean queryCount ;

	public QueryPager() {
		this.queryCount = true;
	}

	public QueryPager(boolean queryCount) {
		this.queryCount = queryCount;
	}

	public Pager<T> getPager() {
		return pager;
	}
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		if (queryCount) {// 查詢筆數
			String countSQL = OracleUtils.getTotalRecord(sql);
			Statement st = conn.createStatement();
			rs = st.executeQuery(countSQL);
			if (rs.next()) {
				pager.setTotalRecord(rs.getInt("aCountVal"));
			}
		}
		// 查詢資料
		
		String sql2 = OracleUtils.getNamedPageSQL(sql, pager.getPageIndex(),
				pager.getPageIndex() + pager.getPageSize());
		
		Statement st = conn.createStatement();
		rs = st.executeQuery(sql2);
		datas = this.doResultSet();
		this.pager.setDatas(datas);
		
	}
	
	@Override
	void resultSet(Connection conn, String sql) throws SQLException {

	}

	public abstract List<T> doResultSet() throws SQLException;

}
