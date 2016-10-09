package com.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;

/*
 * ���Ź����Dao���ʵ����
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	/*
	 * ͳ�Ƽ�¼�ܸ���
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
	 * ��ҳ��ѯ����
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
	//dao�б��沿�ŵķ���
	public void save(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(deparement);
	}

	@Override
	//DAO�и��ݲ��ŵ�ID��ѯ���ŵķ���
	public Department findById(int did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO�и��²��ŵķ���
	public void update(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(deparement);
	}

	@Override
	//DAO��ɾ�����ŵĵķ���
	public void delete(Department deparement) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(deparement);
	}

	@Override
	//DAO�в�ѯ���в��ŵķ���
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
