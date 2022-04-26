package com.nttdata.person.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonIdsResponse {

	@JsonProperty(value = "personIdsId")
	private String personIdsId;
	
	@JsonProperty(value = "personTypeId")
	private String  personTypeId;
	
	@JsonProperty(value = "personId")
	private String  personId;
}
