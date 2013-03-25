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
import com.charitybuzz.dto.Category;

public class CategoryDao extends BaseDao<Category> {
	

	/**
	 * create Item by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static Category newCategory(ResultSet rs) throws SQLException {
		return new Category(rs.getLong("id"),rs.getString("name"));
	}
	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private List<Category> findList(String sql) {
		return this.queryList(sql, new QueryList<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Category> doResultSet() throws SQLException {
				return CategoryDao.getList(rs);
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
	private static List<Category> getList(ResultSet rs) throws SQLException {
		List<Category> list = new ArrayList<Category>();
		while (rs.next()) {
			Category it = CategoryDao.newCategory(rs);
			list.add(it);
		}
		return list;

	}
	
	
	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private Pager<Category> findPager(String sql) {
		return this.queryPager(sql, new QueryPager<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Category> doResultSet() throws SQLException {
				return CategoryDao.getList(rs);
			}

		});
	}
	
	
	/**
	 * fina all
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		String sql = "select * from category ";
		return this.findList(sql);
	}
	public Pager<Category> findPager() {
		String sql = "SELECT * from category ";
		return this.findPager(sql);
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

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, category.getName());
			}

		});

	}

	public void update(final Category category) {
		String sql = "update category set name=? where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, category.getName());
				this.preparedStatement.setLong(2, category.getId());
			}

		});

	}

	public void delete(final Long categoryId) {
		String sql = "delete from category where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Category>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, categoryId);
			}

		});

	}



}
