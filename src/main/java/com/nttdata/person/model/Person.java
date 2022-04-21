package com.nttdata.person.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "person_type")
public class Person {
	@Id	
	private String personId;
	
	@Field(name = "firstName", write = Field.Write.NON_NULL)
	private String firstName;
	
	@Field(name = "lastName", write = Field.Write.NON_NULL)
	private String lastName;
	
	@Field(name = "documentType", write = Field.Write.NON_NULL)
	private String documentType;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(name = "dateNac", write = Field.Write.NON_NULL)
	private Date dateNac;
	
	@Field(name = "email", write = Field.Write.NON_NULL)
	private String email;
	
	@Field(name = "iphone", write = Field.Write.NON_NULL)
	private String iphone;
	
	@Field(name = "address", write = Field.Write.NON_NULL)
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(name = "createdAt", write = Field.Write.NON_NULL)
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(name = "updatedAt", write = Field.Write.NON_NULL)
	private Date updatedAt;
}
