package cn.muke.spring.demo3;
/*
 * ת�˰�����DAO��Ľӿ�
 */
public interface AccountDao {

	/**
	 * @param out	��ת���˺�
	 * @param money	��ת�˽��
	 */
	void outMoney(String out, double money);
	
	/**
	 * @param out	��ת���˺�
	 * @param money	��ת�˽��
	 */
	void inMoney(String in, double money);
}
