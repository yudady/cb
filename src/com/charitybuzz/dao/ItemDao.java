package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Item;

public class ItemDao extends BaseDao<Item> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	public List<Item> findAll() {
		String sql = "select * from item ";
		return this.findAll(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}
			@Override
			public List<Item> doResultSet() throws SQLException {
				
				log.debug("[LOG][doResultSet]");
				
				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item();
					it.setId(rs.getLong("id"));
					it.setTitle(rs.getString("title"));
					it.setCurrentBid(rs.getDouble("currentBid"));
					it.setStartDate(rs.getDate("startDate"));
					it.setCloseDate(rs.getDate("closeDate"));
					it.setEstimatedValue(rs.getDouble("estimatedValue"));
					it.setIncrementPrice(rs.getDouble("incrementPrice"));
					it.setStatus(rs.getInt("status"));
					it.setLotDetails(rs.getString("lotDetails"));
					it.setLegalTerms(rs.getString("legalTerms"));
					it.setShipping(rs.getString("shipping"));
					it.setWinningBidderId(rs.getLong("winningBidderId"));
					it.setCreatedDate(rs.getDate("createdDate"));
					it.setUpdatedDate(rs.getDate("updatedDate"));
					itemList.add(it);
				}
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}


		});
	}

	public List<Item> findBySubCategoryId(final Long id) {
		String sql = "SELECT b.id as id,title,currentbid,startdate,closedate,estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,winningbidderid,createddate,updateddate FROM subcategory_item A ,item b WHERE b.status = '1' AND A.subCategoryId = ? AND b.id = a.itemid ";
		return this.findAll(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.ps.setLong(1, id);
			}
			@Override
			public List<Item> doResultSet() throws SQLException {
				
				log.debug("[LOG][doResultSet]");
				
				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item();
					it.setId(rs.getLong("id"));
					it.setTitle(rs.getString("title"));
					it.setCurrentBid(rs.getDouble("currentBid"));
					it.setStartDate(rs.getDate("startDate"));
					it.setCloseDate(rs.getDate("closeDate"));
					it.setEstimatedValue(rs.getDouble("estimatedValue"));
					it.setIncrementPrice(rs.getDouble("incrementPrice"));
					it.setStatus(rs.getInt("status"));
					it.setLotDetails(rs.getString("lotDetails"));
					it.setLegalTerms(rs.getString("legalTerms"));
					it.setShipping(rs.getString("shipping"));
					it.setWinningBidderId(rs.getLong("winningBidderId"));
					it.setCreatedDate(rs.getDate("createdDate"));
					it.setUpdatedDate(rs.getDate("updatedDate"));
					itemList.add(it);
				}
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}

		});
	}

	/**
	 * 找出categoryId的全部商品
	 * @param categoryId
	 * @return
	 */
	public List<Item> findByCategoryId(final Long categoryId) {
		String sql = "SELECT x.* FROM ITEM x WHERE x.id in(SELECT d.itemid FROM subcategory_item d WHERE d.subcategoryid IN (SELECT A.ID FROM subcategory A where a.categoryid = ?)) ";
		return this.findAll(sql, new QueryList<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.ps.setLong(1, categoryId);
			}
			@Override
			public List<Item> doResultSet() throws SQLException {
				
				log.debug("[LOG][doResultSet]");
				
				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item();
					it.setId(rs.getLong("id"));
					it.setTitle(rs.getString("title"));
					it.setCurrentBid(rs.getDouble("currentBid"));
					it.setStartDate(rs.getDate("startDate"));
					it.setCloseDate(rs.getDate("closeDate"));
					it.setEstimatedValue(rs.getDouble("estimatedValue"));
					it.setIncrementPrice(rs.getDouble("incrementPrice"));
					it.setStatus(rs.getInt("status"));
					it.setLotDetails(rs.getString("lotDetails"));
					it.setLegalTerms(rs.getString("legalTerms"));
					it.setShipping(rs.getString("shipping"));
					it.setWinningBidderId(rs.getLong("winningBidderId"));
					it.setCreatedDate(rs.getDate("createdDate"));
					it.setUpdatedDate(rs.getDate("updatedDate"));
					itemList.add(it);
				}
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}

		});
	}

}
