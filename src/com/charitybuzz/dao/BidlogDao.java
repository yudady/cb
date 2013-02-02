package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Bidlog;

public class BidlogDao extends BaseDao<Bidlog> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Bidlog> findBidlogByitemId(final Long itemId) {
		String sql = "select * from Bidlog where itemId = ? order by bidTime";
		return this.findList(sql, new QueryList<Bidlog>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				ps.setLong(1, itemId);
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
