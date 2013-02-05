package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.dto.SubCategory;

public class SubCategoryDao extends BaseDao<SubCategory> {
	/**
	 * find all
	 * 
	 * @return
	 */
	public List<SubCategory> findAll() {
		String sql = "select * from SubCategory ";
		return this.queryList(sql, new QueryList<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<SubCategory> doResultSet() throws SQLException {
				List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
				while (rs.next()) {
					SubCategory it = new SubCategory();
					it.setId(rs.getLong("id"));
					it.setName(rs.getString("name"));
					subCategoryList.add(it);
				}
				return subCategoryList;
			}

		});
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
				List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
				while (rs.next()) {
					SubCategory it = new SubCategory();
					it.setId(rs.getLong("id"));
					it.setCategoryId(rs.getLong("categoryId"));
					it.setName(rs.getString("name"));
					it.setDescript(rs.getString("descript"));
					subCategoryList.add(it);
				}
				return subCategoryList;
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
		this.insertUpdateDelete(sql, new InsertOrUpdate<SubCategory>() {
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

		this.insertUpdateDelete(sql, new InsertOrUpdate<SubCategory>() {
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

		this.insertUpdateDelete(sql, new InsertOrUpdate<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, subCategoryId);
			}

		});

	}

}
