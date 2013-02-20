package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.dto.Bidlog;

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
					Bidlog bidlog = new Bidlog(rs.getLong("id"), rs
							.getLong("bidderId"), rs.getLong("itemId"), rs
							.getDouble("price"), rs.getDate("bidTime"));

					BidlogList.add(bidlog);
				}
				return BidlogList;
			}

		});
	}

	public void insert(final Bidlog bidlog) {

		String sql = "insert into bidlog (id,bidderId,itemId,price,bidTime) values (seq_bidlog.nextval,?,?,?,sysdate)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Bidlog>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, bidlog.getBidderId());
				this.preparedStatement.setLong(2, bidlog.getItemId());
				this.preparedStatement.setDouble(3, bidlog.getPrice());
			}

		});

	}
}
