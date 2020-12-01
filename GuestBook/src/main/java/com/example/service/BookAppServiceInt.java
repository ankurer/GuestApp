package com.example.service;

import java.util.List;

import com.example.dto.BookDTO;

public interface BookAppServiceInt {

	
public Long add(BookDTO dto);
	
	public void update(BookDTO dto);
	
	public void delete(Long id);
	
	public List search(BookDTO dto, int pageNo, int pageSize);

	public List search(BookDTO dto);
	
	public BookDTO findByPk(long pk);
}
