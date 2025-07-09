package com.demo.spring.util;

public class ResponseMessage {

	private String status;

	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}

	public ResponseMessage(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
