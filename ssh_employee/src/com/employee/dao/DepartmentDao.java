package com.employee.dao;

import java.util.List;

import com.employee.domain.Department;

/*
 * ���Ź����Dao��Ľӿ���
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
