package com.nttdata.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.person.model.Person_Type;

@Repository
public interface PersonTypeRepository extends JpaRepository<Person_Type, Long>{

}
