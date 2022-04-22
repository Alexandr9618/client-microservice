package com.nttdata.person.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSupplierDTO {
	private String personId;
	private String firstName;
	private String lastName;
	private String documentType;
	private String document;
	private Date dateNac;
	private String email;
	private String iphone;
	private String address;	
	private Date createdAt;
	private Date updatedAt;
}
