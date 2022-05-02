package com.nttdata.person.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlanResponse {

	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "creditQuantity")
	private String creditQuantity;
	
	@JsonProperty(value = "createdAt")
    private Date createdAt;

    @JsonProperty(value = "updatedAt")
    private Date updatedAt;
}
