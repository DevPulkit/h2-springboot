package com.springdb.demo.persondao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springdb.demo.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {
	
	List<Person> findByTech(String tech);
	
	List<Person> findByPidGreaterThan(int pid);
	
	List<Person> findByPidLessThan(int pid);
	
	@Query("from Person where tech=?1 order by p_name")
	List<Person> findByTechSorted(String tech);
	

	

}
