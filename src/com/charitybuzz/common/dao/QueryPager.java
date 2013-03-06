package com.charitybuzz.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.common.util.OracleUtils;

public abstract class QueryPager<T> extends JdbcObject<T> {
	/** logger. */
	private Logger log = LoggerFactory.getLogger(QueryPager.class);

	protected ResultSet rs;
	protected Pager<T> pager;

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

		/**
		 * query count
		 */
		String totalRecordSQL = OracleUtils.getTotalRecord(this.getSql());
		//log.debug("[LOG][totalRecordSQL]" + totalRecordSQL);
		this.setPreparedStatement(conn.prepareStatement(totalRecordSQL));
		this.doPreparedStatement();
		rs = this.getPreparedStatement().executeQuery();
		if (rs.next()) {
			pager.setTotalRecord(rs.getInt("aCountVal"));
		}

		/**
		 * query pager
		 */
		String namedPageSQL = OracleUtils.getNamedPageSQL(this.getSql(),
				pager.getPageIndex(),
				pager.getPageIndex() + pager.getPageSize());
		//log.debug("[LOG][namedPageSQL]" + namedPageSQL);
		this.setPreparedStatement(conn.prepareStatement(namedPageSQL));
		this.doPreparedStatement();
		rs = this.getPreparedStatement().executeQuery();
		pager.setDatas(this.doResultSet());
		rs.close();
		preparedStatement.close();
	}

	public abstract List<T> doResultSet() throws SQLException;

}
