package com.employee.dao;

import java.util.List;

import com.employee.domain.Department;

/*
 * 部门管理的Dao层的接口类
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department deparement);

	Department findById(int did);

	void update(Department deparement);

	void delete(Department deparement);

	List<Department> findAll();

}
