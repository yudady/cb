package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Item;

public class ItemDao extends BaseDao<Item> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	public List<Item> findAll() {
		String sql = "select id,title from item ";
		
		
		return this.findAll(sql, new QueryList<Item>() {
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
