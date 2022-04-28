package com.nttdata.person.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "persons")
public class Person {
	@Id	
	private String personId;
	
	@Field(name = "first_name", write = Field.Write.NON_NULL)
	private String firstName;
	
	@Field(name = "last_name", write = Field.Write.NON_NULL)
	private String lastName;
	
	@Field(name = "document_type", write = Field.Write.NON_NULL)
	private String documentType;
	
	@Field(name = "document", write = Field.Write.NON_NULL)
	private String document;
	
	@Field(name = "birth_date", write = Field.Write.NON_NULL)
	private String birthDate;
	
	@Field(name = "email", write = Field.Write.NON_NULL)
	private String email;
	
	@Field(name = "iphone", write = Field.Write.NON_NULL)
	private String iphone;
	
	@Field(name = "address", write = Field.Write.NON_NULL)
	private String address;
	
	@Field(name = "created_at")
	private Date createdAt;
	
	@Field(name = "updated_at")
	private Date updatedAt;

	@Field(name = "person_type", write = Field.Write.NON_NULL)
	private PersonType personType;

	
	public Person(String firstName, String lastName, String documentType, String document, String birthDate, String email,
			String iphone, String address, Date createdAt, Date updatedAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.documentType = documentType;
		this.document = document;
		this.birthDate = birthDate;
		this.email = email;
		this.iphone = iphone;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	
}
