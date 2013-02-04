package com.charitybuzz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertOrUpdate;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.dto.Operator;

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

	public List<Operator> findAll() {
		String sql = "select * from operator ";
		return this.queryList(sql, new QueryList<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Operator> doResultSet() throws SQLException {

				List<Operator> operatorList = new ArrayList<Operator>();
				while (rs.next()) {
					Operator it = new Operator(rs.getLong("id"), rs
							.getString("name"), rs.getString("passWord"));
					operatorList.add(it);
				}
				return operatorList;
			}

		});
	}

	public void insert(final Operator operator) {
		String sql = "insert into operator (id,name,passWord) values (seq_operator.nextval,?,?)";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, operator.getName());
				this.preparedStatement.setString(2, operator.getPassWord());
			}

		});

	}

	public void update(final Operator operator) {
		String sql = "update operator set name=? ,passWord=? where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, operator.getId());
				this.preparedStatement.setString(2, operator.getPassWord());
			}

		});

	}

	public void delete(final Long operatorId) {
		String sql = "delete from operator where id = ?";

		this.insertUpdateDelete(sql, new InsertOrUpdate<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, operatorId);
			}

		});

	}

}
