package com.andrewkim.driverlicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewkim.driverlicense.models.Person;

@Repository
public interface DriverRepository extends CrudRepository<Person, Long>{
	List <Person> findAll();
}
