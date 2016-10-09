package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;

/*
 * 部门管理的service层实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//注入部门管理的dao类
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//分页查询部分的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装当前页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存数据的方法
	public void save(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.save(deparement);
	}

	@Override
	//业务层根据部门ID查询部门
	public Department findById(int did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	@Override
	//业务层修改部门
	public void update(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.update(deparement);
	}

	@Override
	//业务层删除部门
	public void delete(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.delete(deparement);
	}

	@Override
	//业务层查询所有部门
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
}
