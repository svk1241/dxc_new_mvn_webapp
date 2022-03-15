package com.dxc.spmvcmongoappemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.spmvcmongoappemp.bean.Employee;
import com.dxc.spmvcmongoappemp.dao.EmployeeDAO;

@EnableMongoRepositories(basePackages="com.dxc.spmvcmongoappemp")
@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired 
	EmployeeDAO employeeDao;
	
	@GetMapping(value="/{empno}" ,produces="application/json")
	public ResponseEntity<Employee> getEmployeeByEmpno(@PathVariable int empno)
	{
	    Employee e  = employeeDao.findByEmpno(empno);
		if(e!=null) return ResponseEntity.ok(e);
		return new ResponseEntity<Employee>(e,HttpStatus.NO_CONTENT);
	}
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> elist = employeeDao.findAll();
		if(elist!=null) return ResponseEntity.ok(elist);
		return new ResponseEntity<List<Employee>>(elist,HttpStatus.NO_CONTENT);
	}
	@PostMapping(consumes="application/json")
	public void insertEmployeeDetails(@RequestBody Employee e)
	{
		employeeDao.save(e);
		
	}
	@DeleteMapping("/{empno}")
	public void deleteEmployeeByEmpno(@PathVariable int empno)
	{
		employeeDao.deleteByEmpno(empno);
	}

}
