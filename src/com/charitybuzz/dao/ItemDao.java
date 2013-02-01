package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.domain.Item;

public class ItemDao extends BaseDao<Item> {

	
	
	public List<Item> findAll() {
		String sql = "select id,title from item ";
		
		
		return this.findAll(sql, new ResultSetImpl<Item>() {
			@Override
			public List<Item> doResultSet() throws SQLException {
				
				log.debug("[LOG][doResultSet]");
				
				List<Item> itemList = new ArrayList<Item>();
				while (rs.next()) {
					Item it = new Item();
					it.setId(rs.getLong("id"));
					it.setTitle(rs.getString("title"));
					itemList.add(it);
				}
				log.debug("[LOG][itemList.size()]" + itemList.size());
				return itemList;
			}
		});
	}

}
