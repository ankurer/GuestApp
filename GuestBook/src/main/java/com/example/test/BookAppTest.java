package com.example.test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dto.BookDTO;
import com.example.service.BookAppServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class BookAppTest {

	@Autowired
	private BookAppServiceInt model=null;
	
	
	@Test
	public void add() {

		BookDTO dto = new BookDTO();

		dto.setFirstName("Ankur");
		dto.setLastName("Agarwal");
		dto.setEmail("ankur@gmail.com");
		dto.setPhoneNumber("56789");
		
		model.add(dto);
	}

	
	@Ignore
	public void update() {

		BookDTO dto = new BookDTO();

		dto.setId(2);
		
		dto.setFirstName("Ankit");
		dto.setLastName("Agarwal");
		dto.setEmail("ankur@gmail.com");
		dto.setPhoneNumber("56789");
		
		model.update(dto);
	}
	
	
	@Ignore
	public void list(){
		
		List list = new ArrayList();
		
		BookDTO dto = new BookDTO();
		
		list = model.search(dto, 1, 10);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (BookDTO) it.next();
			
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			
		}
		
	}

	
	@Ignore
	public void delete(){
	
		BookDTO dto = new BookDTO();
		dto.setId(2);
		model.delete(2L);
	}
	
}
