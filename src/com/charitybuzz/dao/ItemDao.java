package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.common.dao.QueryPager;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Item;

public class ItemDao extends BaseDao<Item> {

	/**
	 * find all
	 * 
	 * @return
	 */
	public List<Item> findAll() {
		String sql = "select * from item ";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}
//TODO
	public Pager<Item> findAllByPager() {
		String sql = " select * from item ";
		return this.queryPager(sql, new QueryPager<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});

	}

	/**
	 * subCategoryId find list
	 * 
	 * @param subCategoryId
	 * @return
	 */
	public List<Item> findBySubCategoryId(final Long subCategoryId) {
		String sql = "SELECT b.id as id,title,currentbid,startdate,closedate,estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,winningbidderid,createddate,updateddate FROM subcategory_item A ,item b WHERE b.status = '1' AND A.subCategoryId = ? AND b.id = a.itemid ";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subCategoryId);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}

	/**
	 * 找出categoryId的全部商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Item> findByCategoryId(final Long categoryId) {
		String sql = "SELECT x.* FROM ITEM x WHERE x.id in(SELECT d.itemid FROM subcategory_item d WHERE d.subcategoryid IN (SELECT A.ID FROM subcategory A where a.categoryid = ?)) ";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, categoryId);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}

	/**
	 * subItemId find list
	 * 
	 * @param subItemId
	 * @return
	 */
	public List<Item> findBySubItemId(final Long subItemId) {
		String sql = "SELECT b.id as id,title,currentbid,startdate,closedate,estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,winningbidderid,createddate,updateddate FROM subcategory_item A ,item b WHERE b.status = '1' AND A.subItemId = ? AND b.id = a.itemid ";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subItemId);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}

	/**
	 * 找出categoryId的全部商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Item> findByItemId(final Long categoryId) {
		String sql = "SELECT x.* FROM ITEM x WHERE x.id in(SELECT d.itemid FROM subcategory_item d WHERE d.subcategoryid IN (SELECT A.ID FROM subcategory A where a.categoryid = ?)) ";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, categoryId);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}

	/**
	 * find by id
	 * 
	 * @param itemId
	 * @return
	 */
	public Item findById(final Long itemId) {
		String sql = "select * from item where id = ? ";
		return this.queryObject(sql, new QueryObject<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public Item doResultSet() throws SQLException {
				Item it = null;
				if (rs.next()) {
					it = new Item(rs.getLong("id"), rs.getString("title"), rs
							.getDouble("currentBid"), rs.getDate("startDate"),
							rs.getDate("closeDate"), rs
									.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
				}
				return it;
			}

		});
	}

	/**
	 * <pre>
	 * 找出 closeDate - targetDate 小於0
	 * status = 1 (1.拍賣中)
	 * </pre>
	 * 
	 * @param date
	 *            結算時間
	 * @return
	 */
	public List<Item> findByCloseDateLessTargetDate(final Date date) {
		String sql = "SELECT a.* FROM item a WHERE a.status = 1 and (a.closeDate - ? ) <= 0";
		return this.queryList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setDate(1,
						new java.sql.Date(date.getTime()));
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});
	}

	/**
	 * 把商品更新為結標
	 * 
	 * @param id
	 * @return
	 */
	public void updateClosingBidding(final Long id) {
		String sql = "update item  set status='0' where status='1' and id=?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Item>() {

			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, id);
			}

		});
	}

	public void insert(final Item item) {

		String sql = "insert into item (id,title,currentbid,startdate,closedate,"
				+ "estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,"
				+ "winningbidderid,createddate,updateddate) values (?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";
		this.insertUpdateDelete(sql, new InsertOrUpdate<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, item.getId());
				this.preparedStatement.setString(2, item.getTitle());
				this.preparedStatement.setDouble(3, item.getCurrentBid());
				this.preparedStatement.setDate(4, new java.sql.Date(item
						.getStartDate().getTime()));
				this.preparedStatement.setDate(5, new java.sql.Date(item
						.getCloseDate().getTime()));
				this.preparedStatement.setDouble(6, item.getEstimatedValue());
				this.preparedStatement.setDouble(7, item.getIncrementPrice());
				this.preparedStatement.setInt(8, item.getStatus());
				this.preparedStatement.setString(9, item.getLotDetails());
				this.preparedStatement.setString(10, item.getLegalTerms());
				this.preparedStatement.setString(11, item.getShipping());
				this.preparedStatement.setLong(12, item.getWinningBidderId());
			}

		});

	}

	public void update(final Item item) {
		String sql = "update item set title = ? ,currentBid = ? ,startDate = ? ,"
				+ " closeDate = ? , estimatedValue = ? , incrementPrice = ? ,"
				+ " status = ? , lotDetails = ? , legalTerms = ? , "
				+ " shipping = ? , winningBidderId = ? , updatedDate = sysdate where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, item.getTitle());
				this.preparedStatement.setDouble(2, item.getCurrentBid());
				this.preparedStatement.setDate(3, new java.sql.Date(item
						.getStartDate().getTime()));
				this.preparedStatement.setDate(4, new java.sql.Date(item
						.getCloseDate().getTime()));
				this.preparedStatement.setDouble(5, item.getEstimatedValue());
				this.preparedStatement.setDouble(6, item.getIncrementPrice());
				this.preparedStatement.setInt(7, item.getStatus());
				this.preparedStatement.setString(8, item.getLotDetails());
				this.preparedStatement.setString(9, item.getLegalTerms());
				this.preparedStatement.setString(10, item.getShipping());
				this.preparedStatement.setLong(11, item.getWinningBidderId());
				this.preparedStatement.setLong(12, item.getId());
			}

		});

	}

	public void delete(final Long itemId) {
		String sql = "delete from item where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, itemId);
			}

		});

	}

	// TODO

	public List<Item> findClosingNext(int firstRowNumber, int lastRowNumber) {
		String sql = "select * from item";
		return this.queryList(sql, new QueryList<Item>(firstRowNumber,
				lastRowNumber) {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});

	}

	public List<Item> findDeals(int firstRowNumber, int lastRowNumber) {
		String sql = "select * from item";
		return this.queryList(sql, new QueryList<Item>(firstRowNumber,
				lastRowNumber) {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});

	}

	public List<Item> findMostPopular(int firstRowNumber, int lastRowNumber) {
		String sql = "select * from item";
		return this.queryList(sql, new QueryList<Item>(firstRowNumber,
				lastRowNumber) {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});

	}

	public List<Item> findRecentlyAdded(int firstRowNumber, int lastRowNumber) {
		String sql = "select * from item";
		return this.queryList(sql, new QueryList<Item>(firstRowNumber,
				lastRowNumber) {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item(rs.getLong("id"), rs.getString("title"),
							rs.getDouble("currentBid"),
							rs.getDate("startDate"), rs.getDate("closeDate"),
							rs.getDouble("estimatedValue"), rs
									.getDouble("incrementPrice"), rs
									.getInt("status"), rs
									.getString("lotDetails"), rs
									.getString("legalTerms"), rs
									.getString("shipping"), rs
									.getLong("winningBidderId"), rs
									.getDate("createdDate"), rs
									.getDate("updatedDate"));
					itemList.add(it);
				}
				return itemList;
			}

		});

	}

}
