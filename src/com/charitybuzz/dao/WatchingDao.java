package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Watching;

public class WatchingDao extends BaseDao<Watching> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Watching> findWatchingByitemId(final Long itemId) {
		String sql = "select * from Watching where itemId = ? order by priority";
		return this.findList(sql, new QueryList<Watching>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				ps.setLong(1, itemId);
			}

			@Override
			public List<Watching> doResultSet() throws SQLException {
				List<Watching> WatchingList = new ArrayList<Watching>();
				while (rs.next()) {
					Watching watching = new Watching();

					WatchingList.add(watching);
				}
				return WatchingList;
			}

		});
	}
}
