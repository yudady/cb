package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.common.dao.QueryPager;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Auction;


/**
 * 拍賣會
 * @author Administrator
 *
 */
public class AuctionDao extends BaseDao<Auction> {
	/**
	 * bidderId and itemId find Auction
	 */
	public Auction findById(final Long id) {
		String sql = "select * from Auction where id = ? ";
		return this.queryObject(sql, new QueryObject<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, id);
			}

			@Override
			public Auction doResultSet() throws SQLException {
				Auction auction = null;
				if (rs.next()) {

					auction = new Auction(rs.getLong("id"), rs
							.getString("title"), rs.getString("brief"), rs
							.getString("webSite"), rs
							.getString("auctionLogoPath"), rs
							.getDate("startDate"), rs.getDate("closeDate"));
				}
				return auction;
			}

		});
	}

	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private List<Auction> findList(String sql ) {
		return this.queryList(sql, new QueryList<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}
			
			@Override
			public List<Auction> doResultSet() throws SQLException {
				List<Auction> list = new ArrayList<Auction>();
				while (rs.next()) {
					list.add(new Auction(rs.getLong("id"), rs
							.getString("title"), rs.getString("brief"), rs
							.getString("webSite"), rs
							.getString("auctionLogoPath"), rs
							.getDate("startDate"), rs.getDate("closeDate")));
				}
				return list;
			}
			
		});
	}
	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private Pager<Auction> findPager(String sql ) {
		return this.queryPager(sql, new QueryPager<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Auction> doResultSet() throws SQLException {
				List<Auction> list = new ArrayList<Auction>();
				while (rs.next()) {
					list.add(new Auction(rs.getLong("id"), rs
							.getString("title"), rs.getString("brief"), rs
							.getString("webSite"), rs
							.getString("auctionLogoPath"), rs
							.getDate("startDate"), rs.getDate("closeDate")));
				}
				return list;
			}

		});
	}
	/**
	 * find all
	 * 
	 * @return
	 */
	public List<Auction> findAll() {
		String sql = "SELECT * FROM AUCTION ";
		return this.findList(sql);
	}
	/**
	 * 已經開始的拍賣會
	 * @return
	 */
	public List<Auction> findStartAuctions() {
		String sql = "SELECT * FROM AUCTION where closeDate >= sysdate and startDate <= sysdate";
		return this.findList(sql);
	}
	/**
	 * 已經開始的拍賣會
	 * @return
	 */
	public Pager<Auction> findPagerStartAuctions() {
		String sql = " SELECT * FROM AUCTION where closeDate >= sysdate and startDate <= sysdate ";
		return this.findPager(sql);
	}
	/**
	 * 尚未開始的拍賣會
	 * @return
	 */
	public List<Auction> findWillAuctions() {
		String sql = "SELECT * FROM AUCTION where startDate >= sysdate";
		return this.findList(sql);
	}
	
	public void update(final Auction auction) {
		String sql = "update auction set title = ? ,brief = ? ,webSite = ? ,auctionLogoPath = ? "
				+ " ,startDate = ?  ,closeDate = ?  where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, auction.getTitle());
				this.preparedStatement.setString(2, auction.getBrief());
				this.preparedStatement.setString(3, auction.getWebSite());
				this.preparedStatement.setString(4,
						auction.getAuctionLogoPath());
				this.preparedStatement.setDate(5, new java.sql.Date(auction
						.getStartDate().getTime()));
				this.preparedStatement.setDate(6, new java.sql.Date(auction
						.getCloseDate().getTime()));
				this.preparedStatement.setLong(7, auction.getId());
			}
		});

	}

	public void insert(final Auction auction) {
		String sql = "insert into auction (id,title,brief,webSite,auctionLogoPath,startDate,closeDate) "
				+ "values (seq_auction.nextval,?,?,?,?,?,?)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, auction.getTitle());
				this.preparedStatement.setString(2, auction.getBrief());
				this.preparedStatement.setString(3, auction.getWebSite());
				this.preparedStatement.setString(4,
						auction.getAuctionLogoPath());
				this.preparedStatement.setDate(5, new java.sql.Date(auction
						.getStartDate().getTime()));
				this.preparedStatement.setDate(6, new java.sql.Date(auction
						.getCloseDate().getTime()));
			}

		});

	}

	public void delete(final Long auctionId) {
		String sql = "delete from auction where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Auction>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, auctionId);
			}

		});

	}





}
