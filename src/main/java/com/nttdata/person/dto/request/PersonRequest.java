package com.nttdata.person.dto.request;


import lombok.Data;

@Data
public class PersonRequest {
	private String firstName;
	private String lastName;
	private String documentType;
	private String document;
	private String dateNac;
	private String email;
	private String iphone;
	private String address;	
	private String createdAt;
	private String updatedAt;
}
