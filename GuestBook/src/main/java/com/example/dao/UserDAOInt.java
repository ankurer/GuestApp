package com.example.dao;

import java.util.List;

import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.exception.RecordNotFoundException;


public interface UserDAOInt  {
	
	public long add(UserDTO dto) throws ApplicationException,DuplicateRecordException ;
	
	public void delete(UserDTO dto)throws ApplicationException,RecordNotFoundException;

	public void update(UserDTO dto)throws ApplicationException;
	
	public UserDTO findByEmail(String email);
	
	public UserDTO findByPk(long pk);
	
	public List search(UserDTO dto,int pageNo,int pageSize);
	
	public List search(UserDTO dto);
	
	public List list(int pageNo,int pageSize);
	
	public List list();
	
	public UserDTO authenticate(String email,String pass);
	
	
	
}
