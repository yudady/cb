package com.charitybuzz.service;

import java.util.List;

import com.charitybuzz.dao.OperatorDao;
import com.charitybuzz.dto.Operator;

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

	public List<Operator> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Operator operator) {
		// TODO Auto-generated method stub
		
	}

	public void update(Operator operator) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long operatorId) {
		// TODO Auto-generated method stub
		
	}

}
