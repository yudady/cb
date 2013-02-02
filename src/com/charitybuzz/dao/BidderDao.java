package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Bidder;

public class BidderDao extends BaseDao<Bidder> {

	public List<Bidder> findBidderByitemId(final Long itemId) {
		String sql = "select * from Bidder where itemId = ? order by priority";
		return this.findList(sql, new QueryList<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public List<Bidder> doResultSet() throws SQLException {
				List<Bidder> BidderList = new ArrayList<Bidder>();
				while (rs.next()) {
					Bidder bidder = new Bidder();

					BidderList.add(bidder);
				}
				return BidderList;
			}

		});
	}
}
