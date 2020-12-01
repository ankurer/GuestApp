package com.example.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.example.dto.UserDTO;
import com.example.util.Util;


public class UserRegistrationForm extends BaseForm {

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	@Email
	private String login;

	@NotEmpty
	private String password;

	@NotEmpty
	private String dob;

	@NotEmpty
	private String address;

		
	@NotEmpty
	private String confirmPassword;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	public UserDTO getDTO() {

		UserDTO dto = new UserDTO();

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setAddress(address);
		dto.setDob(Util.getDate(dob));
		dto.setPassword(password);
		dto.setConfirmPassword(confirmPassword);

		return dto;
	}

	
	public void populate(UserDTO bdto) {

		UserDTO  dto = (UserDTO) bdto;
		
		id= dto.getId();
		firstName= dto.getFirstName();
		lastName= dto.getLastName();
		login= dto.getLogin();
		
		address = dto.getAddress();
		if (dob != null) {
			dob = Util.getDate(dto.getDob());
			System.out.println("dob is----------> "+dob);
		}
		password = dto.getPassword();
		confirmPassword = dto.getConfirmPassword();
	}
}
