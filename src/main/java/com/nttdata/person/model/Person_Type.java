package com.nttdata.person.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Document(collection = "person_type")
public class Person_Type {
	@Id
	private String personTypeId;
	private String name;
	private Date createdAt;
	private Date updatedAt;
}
