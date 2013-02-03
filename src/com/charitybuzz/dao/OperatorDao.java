package com.charitybuzz.dao;

import java.sql.SQLException;

import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.domain.Operator;

public class OperatorDao extends BaseDao<Operator> {
	/**
	 * id find object
	 * 
	 * @param id
	 * @return
	 */
	public Operator findById(final Long id) {
		String sql = "select * from Operator where id = ? ";
		return this.queryObject(sql, new QueryObject<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setLong(1, id);
			}

			@Override
			public Operator doResultSet() throws SQLException {
				Operator it = null;
				if (rs.next()) {
					it = new Operator(rs.getLong("id"), rs.getString("name"),
							rs.getString("passWord"));
				}
				return it;
			}

		});
	}

	public Operator findByName(final String name) {
		String sql = "select * from Operator where name = ? ";
		return this.queryObject(sql, new QueryObject<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				preparedStatement.setString(1, name);
			}

			@Override
			public Operator doResultSet() throws SQLException {
				Operator it = null;
				if (rs.next()) {
					it = new Operator(rs.getLong("id"), rs.getString("name"),
							rs.getString("passWord"));
				}
				return it;
			}

		});
	}

}
