package com.example.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="st_book")
public class BookDTO{

	

	@Column(name="id",unique=true,nullable=false)
    @Id
    @GenericGenerator(name="hiIncrement",strategy="increment")
    @GeneratedValue(generator="hiIncrement")
	protected long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;

	
	private String fileName;
	
	private byte[] data;
	
	private Timestamp createdDateTime;
	
	
	/*private HttpServletRequest httpRequest;
	  
	  private String captchaCode;
	*/  
	
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	/*public String getCaptchaCode() {
	    return captchaCode;
	  }

	  public void setCaptchaCode(String captchaCode) {
	    this.captchaCode = captchaCode;
	  }
	  
	  
	  public HttpServletRequest getHttpRequest() {
	    return httpRequest;
	  }

	  public void setHttpRequest(HttpServletRequest httpRequest) {
	    this.httpRequest = httpRequest;
	  }*/
	
	
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName;
	}
	
}
