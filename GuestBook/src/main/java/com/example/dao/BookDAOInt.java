package com.example.dao;

import java.util.List;

import com.example.dto.BookDTO;




public interface BookDAOInt {

	
	public Long add(BookDTO dto);
	
	public void update(BookDTO dto);
	
	public void delete(BookDTO dto);
	
	public List search(BookDTO dto, int pageNo, int pageSize);

	public List search(BookDTO dto);
	
	public BookDTO findByPk(long pk);
}
