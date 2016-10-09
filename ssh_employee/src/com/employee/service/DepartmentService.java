package com.employee.service;

import java.util.List;

import com.employee.domain.Department;
import com.employee.domain.PageBean;

/*
 * ���Ź����service��ӿ�
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department deparement);

	Department findById(int did);

	void update(Department deparement);

	void delete(Department deparement);

	List<Department> findAll();

}
