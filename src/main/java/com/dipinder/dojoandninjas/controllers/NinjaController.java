package com.dipinder.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dipinder.dojoandninjas.models.Dojo;
import com.dipinder.dojoandninjas.models.Ninja;
import com.dipinder.dojoandninjas.services.DojoService;
import com.dipinder.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService,DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping("/ninja")
	public String index(Model model) {
		List<Ninja> ninja = ninjaService.allNinjas();
		model.addAttribute("ninja", ninja);
		
		return "ninja/index.jsp";
	}
	
	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,
			@ModelAttribute("dojo") Dojo dojo,
			Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja/new.jsp";
	}
	
	@RequestMapping(value="/ninja", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "ninja/new.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/ninja/{id}")
	public String  show(Model model,
			@PathVariable("id") Long id) {
		
		Ninja ninja = (ninjaService.findNinja(id));
		model.addAttribute("ninja",ninja);
		return "ninja/show.jsp";
	}
	
	
	@RequestMapping("/ninja/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "ninja/edit.jsp";
	}
	
	@RequestMapping(value="/ninja/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			ninjaService.updateNinja(ninja);
			return "redirect:/ninja";
		}
	}
	
	@RequestMapping(value="/ninja/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/ninja";
	}

}