package com.employee.dao;

import java.util.List;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;

/*
 * Ա�������Dao��ӿ�
 */
public interface EmployeeDao{

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
