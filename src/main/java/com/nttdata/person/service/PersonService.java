package com.nttdata.person.service;

import java.util.List;

import com.nttdata.person.exceptions.ApplicationException;
import com.nttdata.person.exceptions.NotFoundException;
import com.nttdata.person.model.Person;

public interface PersonService {

	Person addPerson(Person person) throws ApplicationException;
	List<Person> getAllPerson() throws ApplicationException;
	Person getPersonById(Long personId) throws NotFoundException;
}
