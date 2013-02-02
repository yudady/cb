package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Item;

public class ItemDao extends BaseDao<Item> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Item> findAll() {
		String sql = "select * from item ";
		return this.findList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				log.debug("[LOG][doResultSet]");

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
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}

		});
	}

	public List<Item> findBySubCategoryId(final Long id) {
		String sql = "SELECT b.id as id,title,currentbid,startdate,closedate,estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,winningbidderid,createddate,updateddate FROM subcategory_item A ,item b WHERE b.status = '1' AND A.subCategoryId = ? AND b.id = a.itemid ";
		return this.findList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.ps.setLong(1, id);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				log.debug("[LOG][doResultSet]");

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
				log.debug("[LOG][itemList.size()]" + itemList.size());
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
		return this.findList(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.ps.setLong(1, categoryId);
			}

			@Override
			public List<Item> doResultSet() throws SQLException {

				log.debug("[LOG][doResultSet]");

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
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}

		});
	}

	public Item findById(final Long itemId) {
		String sql = "select * from item where id = ? ";
		return this.findObject(sql, new QueryObject<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.ps.setLong(1, itemId);
			}

			@Override
			public Item doResultSet() throws SQLException {
				log.debug("[LOG][doResultSet]");
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

}
