package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryPager<T> extends QueryList<T> {

	protected Pager<T> pager;
	protected boolean queryCount;

	public QueryPager() {
		this.pager = new Pager<T>();
	}

	public QueryPager(boolean queryCount) {
		this.pager = new Pager<T>();
		this.queryCount = queryCount;
	}

	public Pager<T> getPager() {
		return pager;
	}

	@Override
	void resultSet(Connection conn, String sql) throws SQLException {
		if (queryCount) {// 查詢筆數
			String countSQL = OracleUtils.getTotalRecord(sql);
			Statement st = conn.createStatement();
			rs = st.executeQuery(countSQL);
			if (rs.next()) {
				pager.setTotalRecord(rs.getInt("aCountVal"));
			}
		}
		// 查詢資料
		this.setSql(OracleUtils.getNamedPageSQL(sql, pager.getPageIndex(),
				pager.getPageIndex() + pager.getPageSize()));
		rs = this.getPreparedStatement().executeQuery();
		datas = this.doResultSet();
		this.pager.setDatas(datas);
		rs.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
