package com.example.sistemadepedidos.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String msg;
	private Integer Status;
	private Long timeStamp;
	
	public StandardError() {
		
	}

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.msg = msg;
		Status = status;
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	

}
