package com.nttdata.person.dto.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alexander Valerio
 *
 */
@AllArgsConstructor
@Data
public class ClientResponse {

	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "firstName")
	private String firstName;
	
	@JsonProperty(value = "lastName")
	private String lastName;
	
	@JsonProperty(value = "documentType")
	private String documentType;
	
	@JsonProperty(value = "document")
	private String document;
	
	@JsonProperty(value = "birthDate")
	private String dateNac;
	
	@JsonProperty(value = "email")
	private String email;
	
	@JsonProperty(value = "iphone")
	private String iphone;
	
	@JsonProperty(value = "address")
	private String address;	
	
	@JsonProperty(value = "createdAt")
	private Date createdAt;
	
	@JsonProperty(value = "updatedAt")
	private Date updatedAt;

	@JsonProperty(value = "plan")
	private PlanResponse plan;
}
