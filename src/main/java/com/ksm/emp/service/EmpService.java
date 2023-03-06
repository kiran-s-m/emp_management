package com.ksm.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.emp.model.Employee;
import com.ksm.emp.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	public List<Employee> listAll()
	{
		return empRepo.findAll();
	}
	
	public boolean registerEmployee(Employee e)
	{
		if(e.getContact_number()==0 || e.getDepartment().equals(null) || e.getEmail_address().equals(null) || e.getFirst_name().equals(null) || e.getLast_name().equals(null) || e.getPosition().equals(null))
		{
			return false;
		}
		else
		{
			empRepo.save(e);
			return true;
		}
	}
	
	public Optional<Employee> findEmployee(int id)
	{
		Optional<Employee> e=empRepo.findById(id);
		return e;
	}
	
	public boolean empDelete(int id)
	{
		Optional<Employee> e=empRepo.findById(id);
		if(e.isPresent())
		{
			empRepo.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	public boolean update(int id)
	{
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent())
			return true;
		else
			return false;
	}
	
	public boolean updateEmp(Employee e)
	{
		Optional<Employee> emp=empRepo.findById(e.getId());
		
		if(emp.isPresent())
		{
			empRepo.save(e);
			return true;
		}
		else
			return false;
	}
	
	
}
