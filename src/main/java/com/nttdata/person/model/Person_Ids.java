package com.nttdata.person.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Document(collection = "person_ids")
public class Person_Ids {

	private String personTypeId;
	private String personId;
}
