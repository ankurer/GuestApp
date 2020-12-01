package com.example.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class BaseDTO {

	@Column(name="id",unique=true,nullable=false)
    @Id
    @GenericGenerator(name="hiIncrement",strategy="increment")
    @GeneratedValue(generator="hiIncrement")
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
