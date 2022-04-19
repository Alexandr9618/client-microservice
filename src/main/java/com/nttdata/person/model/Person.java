package com.nttdata.person.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Document(collection = "person")
public class Person {
	@Id
	private String personId;
	private String firstName;
	private String lastName;
	private String documentType;
	private Date dateNac;
	private String email;
	private String iphone;
	private String address;
	private Date createdAt;
	private Date updatedAt;
}
