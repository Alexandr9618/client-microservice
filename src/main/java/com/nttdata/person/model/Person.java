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
@Table(name="person_ids")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;
	private String firstName;
	private String lastName;
	private String documentType;
	private Date dateNac;
	private String email;
	private String iphone;
	private String address;
	private Date createdAt;
	private Date updatedAt;
}
