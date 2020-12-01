package com.example.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;






@Entity
@Table(name="st_user")
public class UserDTO {
	
	@Column(name="id",unique=true,nullable=false)
    @Id
    @GenericGenerator(name="hiIncrement",strategy="increment")
    @GeneratedValue(generator="hiIncrement")
	protected long id;
	
	@Column(name="firstName",length=200)
	private String firstName;
	
	
	@Column(name ="lastName",length=200)
	private String lastName;
	
	
	@Column(name="login",length=255)
	private String login;
	
	
	@Column(name="password",length=200)
	private String password;
	
	
    @Column(name="confirmPassword",length=200)
	private String confirmPassword;
	
	

    
    @Column(name="address",length=255)
	private String address;
	
	
	
    @Column(name="dob",length=200)
	private Date dob;
	
	

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

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	public String getAddress(){
		return address;
	}
	
		public void setAddress(String address){
		this.address=address;
	}
		public Date getDob() {
		return dob;
	}

		public void setDob(Date dob) {
		this.dob = dob;
	}

		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	
		public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

		public String getValue() {
		// TODO Auto-generated method stub
		return firstName+""+lastName;
	}

}
