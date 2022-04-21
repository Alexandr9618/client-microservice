package com.nttdata.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nttdata.person.commons.CustomMessage;
import com.nttdata.person.exceptions.ApplicationException;
import com.nttdata.person.exceptions.NotFoundException;
import com.nttdata.person.model.Person;
import com.nttdata.person.repository.PersonRepository;
import com.nttdata.person.service.PersonService;
import com.nttdata.person.util.Constantes;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person addPerson(Person person) throws ApplicationException {
		// TODO Auto-generated method stub
		try {
			return personRepository.save(person);
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationException(CustomMessage.ERR_APPLICATION_ERROR.getValue(),
					CustomMessage.ERR_APPLICATION_ERROR.toString(), e);
		}
	}

	@Override
	public List<Person> getAllPerson() throws ApplicationException {
		// TODO Auto-generated method stub
		try {
			return personRepository.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationException(CustomMessage.ERR_APPLICATION_ERROR.getValue(),
					CustomMessage.ERR_APPLICATION_ERROR.toString(), e);
		}
	}

	@Override
	public Person getPersonById(Long personId) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			return personRepository.findById(personId).orElseThrow(()->new NotFoundException(Constantes.ELEMENTO_NO_ENCONTRADO));
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException(HttpStatus.NOT_FOUND.toString(),e.getMessage());
		}
	}

}
