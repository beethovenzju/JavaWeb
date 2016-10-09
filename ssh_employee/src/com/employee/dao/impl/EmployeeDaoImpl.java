package com.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.service.EmployeeService;

/*
 * Ա�������Dao��Ľӿ�ʵ����
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/*
	 * �����û����������ѯ�û�
	 * @see com.employee.dao.EmployeeDao#findByUsernameAndPassword(com.employee.domain.EmployeeEm)
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee e where e.username=? and e.password=?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	//��ȡ���ݱ����ܵļ�¼��
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0)
			return list.get(0).intValue();
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery("from Employee");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Employee> list = query.list();
		return list;
	}

	@Override
	//DAO���б���Ա����Ϣ
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	//DAO�����Ա��ID��ѯԱ��
	public Employee findById(int eid) {
		// TODO Auto-generated method stub
		Employee d = this.getHibernateTemplate().get(Employee.class, eid);
		return d;
	}

	@Override
	//DAO���޸�Ա������
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}

	@Override
	//DAO����ɾ��Ա��
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}

}
