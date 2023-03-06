package com.ksm.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ksm.emp.model.Employee;
import com.ksm.emp.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public ModelAndView homePage(Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("home");
		List<Employee> empList = service.listAll();
		model.addAttribute("listAll",empList);
		return m;
	}
	
	@GetMapping("/register")
	public ModelAndView registerEmployee()
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("register");
		return m;
	}
	
	
	@PostMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute("employee")Employee employee, Model model, BindingResult result)
	{
		boolean val= service.registerEmployee(employee);
		ModelAndView m=new ModelAndView();
		if(val)
			m.setViewName("saveddata");
		else 
			m.setViewName("emptyform");
		return m;
	}
	
	
	@GetMapping("/delete")
	public ModelAndView deleteEmployee()
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("delete");
		return m;
	}
	
	
	@PostMapping("/deleteEmp")
	public ModelAndView delete(@RequestParam int id)
	{
		ModelAndView m=new ModelAndView();
		boolean res=service.empDelete(id);
		if(res==true)
		{
			m.setViewName("deletesuccessful");
		}
		else 
		{
			m.setViewName("empnotfound");
		}
		return m;
	}
	
	
	@GetMapping("/updateEmp")
	public ModelAndView updateEmployee()
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("updateEmp");
		return m;
	}
	
	@GetMapping("/editEmp")
	public ModelAndView update(@ModelAttribute("employee")Employee employee)
	{
		ModelAndView m=new ModelAndView();
		System.out.println(employee);
		
		if(service.updateEmp(employee))
			m.setViewName("updatesuccessful");
		else
			m.setViewName("empnotfound");
		return m;
	}
	
}

