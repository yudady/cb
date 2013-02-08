package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryPager<T> extends JdbcObject<T> {

	protected ResultSet rs;
	protected Pager<T> pager;
	protected Statement st ;
	
	public QueryPager() {
		pager = new Pager<T>();
	}

	public Pager<T> getPager() {
		return pager;
	}
	
	@Override
	public void init(Connection conn, String sql) throws SQLException {
		this.setConnection(conn);
		this.setSql(sql);
		
		
		String totalRecordSQL = OracleUtils.getTotalRecord(this.getSql());
		st = conn.createStatement();
		rs = st.executeQuery(totalRecordSQL);
		if (rs.next()) {
			pager.setTotalRecord(rs.getInt("aCountVal"));
		}
		
		
		
		
		String namedPageSQL = OracleUtils.getNamedPageSQL(this.getSql(), pager.getPageIndex(),
				pager.getPageIndex() + pager.getPageSize());
		PreparedStatement ps = conn.prepareStatement(namedPageSQL);
		this.setPreparedStatement(ps);
		this.doPreparedStatement();
		rs = this.getPreparedStatement().executeQuery();
		pager.setDatas(this.doResultSet());
		rs.close();
		preparedStatement.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
