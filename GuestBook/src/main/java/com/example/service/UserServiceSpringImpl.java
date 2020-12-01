package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAOInt;
import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.exception.RecordNotFoundException;

@Service
public class UserServiceSpringImpl implements UserServiceInt {

	
	@Autowired
	private UserDAOInt dao=null;
	
	public void setDao(UserDAOInt dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws ApplicationException,DuplicateRecordException{
		// TODO Auto-generated method stub
		
		
		
		return dao.add(dto);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(Long id) throws RecordNotFoundException {
		
		
		UserDTO dto = findByPk(id);
		
		try {
			dao.delete(dto);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto)throws ApplicationException {

		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO findByPk(long pk) {

		return dao.findByPk(pk);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.list(pageNo, pageSize);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO authenticate(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.authenticate(email, pass);
	}


	

}
