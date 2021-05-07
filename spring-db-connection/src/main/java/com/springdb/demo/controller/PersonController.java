package com.springdb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springdb.demo.model.Person;
import com.springdb.demo.persondao.PersonRepo;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addPerson")
	public String addPerson(Person person) {
		
		repo.save(person);
		return "home.jsp";
		
	}
	

	
	@RequestMapping("/getPerson")
	public ModelAndView getPerson(@RequestParam int p_id) {
		
		ModelAndView mv =new ModelAndView("showPerson.jsp");
		Person person=repo.findById(p_id).orElse(new Person());
		
		//System.out.println(repo.findByTech("java"));
		System.out.println(repo.findByPidGreaterThan(p_id));
		System.out.println(repo.findByPidLessThan(p_id));
		System.out.println(repo.findByTechSorted("java"));
		mv.addObject(person);
		return mv;
		
	}

}
