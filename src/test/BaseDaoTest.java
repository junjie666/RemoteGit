package test;

import org.junit.Test;

import bean.User;
import dao.impl.UserDaoImpl;

public class BaseDaoTest
{
	@Test
	public void test()
	{
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		String sql="select * from book_user where id=1";
		User user=userDaoImpl.getBean(sql, null);
		System.out.println(user);
	}
	
	@Test
	public void batch()
	{
		
	}
}
