package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
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
							.getLong("itemId"), rs.getInt("priority"), rs
							.getString("photoPath"), rs.getDate("createdDate"));

					pictureList.add(picture);
				}
				return pictureList;
			}

		});
	}

	/**
	 * 插入圖片
	 * 
	 * @param picture
	 */
	public void insert(final Picture picture) {
		String sql = "insert into picture (ID,ITEMID,PRIORITY,PHOTOPATH,CREATEDDATE) values (seq_picture.nextval,?,?,?,sysdate)";
		this.insertUpdateDelete(sql, new InsertUpdateDelete<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, picture.getItemId());
				this.preparedStatement.setInt(2, picture.getPriority());
				this.preparedStatement.setString(3, picture.getPhotoPath());
			}

		});
	}

	/**
	 * 用id刪除圖片
	 * 
	 * @param picId
	 */
	public void deleteByPK(final Long picId) {
		String sql = "delete from picture where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, picId);
			}
		});

	}

	/**
	 * 用id找圖片
	 * 
	 * @param picId
	 * @return
	 */
	public Picture findByPK(final Long picId) {
		String sql = "select * from Picture where id = ? ";
		return this.queryObject(sql, new QueryObject<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, picId);
			}

			@Override
			public Picture doResultSet() throws SQLException {
				Picture it = null;
				if (rs.next()) {
					it = new Picture(rs.getLong("id"), rs.getLong("itemId"), rs
							.getInt("priority"), rs.getString("photoPath"), rs
							.getDate("createdDate"));
				}
				return it;
			}

		});

	}

	/**
	 * 用id 更新圖片
	 * 
	 * @param picture
	 */
	public void update(final Picture picture) {
		String sql = "update picture set itemId = ? ,priority = ? ,photoPath = ? where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Picture>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, picture.getItemId());
				this.preparedStatement.setInt(2, picture.getPriority());
				this.preparedStatement.setString(3, picture.getPhotoPath());
				this.preparedStatement.setLong(4, picture.getId());
			}

		});

	}
}
