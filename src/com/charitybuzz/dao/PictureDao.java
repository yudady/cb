package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.domain.Picture;

public class PictureDao extends BaseDao<Picture> {

	/** logger. */
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	public List<Picture> findPictureByitemId(final Long itemId) {
		String sql = "select * from Picture where itemId = ? order by priority";
		return this.findList(sql, new QueryList<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				ps.setLong(1, itemId);
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
