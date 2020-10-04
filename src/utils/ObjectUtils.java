package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import bean.Cart;

/**
 * 
 * @author shenjunjie
 *
 */
public class ObjectUtils
{
	/**
	 * 通过request封装对象
	 * @param request
	 * @param t
	 * @return
	 */
	public static<T> T param2bean(HttpServletRequest request,T t)
	{
		//1.获取声明的属性
		Field[] fields=t.getClass().getDeclaredFields();
		for(Field field:fields)
		{
			String name=field.getName();
			String value=request.getParameter(name);
			try
			{
				BeanUtils.setProperty(t, name, value);
			}
			catch (Exception e)
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request,T t)
	{
		Map map=request.getParameterMap();
		try
		{
			//此方法将请求中的map映射到bean中
			BeanUtils.populate(t, map);
		}
		catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return t;
	}

	public static Cart getCart(HttpServletRequest request)
	{
		// TODO 自动生成的方法存根
		HttpSession session = request.getSession();
		if(session.getAttribute("cart")==null)
		{
			session.setAttribute("cart", new Cart());
		}
		return (Cart) session.getAttribute("cart");
	}
}
