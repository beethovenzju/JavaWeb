package cn.muke.spring.demo3;
/*
 * ת�˰�����ҵ���ӿ�
 */
public interface AccountService {

	/**
	 * 
	 * @param out	��ת���˺�
	 * @param in	��ת���˺�
	 * @param money	��ת�˽��
	 */
	void transfer(String out, String in, Double money);
}
