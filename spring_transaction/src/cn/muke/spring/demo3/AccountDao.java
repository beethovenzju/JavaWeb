package cn.muke.spring.demo3;
/*
 * 转账案例的DAO层的接口
 */
public interface AccountDao {

	/**
	 * @param out	：转出账号
	 * @param money	：转账金额
	 */
	void outMoney(String out, double money);
	
	/**
	 * @param out	：转入账号
	 * @param money	：转账金额
	 */
	void inMoney(String in, double money);
}
