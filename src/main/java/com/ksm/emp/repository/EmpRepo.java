package com.ksm.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksm.emp.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
