package com.test.entelgy.dto.response;

import org.springframework.http.HttpStatus;

public class Response<E> {
    private HttpStatus status;
    private String message;
    private  E payload;
	
    public Response(  HttpStatus status, String message, E payload){
      this.status=status;
      this.message=message;
      this.payload=payload;
    }  
    public Response( HttpStatus status, String message, E payload,String value){
      this.status=status;
      this.message=message;
      this.payload=payload;

    }
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public E getPayload() {
		return payload;
	}
	public void setPayload(E payload) {
		this.payload = payload;
	}  
    
}
