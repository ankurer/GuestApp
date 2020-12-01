package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BookDAOInt;
import com.example.dto.BookDTO;

@Service
public class BookAppSpringImpl implements BookAppServiceInt{

	@Autowired
	private BookDAOInt dao;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Long add(BookDTO dto) {
		// TODO Auto-generated method stub
		return dao.add(dto);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void update(BookDTO dto) {
	
		dao.update(dto);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(Long id) {
		
		BookDTO dto = findByPk(id);
		
		dao.delete(dto);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List search(BookDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List search(BookDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}
	
    @Transactional
	public BookDTO findByPk(long pk) {
		// TODO Auto-generated method stub
		return dao.findByPk(pk);
	}

}
