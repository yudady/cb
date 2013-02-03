package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.dto.Picture;

public class PictureDao extends BaseDao<Picture> {
	/**
	 * itemId find list
	 * 
	 * @param itemId
	 * @return
	 */
	public List<Picture> findPictureByitemId(final Long itemId) {
		String sql = "select * from Picture where itemId = ? order by priority";
		return this.queryList(sql, new QueryList<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, itemId);
			}

			@Override
			public List<Picture> doResultSet() throws SQLException {
				List<Picture> pictureList = new ArrayList<Picture>();
				while (rs.next()) {
					Picture picture = new Picture(rs.getLong("id"), rs
							.getLong("itemId"), rs.getString("priority"), rs
							.getString("photoPath"), rs.getDate("createdDate"));

					pictureList.add(picture);
				}
				return pictureList;
			}

		});
	}
}
