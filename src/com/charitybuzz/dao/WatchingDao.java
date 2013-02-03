package com.charitybuzz.dao;

import java.sql.SQLException;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Watching;

public class WatchingDao extends BaseDao<Watching> {
	/**
	 * bidderId and itemId find Watching
	 */
	public Watching findByBidderIdItemId(final Long bidderId, final Long itemId) {
		String sql = "select * from Watching where bidderId = ? and itemId = ? ";
		return this.queryObject(sql, new QueryObject<Watching>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, bidderId);
				preparedStatement.setLong(2, itemId);
			}

			@Override
			public Watching doResultSet() throws SQLException {
				Watching watching = null;
				if (rs.next()) {
					watching = new Watching(rs.getLong("id"), rs
							.getLong("bidderId"), rs.getLong("itemId"));
				}
				return watching;
			}

		});
	}
}
