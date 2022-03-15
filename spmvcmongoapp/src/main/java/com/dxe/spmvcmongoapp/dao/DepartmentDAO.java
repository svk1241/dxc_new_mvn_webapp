package com.dxe.spmvcmongoapp.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxe.spmvcmongoapp.bean.Department;

public interface DepartmentDAO  extends MongoRepository<Department,ObjectId>
{
	Department findByDeptno(int deptno);
	void deleteByDeptno(int deptno);
}


