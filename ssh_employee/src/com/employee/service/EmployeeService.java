package com.employee.service;

import com.employee.domain.Employee;
import com.employee.domain.PageBean;

/*
 * 员工管理的service层接口
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int currPage);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
