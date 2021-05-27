package com.hcl.employees.util;

public class UserInputException extends Exception {
	private static final long serialVersionUID = 1L;
	 private String msg;
	 public UserInputException(String msg) {
	  this.msg=msg;
	 }
	 public String getMessage() {
	  return msg;
	 }

}
