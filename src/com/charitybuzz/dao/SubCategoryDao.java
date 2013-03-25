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
import com.charitybuzz.dto.SubCategory;

public class SubCategoryDao extends BaseDao<SubCategory> {

	/**
	 * create Item by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static SubCategory newSubCategory(ResultSet rs) throws SQLException {
		return new SubCategory(rs.getLong("id"), rs.getLong("categoryId"),
				rs.getString("name"), rs.getString("descript"));
	}

	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private List<SubCategory> findList(String sql) {
		return this.queryList(sql, new QueryList<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<SubCategory> doResultSet() throws SQLException {
				return SubCategoryDao.getList(rs);
			}

		});
	}

	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private Pager<SubCategory> findPager(String sql) {
		return this.queryPager(sql, new QueryPager<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<SubCategory> doResultSet() throws SQLException {
				return SubCategoryDao.getList(rs);
			}

		});
	}

	/**
	 * create list by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static List<SubCategory> getList(ResultSet rs) throws SQLException {
		List<SubCategory> list = new ArrayList<SubCategory>();
		while (rs.next()) {
			SubCategory it = SubCategoryDao.newSubCategory(rs);
			list.add(it);
		}
		return list;

	}

	/**
	 * find all
	 * 
	 * @return
	 */
	public List<SubCategory> findAll() {
		String sql = "select * from SubCategory ";
		return this.findList(sql);
	}

	public Pager<SubCategory> findPager() {
		String sql = "select * from SubCategory ";
		return this.findPager(sql);
	}

	/**
	 * categoryId find list
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<SubCategory> findByCategoryId(final Long categoryId) {
		String sql = "select * from SubCategory where categoryId = ?";
		return this.queryList(sql, new QueryList<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, categoryId);
			}

			@Override
			public List<SubCategory> doResultSet() throws SQLException {
				return SubCategoryDao.getList(rs);
			}

		});
	}

	public SubCategory findById(final Long subCategoryId) {
		String sql = "select * from SubCategory where id = ? ";
		return this.queryObject(sql, new QueryObject<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, subCategoryId);
			}

			@Override
			public SubCategory doResultSet() throws SQLException {
				SubCategory it = null;
				if (rs.next()) {
					it = new SubCategory(rs.getLong("id"), rs
							.getLong("categoryId"), rs.getString("name"), rs
							.getString("descript"));
				}
				return it;
			}

		});
	}

	public void insert(final SubCategory subCategory) {
		String sql = "insert into subCategory (id,categoryId,name,descript) values (seq_subcategory.nextval,?,?,?)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subCategory.getCategoryId());
				this.preparedStatement.setString(2, subCategory.getName());
				this.preparedStatement.setString(3, subCategory.getDescript());
			}

		});

	}

	public void update(final SubCategory subCategory) {
		String sql = "update subCategory set categoryId=? ,name=?,descript=? where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subCategory.getCategoryId());
				this.preparedStatement.setString(2, subCategory.getName());
				this.preparedStatement.setString(3, subCategory.getDescript());
				this.preparedStatement.setLong(4, subCategory.getId());
			}

		});

	}

	public void delete(final Long subCategoryId) {
		String sql = "delete from subCategory where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subCategoryId);
			}

		});

	}

	public List<SubCategory> findByItemd(final Long itemId) {
		String sql = " SELECT * FROM subcategory WHERE ID IN (SELECT subcategoryid FROM subcategory_item where itemid = ?) ";
		return this.queryList(sql, new QueryList<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public List<SubCategory> doResultSet() throws SQLException {
				return SubCategoryDao.getList(rs);
			}

		});
	}

}
