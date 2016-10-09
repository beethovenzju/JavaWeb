package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.EmployeeService;

/*
 * Ա�������service��ʵ����
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	//ע��dao����
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/*
	 * ҵ���ĵ�¼����
	 * @see com.employee.service.EmployeeService#login(com.employee.domain.Employee)
	 */
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.findByUsernameAndPassword(employee);
	}

	@Override
	//ҵ����ҳ��ѯ
	public PageBean<Employee> findByPage(int currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ
		pageBean.setCurrPage(currPage);
		//��װÿҳ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage((int)num);
		//��װÿҳ��ʾ������
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
	//ҵ������Ա��ID��ѯԱ��
	public Employee findById(int eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}

	@Override
	//ҵ����޸�Ա������
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	//ҵ���ɾ��Ա��
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
	
}
