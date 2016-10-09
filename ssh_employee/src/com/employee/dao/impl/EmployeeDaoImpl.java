package com.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.service.EmployeeService;

/*
 * 员工管理的Dao层的接口实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/*
	 * 根据用户名和密码查询用户
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
	//获取数据表中总的记录数
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
	//DAO层中保存员工信息
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	//DAO层根据员工ID查询员工
	public Employee findById(int eid) {
		// TODO Auto-generated method stub
		Employee d = this.getHibernateTemplate().get(Employee.class, eid);
		return d;
	}

	@Override
	//DAO层修改员工方法
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}

	@Override
	//DAO层中删除员工
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}

}
