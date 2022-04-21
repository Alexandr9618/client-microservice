package com.nttdata.person.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="person_type")
public class Person_Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personTypeId;
	private String name;
	private Date createdAt;
	private Date updatedAt;
}
