package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Category;

public class CategoryDao extends BaseDao<Category> {
	/**
	 * fina all
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		String sql = "select * from category ";
		return this.queryList(sql, new QueryList<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Category> doResultSet() throws SQLException {
				List<Category> categoryList = new ArrayList<Category>();
				while (rs.next()) {
					Category it = new Category();
					it.setId(rs.getLong("id"));
					it.setName(rs.getString("name"));
					categoryList.add(it);
				}
				return categoryList;
			}

		});
	}

	public Category findById(final Long categoryId) {
		String sql = "select * from Category where id = ? ";
		return this.queryObject(sql, new QueryObject<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, categoryId);
			}

			@Override
			public Category doResultSet() throws SQLException {
				Category it = null;
				if (rs.next()) {
					it = new Category(rs.getLong("id"), rs.getString("name"));
				}
				return it;
			}

		});
	}

	public void insert(final Category category) {
		String sql = "insert into category (id,name) values (seq_category.nextval,?)";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, category.getName());
			}

		});

	}

	public void update(final Category category) {
		String sql = "update category set name=? where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, category.getName());
				this.preparedStatement.setLong(2, category.getId());
			}

		});

	}

	public void delete(final Long categoryId) {
		String sql = "delete from category where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, categoryId);
			}

		});

	}

}
