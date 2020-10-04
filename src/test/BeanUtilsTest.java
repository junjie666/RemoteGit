package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import bean.User;

public class BeanUtilsTest
{
	@Test
	public void test1()
	{
		/**设置属性方法 setProperty
		 * bean 代表对该对象设置属性
		 * name 代表要设置的属性名
		 * value 代表要设置的属性值
		 */
		User user=new User();
		System.out.println(user.toString());
		try
		{
			BeanUtils.setProperty(user, "username", "小明");
			//此处根据getxxx()和setxxx()来确定修改的属性
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(user.toString());
	}
	
	@Test
	public void test2()
	{
		User user=new User();
		System.out.println(user.toString());
		try
		{
			BeanUtils.setProperty(user, "id", "2342");
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(user.toString());
	}
}
