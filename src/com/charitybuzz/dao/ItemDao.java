package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Item;

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

}
