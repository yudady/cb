package com.charitybuzz.service;

import com.charitybuzz.dao.OperatorDao;
import com.charitybuzz.domain.Operator;

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

}
