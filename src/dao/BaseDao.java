package dao;

/**
 * 基本操作 增删改查
 */

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.JDBCUtils;

public class BaseDao<T>
{
	
	private QueryRunner runner=new QueryRunner();
	
	//获取实际的type
	private Class<T> type;
	
	public BaseDao()
	{
		// TODO 自动生成的构造函数存根
		//获取父类类型,父类是带参数的
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		type=(Class<T>) superclass.getActualTypeArguments()[0];
//		System.out.println(type);
	}
	
	//1.获取单个对象
	public T getBean(String sql,Object ...params)
	{
		Connection connection=JDBCUtils.getConnection();
		T result=null;
		try
		{
			result=runner.query(connection, sql, new BeanHandler<T>(type), params);
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			JDBCUtils.releaseConnection(connection);
		}
		return result;
	}
	
	//2.获取多个对象
	public List<T> getBeanList(String sql,Object ...params)
	{
		Connection connection=JDBCUtils.getConnection();
		List<T> results=null;
		try
		{
			results=runner.query(connection, sql, new BeanListHandler<T>(type), params);
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			JDBCUtils.releaseConnection(connection);
		}
		return results;
	}
	
	//3/增删改
	public int update(String sql,Object ...params)
	{
		Connection connection=JDBCUtils.getConnection();
		int count=0;
		try
		{
			count=runner.update(connection, sql, params);
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			JDBCUtils.releaseConnection(connection);
		}
		return count;
	}
	
	/**
	 * 查询单个值的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingleValue(String sql,Object ...params)
	{
		Connection connection=JDBCUtils.getConnection();
		Object query = null;
		try
		{
			query=runner.query(connection, sql,new ScalarHandler<T>() , params );
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	
	/**
	 * 批处理方法
	 */
	public void batch(String sql, Object[][] params)
	{
		Connection connection = JDBCUtils.getConnection();
		try
		{
			// Object[][] params
			// 第一维长度代表执行次数，一组参数执行一次
			// 第二维放可变参数
			runner.batch(connection, sql, params);
		}
		catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			JDBCUtils.releaseConnection(connection);
		}
	}
}
