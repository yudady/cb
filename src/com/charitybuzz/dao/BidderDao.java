package com.charitybuzz.dao;

import java.sql.SQLException;

import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Bidder;

public class BidderDao extends BaseDao<Bidder> {
	/**
	 * id find object
	 * 
	 * @param id
	 * @return
	 */
	public Bidder findById(final Long id) {
		String sql = "select * from Bidder where id = ? ";
		return this.queryObject(sql, new QueryObject<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, id);
			}

			@Override
			public Bidder doResultSet() throws SQLException {
				Bidder it = null;
				if (rs.next()) {
					it = new Bidder(rs.getLong("id"),
							rs.getString("firstName"),
							rs.getString("lastName"), rs
									.getString("screenName"), rs
									.getString("passWord"), rs
									.getString("email"));
				}
				return it;
			}

		});
	}

	public Bidder findByEmail(final String email) {
		String sql = "select * from Bidder where email = ? ";
		return this.queryObject(sql, new QueryObject<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setString(1, email);
			}

			@Override
			public Bidder doResultSet() throws SQLException {
				Bidder it = null;
				if (rs.next()) {
					it = new Bidder(rs.getLong("id"),
							rs.getString("firstName"),
							rs.getString("lastName"), rs
									.getString("screenName"), rs
									.getString("passWord"), rs
									.getString("email"));
				}
				return it;
			}

		});
	}
}
