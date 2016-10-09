package cn.muke.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Spring������ʽ�������ķ�ʽһ�Ĳ�����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application2.xml")
public class SpringDemo2 {

	//ע������ࣺ��Ϊ��������й���ǿ
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	/*
	 * ת�˰���
	 */
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
