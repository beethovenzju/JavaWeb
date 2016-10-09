package com.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;

/*
 * ���Ź����service��ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//ע�벿�Ź����dao��
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//��ҳ��ѯ���ֵķ���
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װ��ǰҳ��ʾ������
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//ҵ��㱣�����ݵķ���
	public void save(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.save(deparement);
	}

	@Override
	//ҵ�����ݲ���ID��ѯ����
	public Department findById(int did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	@Override
	//ҵ����޸Ĳ���
	public void update(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.update(deparement);
	}

	@Override
	//ҵ���ɾ������
	public void delete(Department deparement) {
		// TODO Auto-generated method stub
		departmentDao.delete(deparement);
	}

	@Override
	//ҵ����ѯ���в���
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
}
