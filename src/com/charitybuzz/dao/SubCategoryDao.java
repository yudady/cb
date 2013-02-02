package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.SubCategory;

public class SubCategoryDao extends BaseDao<SubCategory> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<SubCategory> findAll() {
		String sql = "select * from SubCategory ";
		return this.findList(sql, new QueryList<SubCategory>() {
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

	public List<SubCategory> findByCategoryId(final Long categoryId) {
		String sql = "select * from SubCategory where categoryId = ?";
		return this.findList(sql, new QueryList<SubCategory>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				ps.setLong(1, categoryId);
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

}
