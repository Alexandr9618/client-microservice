package com.nttdata.person.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nttdata.person.dto.PersonSupplierDTO;
import com.nttdata.person.model.Person;

@Mapper
public interface IPersonSupplierMapperService {

	IPersonSupplierMapperService INSTANCE=Mappers.getMapper(IPersonSupplierMapperService.class);
	
	PersonSupplierDTO convertPersonToPersonSupplierDTO(Person person);
	Person convertPersonSupplierDTOToPerson(PersonSupplierDTO person);
}
