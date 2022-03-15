package com.dxc.spmvcmongoappemp.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxc.spmvcmongoappemp.bean.Employee;

public interface EmployeeDAO extends MongoRepository<Employee,ObjectId>
{
	Employee findByEmpno(int empno);
	void deleteByEmpno(int empno);

}
