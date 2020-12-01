package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.exception.RecordNotFoundException;

@Repository
public class UserDAOHibImpl implements UserDAOInt{

	@Autowired
	private SessionFactory sessionFactory=null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public long add(UserDTO dto) throws ApplicationException, DuplicateRecordException {

		UserDTO dtoexist = findByEmail(dto.getLogin());
		
		
		if(dtoexist!=null){
			throw new DuplicateRecordException("User already exist");
		}
		

        long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		
        System.out.println("data inserted"+pk);
        return pk;
        
	}

	

	public void update(UserDTO dto) throws ApplicationException {
		sessionFactory.getCurrentSession().update(dto);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
       
		List list = new ArrayList();
		
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		
		if(dto!=null){
			
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0){
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
				
			}
			
			else if(dto.getLastName()!=null && dto.getLastName().length()>0){
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
				
			}
			
			else if(dto.getLogin()!=null && dto.getLogin().length()>0){
				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
			}
			
		}
		
		if(pageSize>0){
			pageNo = (pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		
		list = criteria.list();
		
		return list;
	}

	public List search(UserDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	public List list(int pageNo, int pageSize) {
       
		List list = new ArrayList();
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		
		if(pageSize>0){
			pageNo = (pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
			
 		}
		
		list = criteria.list();
		
		return list;

	}

	public List list() {
		return list(0,0);
	}

	public UserDTO authenticate(String email, String pass) {
         
		UserDTO dto =null;
		
		List list=   sessionFactory.getCurrentSession()
		             .createCriteria(UserDTO.class)
		             .add(Restrictions.like("login", email))
		             .add(Restrictions.like("password", pass)).list();
		
		if(list.size()>0){
			dto = (UserDTO)list.get(0);
		}
		
		else{
			dto = null;
		}
		
		return dto;
	}

	public UserDTO findByEmail(String email) {
        UserDTO dto = null;
		
		List list  = sessionFactory.getCurrentSession()
				.createCriteria(UserDTO.class)
				.add(Restrictions.like("login", email))
				.list();
		
		if(list.size()>0){
			dto = (UserDTO)list.get(0);
		}
		
		return dto;
	}


	public UserDTO findByPk(long pk) {
       
		UserDTO dto = null;
		
		dto = sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		
		System.out.println("find by pk called");
		return dto;
	}


	public void delete(UserDTO dto) throws ApplicationException, RecordNotFoundException {
		UserDTO dtoexist = findByPk(dto.getId());
		if(dtoexist==null){
			throw new RecordNotFoundException("user does not exist");
		}
		
		sessionFactory.getCurrentSession().delete(dto);
		
		System.out.println("record deleted");

	}

}
