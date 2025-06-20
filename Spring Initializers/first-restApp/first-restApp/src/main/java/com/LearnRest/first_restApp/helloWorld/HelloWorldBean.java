package com.LearnRest.first_restApp.helloWorld;


public class HelloWorldBean {
	private String Message;

	public HelloWorldBean(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [Message=" + Message + "]";
	}
	
	
}
