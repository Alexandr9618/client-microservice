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

	/**
	 * @param personTypeId
	 * @param personId
	 */
	public PersonIdsResponse(String personTypeId, String personId) {
		super();
		this.personTypeId = personTypeId;
		this.personId = personId;
	}
	
	
}
