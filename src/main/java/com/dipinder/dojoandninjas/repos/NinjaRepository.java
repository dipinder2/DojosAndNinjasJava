package com.dipinder.dojoandninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dipinder.dojoandninjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	// this method retrieves all the ninjas from the database
	List<Ninja> findAll();
	//User findByEmail(String email);
}
