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
@Document(collection = "person_types")
public class Person_Type {
	
	@Id
	private String personTypeId;
	
	@Field(name = "name", write = Field.Write.NON_NULL)
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(name = "created_at", write = Field.Write.NON_NULL)
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(name = "updated_at", write = Field.Write.NON_NULL)
	private Date updatedAt;
}
