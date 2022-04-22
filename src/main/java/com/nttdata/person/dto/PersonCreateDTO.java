package com.nttdata.person.dto;

import java.util.Date;
import com.nttdata.person.util.Constant;

import lombok.Data;

@Data
public class PersonCreateDTO {

	@NotNull(message = Constant.EMPTY_NULL_FIELD)
	private String firstName;
	private String lastName;
	private String documentType;
	private String document;
	private Date dateNac;
	private String email;
	private String iphone;
	private String address;
	private Date createdAt;
}
