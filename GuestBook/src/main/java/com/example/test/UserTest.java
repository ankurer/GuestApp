package com.example.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.exception.RecordNotFoundException;
import com.example.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class UserTest {

	@Autowired
	private UserServiceInt model=null;
	
	@Test
	public void add() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		UserDTO dto = new UserDTO();

		dto.setFirstName("Ankur");
		dto.setLastName("Agarwal");
		dto.setLogin("ankur28@gmail.com");
		dto.setPassword("4444");
		dto.setDob(sdf.parse("31-12-1990"));
				long pk=0;
		try {
			pk = model.add(dto);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("pk is" + pk);
	}

	@Ignore
	public void delete() {

		UserDTO dto = new UserDTO();

		dto.setId(2);

		 try {
			model.delete(2L);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	@Ignore
	public void update() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		UserDTO dto = new UserDTO();

		dto.setId(1);

		dto.setFirstName("Ankur");
		dto.setLastName("Agarwal");
		dto.setLogin("ankur2@gmail.com");
		dto.setPassword("ankur");
		dto.setDob(sdf.parse("31-12-1990"));
		dto.setConfirmPassword("ankur");

		
		try {
			model.update(dto);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	public void findbypk() {

		UserDTO dto = new UserDTO();

		dto = model.findByPk(1);

		if (dto != null) {

			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());

		}
	}

	@Ignore
	public void findByemail() {

		UserDTO dto = new UserDTO();

		dto = model.findByEmail("ankur2@gmail.com");

		if (dto != null) {

			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());

		}
	}

	@Ignore
	public void search() {

		List list = new ArrayList();

		UserDTO dto = new UserDTO();

		list = model.search(dto, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();

			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getId());
		}

	}

	@Ignore
	public void list() {

		List list = new ArrayList();

		UserDTO dto = new UserDTO();

		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();

			System.out.println(dto.getDob());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getId());
		}
	}
	
	@Ignore
	public void authenticate(){
		
		UserDTO dto = new UserDTO();
		
		dto=model.authenticate("ankur2@gmail.com", "ankur");
		
		if(dto!=null){
			System.out.println("login successfully");
		}
		else{
			System.out.println("not a valid user");
		}
	}

}
