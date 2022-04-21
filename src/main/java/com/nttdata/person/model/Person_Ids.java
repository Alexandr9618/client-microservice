package com.nttdata.person.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "person_ids")
public class Person_Ids {
	
	@Id
	private String personIdsId;
	
	@Field(name = "personTypeId", write = Field.Write.NON_NULL)
	private String  personTypeId;
	
	@Field(name = "personId", write = Field.Write.NON_NULL)
	private String  personId;
}
