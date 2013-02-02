package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Category;

public class CategoryDao extends BaseDao<Category> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Category> findAll() {
		String sql = "select * from category ";
		return this.findList(sql, new QueryList<Category>() {
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
