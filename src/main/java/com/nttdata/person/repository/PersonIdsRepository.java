package com.nttdata.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.person.model.Person_Ids;

@Repository
public interface PersonIdsRepository extends JpaRepository<Person_Ids, Long>{

}
