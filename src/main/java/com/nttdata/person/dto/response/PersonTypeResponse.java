package com.nttdata.person.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonTypeResponse {

	@JsonProperty(value = "personTypeId")
	private String personTypeId;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "createdAt")
    private Date createdAt;

    @JsonProperty(value = "updatedAt")
    private Date updatedAt;
}
