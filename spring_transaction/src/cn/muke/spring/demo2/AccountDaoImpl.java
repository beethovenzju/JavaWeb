package cn.muke.spring.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * ת�˰�����DAO��Ľӿ�ʵ����
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	
	/**
	 * @param out	��ת���˺�
	 * @param money	��ת�˽��
	 */
	@Override
	public void outMoney(String out, double money) {
		String hql="update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(hql, money, out);
	}

	
	/**
	 * @param out	��ת���˺�
	 * @param money	��ת�˽��
	 */
	@Override
	public void inMoney(String in, double money) {
		// TODO Auto-generated method stub
		String hql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(hql, money, in);
	}

}
