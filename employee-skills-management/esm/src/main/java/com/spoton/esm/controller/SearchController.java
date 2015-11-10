package com.spoton.esm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spoton.esm.model.Skill;
import com.spoton.esm.service.EmployeeService;
import com.spoton.esm.service.SkillService;

@Controller
public class SearchController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillService skillService;

	@RequestMapping(value = "/showSearchEmployeeBySkill", method = RequestMethod.GET)
	public ModelAndView showSearchEmployeeBySkill(Model model) {
		model.addAttribute("skill", new Skill());
		return new ModelAndView("showSearchEmployeeBySkill");
	}

	@RequestMapping(value = "/searchEmployeeBySkill", method = RequestMethod.POST)
	public ModelAndView searchEmployeeBySkill(@Valid @ModelAttribute("skill") Skill skill, BindingResult result, Model model) {
		model.addAttribute("skillSearched", skill);
		model.addAttribute("employees", employeeService.searchEmployeeBySkill(skill));
		return new ModelAndView("searchEmployeeBySkillResult");
	}
}
