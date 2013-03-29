package com.charitybuzz.dao;

import java.sql.SQLException;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.dto.Watching;

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

	/**
	 * insert watching
	 * 
	 * @param bidderId
	 * @param itemId
	 */
	public void insert(final Long bidderId, final Long itemId) {
		System.out.println("[LOG]insert");
		String sql = "insert into watching (id,bidderId,itemId) values (seq_watching.nextval,?,?)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Watching>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, bidderId);
				this.preparedStatement.setLong(2, itemId);
			}

		});
	}

	/**
	 * delete watching
	 * 
	 * @param bidderId
	 * @param itemId
	 */
	public void deleteByBidderIdItemId(final Long bidderId, final Long itemId) {
		String sql = "delete from watching where bidderId = ? and itemId = ? ";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Watching>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, bidderId);
				this.preparedStatement.setLong(2, itemId);
			}

		});
	}
}
