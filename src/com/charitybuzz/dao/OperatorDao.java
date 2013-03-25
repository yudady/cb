package com.charitybuzz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.charitybuzz.common.dao.BaseDao;
import com.charitybuzz.common.dao.InsertUpdateDelete;
import com.charitybuzz.common.dao.QueryList;
import com.charitybuzz.common.dao.QueryObject;
import com.charitybuzz.common.dao.QueryPager;
import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dto.Operator;

public class OperatorDao extends BaseDao<Operator> {

	/**
	 * create Item by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static Operator newOperator(ResultSet rs) throws SQLException {
		return new Operator(rs.getLong("id"), rs.getString("name"),
				rs.getString("passWord"));
	}

	/**
	 * create list by ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static List<Operator> getList(ResultSet rs) throws SQLException {
		List<Operator> list = new ArrayList<Operator>();
		while (rs.next()) {
			Operator it = OperatorDao.newOperator(rs);
			list.add(it);
		}
		return list;

	}

	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private List<Operator> findList(String sql) {
		return this.queryList(sql, new QueryList<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Operator> doResultSet() throws SQLException {
				return OperatorDao.getList(rs);
			}

		});
	}

	/**
	 * find List<Auction>
	 * 
	 * @return
	 */
	private Pager<Operator> findPager(String sql) {
		return this.queryPager(sql, new QueryPager<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
			}

			@Override
			public List<Operator> doResultSet() throws SQLException {
				return OperatorDao.getList(rs);
			}

		});
	}

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

	/**
	 * find all
	 * @return
	 */
	public List<Operator> findAll() {
		String sql = "select * from operator ";
		return this.findList(sql);
	}

	/**
	 * 分頁
	 * 
	 * @return
	 */
	public Pager<Operator> findPager() {
		String sql = "select * from operator ";
		return this.findPager(sql);
	}

	public void insert(final Operator operator) {
		String sql = "insert into operator (id,name,passWord) values (seq_operator.nextval,?,?)";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, operator.getName());
				this.preparedStatement.setString(2, operator.getPassWord());
			}

		});

	}

	public void update(final Operator operator) {
		String sql = "update operator set name=? ,passWord=? where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setString(1, operator.getName());
				this.preparedStatement.setString(2, operator.getPassWord());
				this.preparedStatement.setLong(3, operator.getId());
			}

		});

	}

	public void delete(final Long operatorId) {
		String sql = "delete from operator where id = ?";

		this.insertUpdateDelete(sql, new InsertUpdateDelete<Operator>() {
			@Override
			public void doPreparedStatement() throws SQLException {
				this.preparedStatement.setLong(1, operatorId);
			}

		});

	}

}
