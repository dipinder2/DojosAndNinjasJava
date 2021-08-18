package com.dipinder.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dipinder.dojoandninjas.models.Dojo;
import com.dipinder.dojoandninjas.repos.DojoRepository;



@Service
public class DojoService {
	// adding the dojo repository as a dependency
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	// returns all the dojos
	public List<Dojo> allDojos() {
		
		return dojoRepository.findAll();
	}
	// creates a dojo
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	// retrieves a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	public Dojo updateDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	
}