package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.common.model.Pager;
import com.charitybuzz.dao.OperatorDao;
import com.charitybuzz.dto.Operator;

/**
 * 後台登入者
 * 
 * @author Administrator
 * 
 */
public class OperatorService {

	private OperatorDao operatorDao;

	public void setOperatorDao(OperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	/**
	 * pk find object
	 * 
	 * @param id
	 * @return
	 */
	public Operator findById(Long id) {
		return operatorDao.findById(id);
	}

	public Operator findByName(String name) {
		return operatorDao.findByName(name);
	}

	/**
	 * find all
	 * 
	 * @return
	 */
	public List<Operator> findAll() {
		return operatorDao.findAll();
	}

	/**
	 * 分頁
	 * 
	 * @return
	 */
	public Pager<Operator> findPager() {
		return operatorDao.findPager();
	}

	/**
	 * insert
	 * 
	 * @param operator
	 */
	public void insert(Operator operator) {
		operatorDao.insert(operator);
	}

	/**
	 * update
	 * 
	 * @param operator
	 */
	public void update(Operator operator) {
		operatorDao.update(operator);
	}

	/**
	 * delete
	 * 
	 * @param operatorId
	 */
	public void delete(Long operatorId) {
		operatorDao.delete(operatorId);
	}

}
