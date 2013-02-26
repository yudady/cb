package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
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

	public Pager<Item> findAllByPager() {
		String sql = " Select * from item ";
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

	public Pager<Item> findPagerBySubCategoryId(final Long subCategoryId) {
		String sql = "SELECT b.id as id,title,currentbid,startdate,closedate,estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,winningbidderid,createddate,updateddate FROM subcategory_item A ,item b WHERE b.status = '1' AND A.subCategoryId = ? AND b.id = a.itemid ";
		return this.queryPager(sql, new QueryPager<Item>() {
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
	 * 找出categoryId的全部商品
	 * 
	 * @param categoryId
	 * @return
	 */
	public Pager<Item> findPagerByCategoryId(final Long categoryId) {
		String sql = "SELECT x.* FROM ITEM x WHERE x.id in(SELECT d.itemid FROM subcategory_item d WHERE d.subcategoryid IN (SELECT A.ID FROM subcategory A where a.categoryid = ? )) ";
		return this.queryPager(sql, new QueryPager<Item>() {
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

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Item>() {

			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, id);
			}

		});
	}

	public void insert(final Item item) {

		String sql = "insert into item (id,title,currentbid,startdate,closedate,"
				+ "estimatedvalue,incrementprice,status,lotdetails,legalterms,shipping,"
				+ "winningbidderid,createddate,updateddate,auctionId) values (?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate,?)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Item>() {
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
				this.preparedStatement.setLong(13, item.getAuctionId());
			}

		});

	}

	public void update(final Item item) {
		String sql = "update item set title = ? ,currentBid = ? ,startDate = ? ,"
				+ " closeDate = ? , estimatedValue = ? , incrementPrice = ? ,"
				+ " status = ? , lotDetails = ? , legalTerms = ? , "
				+ " shipping = ? , winningBidderId = ? , updatedDate = sysdate where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Item>() {
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

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, itemId);
			}

		});

	}

	public List<Item> findClosingNext(int firstRowNumber, int lastRowNumber) {
		String sql = "Select * from ( SELECT (closedate - SYSDATE ) diff , it.* FROM item it WHERE it.status = 1 AND it.startdate < SYSDATE order by diff ) WHERE diff >= 0 ";
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

	public List<Item> findByHotDeals(int firstRowNumber, int lastRowNumber) {
		String sql = " SELECT it.* FROM item it WHERE status = '1' AND SYSDATE >= startdate and closedate >= SYSDATE order by (ESTIMATEDVALUE - CURRENTBID) desc ";
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

	public List<Item> findPopular(int firstRowNumber, int lastRowNumber) {
		String sql = " SELECT count(lo.id) cc ,it.id ,it.title,it.CURRENTBID ,it.STARTDATE ,it.CLOSEDATE ,it.ESTIMATEDVALUE ,it.INCREMENTPRICE ,it.STATUS ,it.LOTDETAILS ,it.LEGALTERMS ,it.SHIPPING ,it.WINNINGBIDDERID ,it.CREATEDDATE ,it.UPDATEDDATE FROM item it left join bidlog lo on lo.ITEMID = it.id WHERE status = '1' AND SYSDATE >= startdate AND closedate >= SYSDATE GROUP BY it.ID, it.title, it.CURRENTBID, it.STARTDATE, it.CLOSEDATE, it.ESTIMATEDVALUE, it.INCREMENTPRICE, it.STATUS, it.LOTDETAILS, it.LEGALTERMS, it.SHIPPING, it.WINNINGBIDDERID, it.CREATEDDATE, it.UPDATEDDATE order by cc desc ";
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

	public List<Item> findRecentAdd(int firstRowNumber, int lastRowNumber) {
		String sql = " SELECT * FROM item WHERE status = '1' AND STARTDATE <= SYSDATE and closedate >= sysdate order by (STARTDATE - sysdate) desc ";
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

	/**
	 * 分頁 最接近結標日的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByClosingNext() {
		String sql = " Select * from ( SELECT (closedate - SYSDATE ) diff , it.* FROM item it WHERE it.status = 1 AND it.startdate < SYSDATE order by diff ) WHERE diff >= 0 ";
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
	 * 分頁 差價最大的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByHotDeals() {
		String sql = " SELECT it.* FROM item it WHERE status = '1' AND SYSDATE >= startdate and closedate >= SYSDATE order by (ESTIMATEDVALUE - CURRENTBID) desc ";
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
	 * 分頁 最受歡迎的商品列表
	 * 
	 * @return
	 */
	public Pager<Item> findPagerByPopular() {
		String sql = " SELECT count(lo.id) cc ,it.id ,it.title,it.CURRENTBID ,it.STARTDATE ,it.CLOSEDATE ,it.ESTIMATEDVALUE ,it.INCREMENTPRICE ,it.STATUS ,it.LOTDETAILS ,it.LEGALTERMS ,it.SHIPPING ,it.WINNINGBIDDERID ,it.CREATEDDATE ,it.UPDATEDDATE FROM item it left join bidlog lo on lo.ITEMID = it.id WHERE status = '1' AND SYSDATE >= startdate AND closedate >= SYSDATE GROUP BY it.ID, it.title, it.CURRENTBID, it.STARTDATE, it.CLOSEDATE, it.ESTIMATEDVALUE, it.INCREMENTPRICE, it.STATUS, it.LOTDETAILS, it.LEGALTERMS, it.SHIPPING, it.WINNINGBIDDERID, it.CREATEDDATE, it.UPDATEDDATE order by cc desc ";
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

	public Pager<Item> findPagerByRecentAdd() {
		String sql = " SELECT * FROM item WHERE status = '1' AND STARTDATE <= SYSDATE and closedate >= sysdate order by (STARTDATE - sysdate) desc ";
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

	public Pager<Item> findByKeyWord(final String keyWord) {
		log.debug("[LOG][findByKeyWord]");

		String sql = "  SELECT * FROM item  WHERE status = '1' AND "
				+ "STARTDATE <= SYSDATE AND closedate >= SYSDATE  and (title like ? or lotdetails like ?) ";
		return this.queryPager(sql, new QueryPager<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, "%" + keyWord + "%");
				this.preparedStatement.setString(2, "%" + keyWord + "%");
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

	public Pager<Item> findPagerByAuctioneerId(final Long auctioneerId) {
		String sql = " SELECT * FROM item WHERE status = '1' AND STARTDATE <= SYSDATE and closedate >= sysdate and auctioneerId = ? ";
		return this.queryPager(sql, new QueryPager<Item>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, auctioneerId);
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

	public Pager<Item> findPager() {
		String sql = " SELECT * FROM item WHERE status = '1' AND STARTDATE <= SYSDATE and closedate >= sysdate ";
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

}
