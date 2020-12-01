package com.example.form;

import com.example.dto.BookDTO;

public class BaseForm {

	protected long id=0;
	
	protected int pageNo=1;
	
	private Long[] chk_1;	
	
	protected String operation;
	
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long[] getChk_1() {
		return chk_1;
	}

	public void setChk_1(Long[] chk_1) {
		this.chk_1 = chk_1;
	}

	protected int pageSize=5;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

		
	public void populate(BookDTO bdto){
		
	}
	
}
