package com.dxe.spmvcmongoapp.controller;

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

import com.dxe.spmvcmongoapp.bean.Department;
import com.dxe.spmvcmongoapp.dao.DepartmentDAO;
@EnableMongoRepositories(basePackages="com.dxe.spmvcmongoapp")
@RestController
@RequestMapping("/department")

public class DepartmentController 
{
	@Autowired 
	DepartmentDAO departmentDao;
	
	@GetMapping(value="/{deptno}" ,produces="application/json")
	public ResponseEntity<Department> getDepartmentByDeptno(@PathVariable int deptno)
	{
		Department d = departmentDao.findByDeptno(deptno);
		if(d!=null) return ResponseEntity.ok(d);
		return new ResponseEntity<Department>(d,HttpStatus.NO_CONTENT);
	}
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Department>> getAllDepartments()
	{
		List<Department> dlist = departmentDao.findAll();
		if(dlist!=null) return ResponseEntity.ok(dlist);
		return new ResponseEntity<List<Department>>(dlist,HttpStatus.NO_CONTENT);
	}
	@PostMapping(consumes="application/json")
	public void insertDepartmentDetails(@RequestBody Department d)
	{
		departmentDao.save(d);
		
	}
	@DeleteMapping("/{deptno}")
	public void deleteDepartmentByDeptno(@PathVariable int deptno)
	{
		departmentDao.deleteByDeptno(deptno);
	}
}
