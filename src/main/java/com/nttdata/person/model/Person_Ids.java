package com.nttdata.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="person_ids")
public class Person_Ids {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personIdsId;
	private Long  personTypeId;
	private Long  personId;
}
