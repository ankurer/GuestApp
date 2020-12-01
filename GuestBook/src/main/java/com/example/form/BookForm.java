package com.example.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.BookDTO;

public class BookForm extends BaseForm{

	@NotEmpty
    private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phoneNumber;
	
    private String fileName;
	
	private byte[] data;
	
	private MultipartFile file;
	 
	private long createdDateTime; 

	   public long getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(long createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public MultipartFile getFile() {
	      return file;
	   }

	   public void setFile(MultipartFile file) {
	      this.file = file;
	   }
	
	/*private HttpServletRequest httpRequest;
	  
	  private String captchaCode;
	  */

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
	  }

	  public boolean isCaptchaVerified() {
	    if (this.httpRequest == null) {
	      return false;
	    }
	    
	    HttpSession session = httpRequest.getSession();
	    if (session == null) {
	      return false;
	    }
	    
	    return (session.getAttribute("captchaVerified") != null);
	  }
*/
	
	public BookDTO getDTO(){
		
		BookDTO dto = new BookDTO();
		
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		//dto.setCaptchaCode(captchaCode);
		//dto.setHttpRequest(httpRequest);
		
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		return dto;
		
	}
	
	@Override	
    public void populate(BookDTO bdto){
		
	BookDTO dto = new BookDTO();
	
	id = dto.getId();
	firstName= dto.getFirstName();
	lastName = dto.getLastName();
	email= dto.getEmail();
	phoneNumber= dto.getPhoneNumber();
	
	if(createdDateTime!=0 || dto.getCreatedDateTime()!=null){
	createdDateTime = dto.getCreatedDateTime().getTime();
	}
	//captchaCode= dto.getCaptchaCode();
	//httpRequest= dto.getHttpRequest();
	}
}
