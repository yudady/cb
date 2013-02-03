package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Bidlog;

public class BidlogDao extends BaseDao<Bidlog> {
	/**
	 * itemId find list
	 * 
	 * @param itemId
	 * @return
	 */
	public List<Bidlog> findBidlogByitemId(final Long itemId) {
		String sql = "select * from Bidlog where itemId = ? order by bidTime";
		return this.queryList(sql, new QueryList<Bidlog>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public List<Bidlog> doResultSet() throws SQLException {
				List<Bidlog> BidlogList = new ArrayList<Bidlog>();
				while (rs.next()) {
					Bidlog bidlog = new Bidlog();

					BidlogList.add(bidlog);
				}
				return BidlogList;
			}

		});
	}
}
