package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Category;

public class CategoryDao extends BaseDao<Category> {

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

}
