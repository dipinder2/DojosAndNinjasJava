package com.dipinder.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dipinder.dojoandninjas.models.Ninja;
import com.dipinder.dojoandninjas.repos.NinjaRepository;



@Service
public class NinjaService {
	// adding the ninja repository as a dependency
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	// returns all the ninjas
	public List<Ninja> allNinjas() {
		
		return ninjaRepository.findAll();
	}
	// creates a ninja
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	// retrieves a ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	public Ninja updateNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
}