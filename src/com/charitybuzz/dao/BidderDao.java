package com.charitybuzz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.common.dao.QueryPager;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Bidder;

public class BidderDao extends BaseDao<Bidder> {

	/**
	 * create Bidder by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static Bidder newBidder(ResultSet rs) throws SQLException {
		return new Bidder(rs.getLong("id"), rs.getString("firstName"),
				rs.getString("lastName"), rs.getString("screenName"),
				rs.getString("passWord"), rs.getString("email"));
	}

	/**
	 * create list by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static List<Bidder> getList(ResultSet rs) throws SQLException {
		List<Bidder> list = new ArrayList<Bidder>();
		while (rs.next()) {
			Bidder it = BidderDao.newBidder(rs);
			list.add(it);
		}
		return list;

	}

	/**
	 * find List<Bidder>
	 * 
	 * @return
	 */
	private List<Bidder> findList(String sql) {
		return this.queryList(sql, new QueryList<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Bidder> doResultSet() throws SQLException {
				return BidderDao.getList(rs);
			}

		});
	}

	/**
	 * find Pager<Bidder>
	 * 
	 * @return
	 */
	private Pager<Bidder> findPager(String sql) {
		return this.queryPager(sql, new QueryPager<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Bidder> doResultSet() throws SQLException {
				return BidderDao.getList(rs);
			}

		});
	}

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
					it = BidderDao.newBidder(rs);
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
					it = BidderDao.newBidder(rs);
				}
				return it;
			}

		});
	}

	/**
	 * 分頁
	 * 
	 * @return
	 */
	public Pager<Bidder> findPager() {
		String sql = " select * from bidder ";
		return this.findPager(sql);
	}

	/**
	 * insert
	 * 
	 * @param bidder
	 */
	public void insert(final Bidder bidder) {
		String sql = "insert into bidder (id,firstName,lastName,screenName,passWord,email) values (seq_bidder.nextval,?,?,?,?,?)";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, bidder.getFirstName());
				this.preparedStatement.setString(2, bidder.getLastName());
				this.preparedStatement.setString(3, bidder.getScreenName());
				this.preparedStatement.setString(4, bidder.getPassWord());
				this.preparedStatement.setString(5, bidder.getEmail());
			}

		});

	}

	/**
	 * update
	 * 
	 * @param bidder
	 */
	public void update(final Bidder bidder) {
		String sql = "update bidder set firstName=? , lastName=? , screenName=? , passWord=? , email=? where id = ?";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, bidder.getFirstName());
				this.preparedStatement.setString(2, bidder.getLastName());
				this.preparedStatement.setString(3, bidder.getScreenName());
				this.preparedStatement.setString(4, bidder.getPassWord());
				this.preparedStatement.setString(5, bidder.getEmail());
				this.preparedStatement.setLong(6, bidder.getId());
			}

		});

	}

	/**
	 * delete
	 * 
	 * @param bidderId
	 */
	public void delete(final Long bidderId) {
		String sql = "delete from bidder where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Bidder>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, bidderId);
			}

		});

	}
}
