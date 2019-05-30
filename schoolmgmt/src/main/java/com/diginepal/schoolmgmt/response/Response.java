package com.diginepal.schoolmgmt.response;

public class Response {
	public static ResponseMessage successful(){
		ResponseMessage response=new ResponseMessage();
		response.setMessage("NO ERROR, OPERATION SUCCESSFUL");
		response.setStatus(true);
		response.setStatusCode(200);
		return response;
	}
	public static ResponseMessage resourcenotfound() {
		ResponseMessage response=new ResponseMessage();
		response.setMessage("RESOURCE NOT FOUND");
		response.setStatus(false);
		response.setStatusCode(404);
		return response;
		
	}
	public static ResponseMessage created() {
		ResponseMessage response=new ResponseMessage();
		response.setMessage("SUCCESSFUL CREATION OF RESOURCE");
		response.setStatus(true);
		response.setStatusCode(201);
		return response;
		
	}
	public static ResponseMessage badrequest() {
		ResponseMessage response=new ResponseMessage();
		response.setMessage("MALFORMED SYNTAX OR A BAD QUERY");
		response.setStatus(false);
		response.setStatusCode(400);
		return response;
		
	}
}
