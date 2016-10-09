package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.EmployeeService;

/*
 * 员工管理的service层实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	//注入dao层类
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/*
	 * 业务层的登录方法
	 * @see com.employee.service.EmployeeService#login(com.employee.domain.Employee)
	 */
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.findByUsernameAndPassword(employee);
	}

	@Override
	//业务层分页查询
	public PageBean<Employee> findByPage(int currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页
		pageBean.setCurrPage(currPage);
		//封装每页的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage((int)num);
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	@Override
	//业务层根据员工ID查询员工
	public Employee findById(int eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}

	@Override
	//业务层修改员工方法
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	//业务层删除员工
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
	
}
