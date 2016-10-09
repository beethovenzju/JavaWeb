package cn.muke.spring.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * 转账案例的DAO层的接口实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	
	/**
	 * @param out	：转出账号
	 * @param money	：转账金额
	 */
	@Override
	public void outMoney(String out, double money) {
		String hql="update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(hql, money, out);
	}

	
	/**
	 * @param out	：转入账号
	 * @param money	：转账金额
	 */
	@Override
	public void inMoney(String in, double money) {
		// TODO Auto-generated method stub
		String hql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(hql, money, in);
	}

}
