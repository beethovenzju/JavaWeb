package com.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;

/*
 * 部门管理的Dao层的实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	/*
	 * 统计记录总个数
	 * @see com.employee.dao.DepartmentDao#findCount()
	 */
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = (List<Long>)this.getHibernateTemplate().find(hql);
		if(list.size() > 0)
			return list.get(0).intValue();
		return 0;
	}

	@Override
	/*
	 * 分页查询部门
	 * @see com.employee.dao.DepartmentDao#findByPage(int, int)
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery("from Department");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list = query.list();
		return list;
	}

	@Override
	//dao中保存部门的方法
	public void save(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(deparement);
	}

	@Override
	//DAO中根据部门的ID查询部门的方法
	public Department findById(int did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO中更新部门的方法
	public void update(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(deparement);
	}

	@Override
	//DAO中删除部门的的方法
	public void delete(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(deparement);
	}

	@Override
	//DAO中查询所有部门的方法
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
