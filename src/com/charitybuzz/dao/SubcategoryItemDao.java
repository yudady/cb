package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.dto.SubcategoryItem;

public class SubcategoryItemDao extends BaseDao<SubcategoryItem> {
	/**
	 * itemId find list
	 * 
	 * @param itemId
	 * @return
	 */
	public List<SubcategoryItem> findByItemId(final Long itemId) {
		String sql = "select * from subcategory_item where itemId = ? ";
		return this.queryList(sql, new QueryList<SubcategoryItem>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public List<SubcategoryItem> doResultSet() throws SQLException {
				List<SubcategoryItem> SubcategoryItemList = new ArrayList<SubcategoryItem>();
				while (rs.next()) {
					SubcategoryItem it = new SubcategoryItem(rs.getLong("id"),
							rs.getLong("itemId"), rs.getLong("subCategoryId"));

					SubcategoryItemList.add(it);
				}
				return SubcategoryItemList;
			}

		});
	}

	public void insert(final Long itemId,final Long subCategoryId) {
		String sql = "insert into subcategory_item (id,itemId,subCategoryId) values (seq_subcategory_item.nextval,?,?)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<SubcategoryItem>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, itemId);
				this.preparedStatement.setLong(2,subCategoryId);
			}

		});

	}

	public void deleteByItemId(final Long itemId) {
		String sql = "delete from subcategory_item where itemId = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<SubcategoryItem>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, itemId);
			}

		});
		
	}
}
