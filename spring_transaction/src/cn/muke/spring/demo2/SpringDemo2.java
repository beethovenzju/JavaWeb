package cn.muke.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Spring的声明式事务管理的方式一的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application2.xml")
public class SpringDemo2 {

	//注入代理类：因为代理类进行过增强
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	/*
	 * 转账案例
	 */
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
