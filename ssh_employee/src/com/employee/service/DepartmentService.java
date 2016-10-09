package com.employee.service;

import java.util.List;

import com.employee.domain.Department;
import com.employee.domain.PageBean;

/*
 * 部门管理的service层接口
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department deparement);

	Department findById(int did);

	void update(Department deparement);

	void delete(Department deparement);

	List<Department> findAll();

}
