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
import com.dipinder.dojoandninjas.services.DojoService;

@Controller
public class DojoController {
	
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}	
	
	@RequestMapping("/dojo")
	public String index(Model model) {
		List<Dojo> dojo = dojoService.allDojos();
		model.addAttribute("dojo", dojo);
		return "dojo/index.jsp";
	}
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/new.jsp";
	}
	
	@RequestMapping(value="/dojo", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojo/{id}")
	public String  show(Model model,
			@PathVariable("id") Long id) {
		
		Dojo dojo = (dojoService.findDojo(id));
		model.addAttribute("dojo",dojo);
		return "dojo/show.jsp";
	}
	
	
	@RequestMapping("/dojo/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojo/edit.jsp";
	}
	
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			dojoService.updateDojo(dojo);
			return "redirect:/dojo";
		}
	}
	
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/dojo";
	}
	
	
}