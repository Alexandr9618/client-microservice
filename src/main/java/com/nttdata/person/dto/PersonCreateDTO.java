package com.nttdata.person.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.nttdata.person.util.Constant;

import lombok.Data;

@Data
public class PersonCreateDTO {

	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String firstName;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String lastName;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String documentType;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String document;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private Date dateNac;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String email;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String iphone;
	
	@NotNull(message=Constant.EMPTY_NULL_FIELD)
	@NotEmpty(message=Constant.EMPTY_NULL_FIELD)
	private String address;
}
