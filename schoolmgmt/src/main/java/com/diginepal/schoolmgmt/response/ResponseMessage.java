package com.diginepal.schoolmgmt.response;

import java.util.Map;

import lombok.Data;

public class ResponseMessage {
private int statusCode;
private boolean status;
private String message;
private Map<String, String> errors;
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Map<String, String> getErrors() {
	return errors;
}
public void setErrors(Map<String, String> errors) {
	this.errors = errors;
}


}
