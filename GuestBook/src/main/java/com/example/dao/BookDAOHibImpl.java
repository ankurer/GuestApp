package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.BookDTO;




@Repository
public class BookDAOHibImpl implements BookDAOInt{

	@Autowired
	private SessionFactory sessionFactory=null;
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	public Long add(BookDTO dto) {
		// TODO Auto-generated method stub
		
	Long pk=(Long)sessionFactory.getCurrentSession().save(dto);	  
		
	
		return pk;
	}

	public void update(BookDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
		
		System.out.println("record updated");
	}

	public void delete(BookDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
		System.out.println("record deleted");
	}


	public List search(BookDTO dto, int pageNo, int pageSize) {
    
		List list = new ArrayList();
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BookDTO.class);
		
		
		if(pageSize>0){
			pageNo = (pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		
		list = criteria.list();
		
		return list;
	}


	public List search(BookDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}


	public BookDTO findByPk(long pk) {
        BookDTO dto = null;
		
		dto = sessionFactory.getCurrentSession().get(BookDTO.class,pk);
		System.out.println("find by pk called");
		return dto;
	}

	
	
	
}
