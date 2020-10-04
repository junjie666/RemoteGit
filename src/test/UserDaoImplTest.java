package test;

import org.junit.Test;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;


public class UserDaoImplTest
{
	@Test
	public void testQuery()
	{
		UserDao userDao=new UserDaoImpl();
		User user=userDao.getUserByUsernameAndPassword(new User(null,"zhangsan","woshizhangsan",null));
		System.out.println(user);
	}
	
	@Test
	public void testRegister()
	{
		UserDao userDao=new UserDaoImpl();
		boolean register=userDao.registeUser(new User(null,"李四","woshilisi","wanger@123456.com"));
		User user=userDao.getUserByUsernameAndPassword(new User(null,"lisi","woshilisi",null));
		System.out.println(user);
	}
}
