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

	public List<Picture> findAll() {
		String sql = "select * from Picture ";
		return this.findAll(sql, new QueryList<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Picture> doResultSet() throws SQLException {
				List<Picture> pictureList = new ArrayList<Picture>();
				while (rs.next()) {
					Picture it = new Picture();
					pictureList.add(it);
				}
				return pictureList;
			}

		});
	}

}
